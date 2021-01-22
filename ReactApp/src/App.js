import React from 'react';
import './App.css';
import Header from './Component/Header/Header2'
import LoginComponent from './Component/LoginComponent'
import AllProductsComponent from './Component/allProductsComponent';
import {BrowserRouter as Router,Route} from 'react-router-dom'
import ProductListComponent from './Component/ProductListComponent';
import AddProductComponent from "./Component/AddProductComponent";
import AboutMeComponent from './Component/AboutMeComponent'
import CartComponent from './Component/CartComponent'
import RegisterComponent from './Component/RegisterComponent'
import MasterDetails from './Component/MasterDetailss'

function App() {




  return (
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
