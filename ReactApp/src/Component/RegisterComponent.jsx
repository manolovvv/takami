import React from 'react'
import {Row,Col} from 'react-bootstrap'
import { withRouter } from 'react-router-dom'
import RegisterForm from './fragments/RegisterForm.jsx'
import RegisterRight from './fragments/RegisterRight.jsx'
import "./RegisterComponent.css"

const RegisterComponent =(props)=> {


    
        return (
       
            <Row className="landing mr-0" xs={1} sm={1} md={1} lg={2} >
            <Col ><RegisterForm /></Col>

            <Col > <RegisterRight /></Col>
             </Row>
         

        )

    

}

export default withRouter(RegisterComponent);