import React, { Component } from 'react'
import { connect } from 'react-redux'

import Constants from 'Constants'
import MaxAvailableSpaceContainer from 'common/components/MaxAvailableSpaceContainer'
import ServiceFactory from 'services/ServiceFactory'

class OldClientRecordEditPage extends Component {

    constructor(props) {
        super(props)

        this.state = {
            loading: true,
            surveyId: null,
            recordId: null
        }
    }

    componentDidMount() {
        const recordId = this.getRecordIdFromParams()

        ServiceFactory.recordService.fetchSurveyId(recordId).then(res => {
            const surveyId = parseInt(res, 10)
            this.setState({
                loading: false,
                surveyId: surveyId,
                recordId: recordId
            })
        })
    }
    
    componentWillUnmount() {
    	const { surveyId, recordId } = this.state
    	ServiceFactory.recordService.releaseLock(surveyId, recordId)
    }
    
    getRecordIdFromParams () {
        const idParam = this.props.match.params.id;
        return parseInt(idParam, 10);
    }

    render() {
        const { surveyLanguage } = this.props
        const { loading, surveyId, recordId } = this.state

        if (loading) {
            return <div>Loading...</div>
        }
        const url = Constants.BASE_URL + 'old_client.html?'
            + 'edit=true'
            + '&surveyId=' + surveyId 
            + '&recordId=' + recordId
            + '&locale=' + surveyLanguage
        return (
            <MaxAvailableSpaceContainer>
                <iframe src={url}
                    title="Open Foris Collect - Edit Record"
                    width="100%" height="100%" />
            </MaxAvailableSpaceContainer>
        )
    }
}

const mapStateToProps = state => {
	return {
        surveyLanguage: state.activeSurvey ? state.activeSurvey.language : null
	}
}

export default connect(mapStateToProps)(OldClientRecordEditPage)