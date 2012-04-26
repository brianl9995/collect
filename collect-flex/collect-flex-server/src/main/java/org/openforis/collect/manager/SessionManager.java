package org.openforis.collect.manager;

import java.util.Collection;
import java.util.Locale;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.granite.context.GraniteContext;
import org.openforis.collect.model.CollectRecord;
import org.openforis.collect.model.User;
import org.openforis.collect.persistence.RecordUnlockedException;
import org.openforis.collect.web.session.InvalidSessionException;
import org.openforis.collect.web.session.SessionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;

/**
 * 
 * @author M. Togna
 */
public class SessionManager {

	private static Log LOG = LogFactory.getLog(SessionManager.class);

	@Autowired
	private UserManager userManager;
	
	@Autowired
	protected RecordManager recordManager;

	public SessionState getSessionState() {
		SessionState sessionState = (SessionState) getSessionAttribute(SessionState.SESSION_ATTRIBUTE_NAME);
		if (sessionState == null) {
			throw new InvalidSessionException();
		}
		User user = getLoggedInUser();
		sessionState.setUser(user);

		return sessionState;
	}
	
	public void setActiveRecord(CollectRecord record) {
		SessionState sessionState = getSessionState();
		sessionState.setActiveRecord(record);
	}

	public void clearActiveRecord() {
		SessionState sessionState = getSessionState();
		sessionState.setActiveRecord(null);
	}

	public void keepSessionAlive() {
		getSessionState();
		if (LOG.isDebugEnabled()) {
			LOG.debug("Keep alive request received");
		}
	}

	public void setLocale(String string) {
		StringTokenizer stringTokenizer = new StringTokenizer(string, "_");
		int tokens = stringTokenizer.countTokens();
		if (tokens < 1 || tokens > 2) {
			throw new IllegalArgumentException("Invalid locale string: " + string);
		}
		String language = stringTokenizer.nextToken();
		String country = "";
		if (stringTokenizer.hasMoreTokens()) {
			country = stringTokenizer.nextToken();
		}
		Locale locale = new Locale(language, country);
		SessionState sessionState = getSessionState();
		sessionState.setLocale(locale);
	}

	@Transactional
	public void checkUserIsLockingActiveRecord(String lockId) throws RecordUnlockedException {
		SessionState sessionState = getSessionState();
		CollectRecord record = sessionState.getActiveRecord();
		User user = sessionState.getUser();
		Integer userId = user.getId();
		if ( record != null && record.getId() != null) {
			Integer recordId = record.getId();
			//verify that the record has not been unlocked
			boolean isLocking = recordManager.isLocking(userId, recordId, lockId);
			if( ! isLocking ) {
				Integer lockingUserId = recordManager.getLockingUserId(recordId);
				if ( lockingUserId != userId ) {
					clearActiveRecord();
				}
				String lockingUserName = null;
				if(lockingUserId != null) {
					User lockingUser = userManager.loadById(lockingUserId);
					lockingUserName = lockingUser.getName();
					throw new RecordUnlockedException(lockingUserName);
				} else {
					throw new RecordUnlockedException();
				}
			}
		}
	}
	
	private User getLoggedInUser() {
		SessionState sessionState = (SessionState) getSessionAttribute(SessionState.SESSION_ATTRIBUTE_NAME);
		if (sessionState != null) {
			User user = sessionState.getUser();
			if (user == null) {
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				String name = authentication.getName();
				Integer userId = userManager.getUserId(name);
				user = new User(userId, name);
				Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
				for (GrantedAuthority grantedAuthority : authorities) {
					user.addRole(grantedAuthority.getAuthority());
				}
			}
			return user;
		} else {
			return null;
		}
	}

	private Object getSessionAttribute(String attributeName) {
		GraniteContext graniteContext = GraniteContext.getCurrentInstance();
		if (graniteContext != null) {
			Object result = graniteContext.getSessionMap().get(attributeName);
			return result;
		} else {
			throw new IllegalStateException("Error getting session info");
		}
	}
	
}
