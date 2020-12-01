import React from 'react';
import './App.css';
//import ProductListComponent from './Component/ProductListComponent'
import Header from './Component/Header/Header'
import LoginComponent from './Component/LoginComponent'
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom'
import ProductListComponent from './Component/ProductListComponent';
import AddProductComponent from "./Component/AddProductComponent";
import * as Constants from 'constants';
import AboutMeComponent from './Component/AboutMeComponent'
import ContactMeComponent from './Component/ContactMeComponent'
import RegisterComponent from './Component/RegisterComponent'


function App() {
  return (
   // <LoginComponent/>
    //<AddProductComponent/>
    <Router >
      <Header />
      
      <Route path = "/login">
        <LoginComponent/>
      </Route>
      <Route path ="/products">
      <ProductListComponent/>
      </Route> 
      <Route path = "/aboutme">
      <AboutMeComponent/>
      </Route> 
      <Route path = "/contactme">
        <ContactMeComponent/>
      </Route>
      <Route path = "/register">
        <RegisterComponent/>
      </Route>
    </Router>
     
  
  
  );
}

export default App;
