import React,{Component} from 'react'
import './Header.css'

import {Navbar,Nav,Form,Button,Image} from 'react-bootstrap'

class Header extends Component {

    

   

    render() {
        return (
            <Navbar bg="dark" variant="dark">
            <Image src="../../assets/Logo.png" fluid />
            <Nav className="mr-auto">
              <Nav.Link href="#home">Home</Nav.Link>
              <Nav.Link href="#aboutme">About us</Nav.Link>
              <Nav.Link href="#contactme">Contact me</Nav.Link>
            </Nav>
            <Form inline>
              <Button variant="outline-info">Login</Button>
              <Button variant="outline-info">Register</Button>
            </Form>
          </Navbar>
        )
    }


}
export default Header