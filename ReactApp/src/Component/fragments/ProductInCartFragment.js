import React from 'react'
import { Card, Button } from 'react-bootstrap'
import * as cartFunctions from '../../CartFunctions'
import ProductListComponent from '../ProductListComponent'
import './ProductInCartFragment.css'
import * as CartFunctions from '../../CartFunctions';



  const ProductInCartFragment = (props)=>{
  
     return(
<<<<<<< HEAD
    //  <div className = "productInCart" id={props.product.id}>
    //      <h3>Name: {props.product.name} / Quantity: {props.product.quantity}*{props.product.price}  = {parseFloat(props.product.quantity * props.product.price).toFixed(2)}</h3>
    //      <Button variant="danger" onClick = {()=>cartFunctions.deleteProductFromCart(props.product.id)}>Delete item from cart</Button>
     
    //  </div>
    <div className="product" key={props.product.id}>
    <div className="product-image">
      <img src="https://via.placeholder.com/100"/>
    </div>
    <div className="product-details">
      <div className="product-title">{props.product.name}</div>
      <p className="product-description">{props.product.name}</p>
    </div>
    <div className="product-price">{parseFloat( props.product.price).toFixed(2)}</div>
    <div className="product-quantity">
      <input type="number" value={props.product.quantity} min="1"/>
    </div>
    <div className="product-removal">
      <button className="remove-product" onClick = {()=>cartFunctions.deleteProductFromCart(props.product.id)}>
        Remove
      </button>
    </div>
    <div className="product-line-price">{parseFloat(props.product.price * props.product.quantity).toFixed(2)}</div>
  </div>
=======
     <div className = "productInCart">
         <h3>Name: {props.product.name} / Quantity: {props.product.quantity}*{props.product.price}  = {parseFloat(props.product.quantity * props.product.price).toFixed(2)}</h3>
         <Button variant="danger" onClick = {()=>cartFunctions.deleteProductFromCart(props.product.id)}>Delete item from cart</Button>
     
     </div>
     
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e
     )
}
export default ProductInCartFragment;