import React, { Component, PropTypes } from 'react'
import { Container, TabContent, TabPane, Nav, NavItem, NavLink, Card, Button, CardTitle, CardText, Row, Col } from 'reactstrap';
import classnames from 'classnames';
import FormItem from './FormItem'

export default class FormItems extends Component {

    constructor(props) {
        super(props)
    }

    render() {
        let itemDefs = this.props.itemDefs
        let formItems = itemDefs.map(itemDef => 
            <FormItem key={itemDef.id} parentEntity={this.props.parentEntity} itemDef={itemDef} />
        )
        return (
            <Container className="formItems">
                {formItems}
            </Container>
        )
    }
}
