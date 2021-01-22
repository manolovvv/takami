import React from 'react'
import { Card, Button } from 'react-bootstrap'
import * as cartFunctions from '../../CartFunctions'
import ProductListComponent from '../ProductListComponent'
import './ProductInCartFragment.css'
import * as CartFunctions from '../../CartFunctions';



  const ProductInCartFragment = (props)=>{
  
     return(
     <div className = "productInCart">
         <h3>Name: {props.product.name} / Quantity: {props.product.quantity}*{props.product.price}  = {parseFloat(props.product.quantity * props.product.price).toFixed(2)}</h3>
         <Button variant="danger" onClick = {()=>cartFunctions.deleteProductFromCart(props.product.id)}>Delete item from cart</Button>
     
     </div>
     
     )
}
export default ProductInCartFragment;