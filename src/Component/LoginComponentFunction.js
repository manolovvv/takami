import React, { Component, useEffect, useState } from 'react'
import { Form, Button } from 'react-bootstrap'

import AuthService from '../Service/AuthService'

const LoginComponent =(props)=> {

    const[username,setUsername] = useState("");
    const[password,setPassword] = useState("");
    // constructor(props) {
    //     super(props)
    //     this.state = {
    //         username: "",
    //         password: ""

    //     };

    //     this.handleSubmit = this.handleSubmit.bind(this);
    //     this.handleChange = this.handleChange.bind(this);

    // };

    // this.handleSubmit = this.handleSubmit.bind(this);
    // this.handleChange = this.handleChange.bind(this);

    const handleChange = event =>{
        // this.setState({
        //     [event.target.name]: event.target.value
        // });
        //console.log(event.target.name);
        if(event.target.name==="username"){
            setUsername(event.target.value);
            console.log(username);
        }
        if(event.target.name==="password"){
            setPassword(event.target.value);
            console.log(password);
        }
    }

    function handleSubmit  (event) {
        console.log(5);
        console.log("zastho");
        AuthService.login(username, password).then((res) => {
            //sessionStorage.clear();
            console.log(res);
            sessionStorage.setItem('JWTToken', res.data.jwt);
            console.log(sessionStorage.getItem('JWTToken'));
            sessionStorage.setItem("loggedIn", true);
            sessionStorage.setItem("role", res.data.role);
            sessionStorage.setItem("id", res.data.id);
           console.log("ogoog")
            

        })
        window.location.href = "/products"
       // window.location.reload();
        console.log(5);
       
        

    }

    useEffect(()=>{
        console.log(sessionStorage.getItem('role'))
        
        
    })


    
        return (

            <Form onSubmit={handleSubmit}>
                <Form.Group controlId="formBasicUsername">
                    <Form.Label>Username</Form.Label>
                    <Form.Control type="text" placeholder="Enter Username" name="username" value={username} onChange={handleChange} />
                </Form.Group>

                <Form.Group controlId="formBasicPassword">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" placeholder="Password" name="password" value={password} onChange={handleChange} />
                </Form.Group>
                <Button variant="primary" type="submit" /*onClick={handleSubmit}*/>
                    Login
  </Button>
            </Form>

        )

    


}
export default LoginComponent;