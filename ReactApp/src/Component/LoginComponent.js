import React, { Component } from 'react'
import { Form, Button } from 'react-bootstrap'
import { withRouter } from 'react-router-dom'
import AuthService from '../Service/AuthService'

class LoginComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            username: "",
            password: ""

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
        const { username, password } = this.state;

            AuthService.login(username, password).then((res) => {
            sessionStorage.clear();
            console.log(res);
            sessionStorage.setItem('JWTToken', res.data.jwt);
            console.log(sessionStorage.getItem('JWTToken'));
            sessionStorage.setItem("loggedIn", true);
            sessionStorage.setItem("loggedInNow", true);
            sessionStorage.setItem("role",res.data.role);
            sessionStorage.setItem("id",res.data.id);
            this.props.history.push('/products');
            window.location.reload()
            
        }).catch(error => alert("Bad credentials"));
        event.preventDefault();
        
        
       
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
                <Button variant="primary" type="submit" onClick= {this.handleSubmit}>
                    Login
  </Button>
            </Form>

        )

    }


}
export default withRouter(LoginComponent);
