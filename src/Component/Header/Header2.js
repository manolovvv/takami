import React, { Component, useEffect,useState } from 'react'
import './Header.css'
import { Link } from 'react-router-dom'
import { Navbar, Nav, Form,FormControl, Button, Image, NavDropdown,Container, Row,Col } from 'react-bootstrap'
import LoginAndRegisterButtonsInHeader from './LoginAndRegisterButtonsInHeader'
import LogoutButtonInHeader from './LogoutButtonInHeader'

const Header =(props)=> {

    
    const[role,setRole] = useState();

    
    useEffect(()=>{

    setRole(sessionStorage.getItem('role'));    
     // console.log(1);
    });


  
   
    return (
    <Navbar bg="light" expand="lg">
  <Navbar.Brand href="/products">Takami</Navbar.Brand>
  <Navbar.Toggle aria-controls="basic-navbar-nav" />
  <Navbar.Collapse id="basic-navbar-nav">
    <Nav className="mr-auto">
      {/* <Nav.Link href="/home">Home</Nav.Link> */}
      <Nav.Link href="/aboutme">About me</Nav.Link>
      {/* <Nav.Link href="/contactme">Contact me</Nav.Link> */}
     {role === "ROLE_ADMIN" ?<Nav.Link href="/addNewProduct">Add new product</Nav.Link>: null} 
      <NavDropdown title="Categories" id="basic-nav-dropdown">
        <NavDropdown.Item href="/products/rods">Rods</NavDropdown.Item>
        <NavDropdown.Item href="/products/reels">Reels</NavDropdown.Item>
        <NavDropdown.Item href="/products/hooks">Hooks</NavDropdown.Item>
      </NavDropdown>
    </Nav>
    {sessionStorage.getItem("JWTToken")?<LogoutButtonInHeader/>:<LoginAndRegisterButtonsInHeader/>}
    {/* <LoginAndRegisterButtonsInHeader /> */}
    {/* <svg width="2em" height="2em" viewBox="0 0 16 16" class="bi bi-cart" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
</svg> */}
    
  </Navbar.Collapse>
</Navbar>
)
  }



export default Header