import React, { useState } from 'react';
import './App.css';
//import ProductListComponent from './Component/ProductListComponent'
//import Header from './Component/Header/Header'
import Header from './Component/Header/Header2'
import LoginComponent from './Component/LoginComponent'
import AllProductsComponent from './Component/allProductsComponent';
//import LoginComponent from './Component/LoginComponentFunction'
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom'
import ProductListComponent from './Component/ProductListComponent';
import AddProductComponent from "./Component/AddProductComponent";
import * as Constants from 'constants';
import AboutMeComponent from './Component/AboutMeComponent'
import ContactMeComponent from './Component/ContactMeComponent'
import CartComponent from './Component/CartComponent'
import RegisterComponent from './Component/RegisterComponent'
import ProductService from './Service/ProductService'
//import MasterDetails from './Component/MasterDetailsComponent'
import {options} from './constants/constants'
import MasterDetails from './Component/MasterDetailss'

function App() {


  ProductService.getProducts(options).then((res) => {
    localStorage.setItem("allProducts", JSON.stringify(res.data));
    
  })



  return (
   // <LoginComponent/>
    // 
    <Router >
      <Route>
      <Header />
      </Route>
      <Route exact path ="/products">
      <AllProductsComponent />
      </Route> 
      <Route path = "/login">
        <LoginComponent/>
      </Route>
      <Route path ="/products/rods">
      <ProductListComponent productType = "ROD"/>
      </Route> 
      <Route path ="/products/reels">
      <ProductListComponent productType = "REEL"/>
      </Route> 
      <Route path ="/products/hooks" >
      <ProductListComponent productType = "HOOK"/>
      </Route> 
      <Route path = "/aboutme">
      <AboutMeComponent/>
      </Route> 
      {/* <Route path = "/contactme">
        <ContactMeComponent/>
      </Route> */}
      <Route path = "/register">
        <RegisterComponent/>
      </Route>
      <Route path="/myCart">
        <CartComponent/>
      </Route>
      <Route path="/masterDetails/:id">
        <MasterDetails/>
      </Route>
      <Route path="/addNewProduct">
      <AddProductComponent/>
      </Route>
    </Router>
     
  
  
  );
}

export default App;
