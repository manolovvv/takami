import React from 'react';
import './App.css';
//import ProductListComponent from './Component/ProductListComponent'
import Header from './Component/Header/Header'
import LoginComponent from './Component/LoginComponent'
import {BrowserRouter as Router,Switch,Route} from 'react-router-dom'
import ProductListComponent from './Component/ProductListComponent';
import AddProductComponent from "./Component/AddProductComponent";
import * as Constants from 'constants';

function App() {
  return (
   // <LoginComponent/>
    //<AddProductComponent/>
    <Router>
      <Header />
      <Route path = "/login" component={LoginComponent}/>
      <Route path ="/products" component={ProductListComponent}/>
    </Router>
     
  
  
  );
}

export default App;
