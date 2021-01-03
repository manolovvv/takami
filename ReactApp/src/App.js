import React, { useState } from 'react';
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
import CartComponent from './Component/CartComponent'
import RegisterComponent from './Component/RegisterComponent'
import ProductService from './Service/ProductService'
import {options} from './constants/constants'

function App() {

let allProducts;
let rods;
let reels;
let hooks;

ProductService.getProducts(options).then((res) => {
  localStorage.setItem("allProducts", JSON.stringify(res.data));
  rods =  res.data.filter(product=> product.name ==="rod");
  console.log(rods);
  localStorage.setItem("rods",JSON.stringify(rods));
  reels = res.data.filter(product => product.name === "reel");
  localStorage.setItem("reels", JSON.stringify(reels));
  hooks = res.data.filter(product => JSON.stringify(hooks));
  localStorage.setItem("hooks", JSON.stringify(hooks));



 // console.log(JSON.stringify(res.data));
  //console.log("rods"+ JSON.parse(rods));
  
  
  
})

  return (
   // <LoginComponent/>
    // <AddProductComponent/>
    <Router >
      <Header />
      
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
      <Route path = "/contactme">
        <ContactMeComponent/>
      </Route>
      <Route path = "/register">
        <RegisterComponent/>
      </Route>
      <Route path="/myCart">
        <CartComponent/>
      </Route>
    </Router>
     
  
  
  );
}

export default App;
