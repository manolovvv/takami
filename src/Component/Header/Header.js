import React, { Component } from 'react'
import './Header.css'
import { Link } from 'react-router-dom'
import { Navbar, Nav, Form,FormControl, Button, Image, NavDropdown,Container, Row,Col } from 'react-bootstrap'
import LoginAndRegisterButtonsInHeader from './LoginAndRegisterButtonsInHeader'
import LogoutButtonInHeader from './LogoutButtonInHeader'

class Header extends Component {




  render() {
    return (
    <Navbar bg="light" expand="lg">
  <Navbar.Brand href="/products">Takami</Navbar.Brand>
  <Navbar.Toggle aria-controls="basic-navbar-nav" />
  <Navbar.Collapse id="basic-navbar-nav">
    <Nav className="mr-auto">
      <Nav.Link href="/home">Home</Nav.Link>
      <Nav.Link href="/aboutme">About me</Nav.Link>
      <Nav.Link href="/contactme">Contact me</Nav.Link>
      <NavDropdown title="Categories" id="basic-nav-dropdown">
        <NavDropdown.Item href="/rods">Rods</NavDropdown.Item>
        <NavDropdown.Item href="/reels">Reels</NavDropdown.Item>
        <NavDropdown.Item href="/hooks">Hooks</NavDropdown.Item>
      </NavDropdown>
    </Nav>
    <LoginAndRegisterButtonsInHeader />
    
  </Navbar.Collapse>
</Navbar>
)
  }


}
export default Header