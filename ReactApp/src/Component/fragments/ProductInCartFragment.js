import React from 'react'
import * as cartFunctions from '../../CartFunctions'
import './ProductInCartFragment.css'



  const ProductInCartFragment = (props)=>{
  
     return(
 
    <div className="product" key={props.product.id}>
    <div className="product-image">
      <img src="https://via.placeholder.com/100" alt="Placeholder"/>
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
     )
}
export default ProductInCartFragment;