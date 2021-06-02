import React from 'react';
import './App.css';
import Header from './Component/Header/Header2'
<<<<<<< HEAD
import LoginComponent from './Component/LoginComponent.jsx'
=======
import LoginComponent from './Component/LoginComponent'
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e
import AllProductsComponent from './Component/allProductsComponent';
import {BrowserRouter as Router,Route} from 'react-router-dom'
import ProductListComponent from './Component/ProductListComponent';
import AddProductComponent from "./Component/AddProductComponent";
import AboutMeComponent from './Component/AboutMeComponent'
<<<<<<< HEAD
import CartComponent from './Component/CartComponent.jsx'
import RegisterComponent from './Component/RegisterComponent.jsx'
=======
import CartComponent from './Component/CartComponent'
import RegisterComponent from './Component/RegisterComponent'
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e
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
