import React, { Component } from 'react'
import {Form,Button} from 'react-bootstrap'
import AuthService from '../Service/AuthService'
import { Redirect, Route, useHistory,withRouter } from 'react-router-dom'

class RegisterComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            username: "",
            password: "",
            email:"",
            firstName:"",
            familyName:"",
            address:""


        };

       this.handleSubmit = this.handleSubmit.bind(this);
        this.handleChange = this.handleChange.bind(this);

    };

    handleChange(event) {
        this.setState({
            [event.target.name]: event.target.value
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        const { username, password,email,firstName,familyName,address } = this.state;
        console.log(this.state);

            AuthService.register(username, password,email,firstName,familyName,address).then((res) => {
            // sessionStorage.clear();
            // console.log(res);
            // sessionStorage.setItem('JWTToken', res.data.jwt);
            // console.log(sessionStorage.getItem('JWTToken'));
            // sessionStorage.setItem("loggedIn", true);
            // sessionStorage.setItem("role",res.data.role);
            
            alert(res.data);
            this.props.history.push('/products');
        })
        
        
        
       
    }

    render() {
        return (

            <Form onSubmit={this.handleSubmit}>
                <Form.Group controlId="formBasicUsername">
                    <Form.Label>Username</Form.Label>
                    <Form.Control type="text" placeholder="Enter Username" name="username" value={this.state.username} onChange={this.handleChange} />
                </Form.Group>

                <Form.Group controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" name="password" value={this.state.password} onChange={this.handleChange} />
                </Form.Group>

                <Form.Group controlId="formBasicEmail">
                    <Form.Label>Email</Form.Label>
                    <Form.Control type="email" placeholder="Email" name="email" value={this.state.email} onChange={this.handleChange} />
                </Form.Group>

                <Form.Group controlId="formBasicFirstName">
                    <Form.Label>First name</Form.Label>
                    <Form.Control type="text" placeholder="First name" name="firstName" value={this.state.firstName} onChange={this.handleChange} />
                </Form.Group>

                <Form.Group controlId="formBasicFamilyName">
                    <Form.Label>Family name</Form.Label>
                    <Form.Control type="text" placeholder="Family name" name="familyName" value={this.state.familyName} onChange={this.handleChange} />
                </Form.Group>

                <Form.Group controlId="formBasicAddress">
                    <Form.Label>Address</Form.Label>
                    <Form.Control type="text" placeholder="Address" name="address" value={this.state.address} onChange={this.handleChange} />
                </Form.Group>

                <Button variant="primary" type="submit" onClick={this.handleSubmit}>
                    Register
                    </Button>
            </Form>

        )

    }

}

export default withRouter(RegisterComponent);