import React, { useState } from 'react'
import { Form, Button } from 'react-bootstrap'
import AuthService from '../../Service/AuthService'

const RegisterForm = () => {
    const[username,setUsername]=useState("")
    const[password,setPassword]=useState("")
    const[email,setEmail]=useState("")
    const[firstName,setFirstName]=useState("")
    const[familyName,setFamilyName]=useState("")
    const[address,setAddress]=useState("")


    const handleChangeUsername = (event) => {
        setUsername(event.target.value)
    }


    const handleChangePassword = (event) => {
        setPassword(event.target.value)
    }

    const handleChangeEmail = (event) => {
        setEmail(event.target.value)
    }

    const handleChangeFirstName = (event) => {
        setFirstName(event.target.value)
    }

    const handleChangeFamilyName = (event) => {
        setFamilyName(event.target.value)
    }
    const handleChangeAddress = (event) => {
        setAddress(event.target.value)
    }
    
    const handleSubmit = (event) => {
        console.log("DADS")
        event.preventDefault();
     

            AuthService.register(username, password,email,firstName,familyName,address).then((res) => {
           
            alert(res.data);
            this.props.history.push('/products');
        }).catch(error => alert(error));
        event.preventDefault();
    }

   
    return (
        <div>
            <br />
            <br />
            <br />
            <Form onSubmit={handleSubmit} className= "mt-5 mr-5 ml-5 mb-5">
                <Form.Group controlId="formBasicUsername">
                    <Form.Label className ="font-weight-bold">Username:</Form.Label>
                    <Form.Control type="text" placeholder="Enter Username" name="username"  onChange={handleChangeUsername} />
                </Form.Group>

                <Form.Group controlId="formBasicPassword">
                    <Form.Label className ="font-weight-bold">Password:</Form.Label>
                    <Form.Control type="password" placeholder="Password" name="password"  onChange={handleChangePassword} />
                </Form.Group>

                <Form.Group controlId="formBasicEmail">
                    <Form.Label className ="font-weight-bold">Email:</Form.Label>
                    <Form.Control type="email" placeholder="Email" name="email"  onChange={handleChangeEmail} />
                </Form.Group>

                <Form.Group controlId="formBasicFirstName">
                    <Form.Label className ="font-weight-bold">First name:</Form.Label>
                    <Form.Control type="text" placeholder="First name" name="firstName" value={firstName} onChange={handleChangeFirstName} />
                </Form.Group>

                <Form.Group controlId="formBasicFamilyName">
                    <Form.Label className ="font-weight-bold">Family name:</Form.Label>
                    <Form.Control type="text" placeholder="Family name" name="familyName" value={familyName} onChange={handleChangeFamilyName} />
                </Form.Group>

                <Form.Group controlId="formBasicAddress">
                    <Form.Label className ="font-weight-bold">Address:</Form.Label>
                    <Form.Control type="text" placeholder="Address" name="address" value={address} onChange={handleChangeAddress} />
                </Form.Group>

                <Button variant="primary" type="submit" onClick={handleSubmit}>
                    Register
                    </Button>
            </Form>
        </div>

    )
}

export default RegisterForm;