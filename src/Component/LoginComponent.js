import React, { Component } from 'react'
import { Form, Button } from 'react-bootstrap'
import LoginService from '../Service/LoginService'

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
        
        LoginService.login(username, password).then((res) => {
           alert(res.data);
           
        })
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
                <Button variant="primary" type="submit">
                    Submit
  </Button>
            </Form>

        )

    }


}
export default LoginComponent;