import React, { useState } from 'react'
import {withRouter} from 'react-router-dom'
import { Form, Button } from 'react-bootstrap'
import AuthService from '../../Service/AuthService'

const LoginForm = () => {
    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    // this.handleSubmit = this.handleSubmit.bind(this);
    // this.handleChange = this.handleChange.bind(this);



    const handleChangeUsername = (event) => {
        setUsername(event.target.value)
        console.log(username)
    }


    const handleChangePassword = (event) => {
        setPassword(event.target.value)
        console.log(username)
    }

    const handleSubmit = (event) => {
        console.log("DASDA")
        event.preventDefault();


        AuthService.login(username, password).then((res) => {
            sessionStorage.clear();
            console.log(res);
            sessionStorage.setItem('JWTToken', res.data.jwt);
            console.log(sessionStorage.getItem('JWTToken'));
            sessionStorage.setItem("loggedIn", true);
            sessionStorage.setItem("loggedInNow", true);
            sessionStorage.setItem("role", res.data.role);
            sessionStorage.setItem("id", res.data.id);
            this.props.history.push('/products');
            window.location.reload()

        }).catch(error => alert(error));
        event.preventDefault();

    }
    return (
        <div>
            <br />
            <br />
            <br />
            <Form id="login_form">
                <Form.Group >
                    <Form.Label>Enter your email</Form.Label>
                    <Form.Control type="text" onChange={handleChangeUsername} placeholder="Enter your username" />
                </Form.Group>
                <Form.Group >
                    <Form.Label>Enter your password</Form.Label>
                    <Form.Control type="password" onChange={handleChangePassword} placeholder="Enter your password" />
                </Form.Group>
                <Button type="submit" onClick={handleSubmit}>Login</Button>
            </Form>
        </div>

    )
}

export default withRouter(LoginForm);