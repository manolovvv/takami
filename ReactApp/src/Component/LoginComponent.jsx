import React, { Component } from 'react'
import { Form, Button } from 'react-bootstrap'
import { withRouter } from 'react-router-dom'
import AuthService from '../Service/AuthService'
import LoginForm from './fragments/LoginForm.jsx'
import LoginRight from './fragments/LoginRight.jsx'
import { Row, Col } from 'react-bootstrap'
import './LoginComponent.css'

const LoginComponent = (props) => {

    return (

        <Row className="landing mr-0" xs={1} sm={1} md={1} lg={2} >
            <Col ><LoginForm /></Col>
            <Col > <LoginRight /></Col>
        </Row>
    )




}
export default withRouter(LoginComponent);
