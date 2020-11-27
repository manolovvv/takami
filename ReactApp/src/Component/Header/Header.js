import React,{Component} from 'react'
import './Header.css'
import {Link} from 'react-router-dom'
import {Navbar,Nav,Form,Button,Image} from 'react-bootstrap'
import LoginAndRegisterButtonsInHeader from './LoginAndRegisterButtonsInHeader'
import LogoutButtonInHeader from './LogoutButtonInHeader'

class Header extends Component {

    

   

    render() {
        return (
            <Navbar bg="dark" variant="dark">
            <Link to="/products">
            <Image src="../../assets/Logo.png" fluid />
            </Link>
            <Nav className="mr-auto">
              <Nav.Link href="#home">Home</Nav.Link>
              <Nav.Link href="#aboutme">About me</Nav.Link>
              <Nav.Link href="#contactme">Contact me</Nav.Link>
            </Nav>
                <LoginAndRegisterButtonsInHeader/>
            <Form inline>
             
            </Form>
          </Navbar>
        )
    }


}
export default Header