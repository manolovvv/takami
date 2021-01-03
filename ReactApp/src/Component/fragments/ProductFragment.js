import React from 'react'
import { Card, Button } from 'react-bootstrap'
import * as cartFunctions from '../../CartFunctions'



  const ProductFragment = (props)=>{
     return(
    <Card style={{ width: '15rem' }} key = {props.id}>
                        <Card.Img variant="top" src="holder.js/100px180" />
                        
                        <Card.Body>
                            <Card.Title>{props.name}</Card.Title>
                            <Card.Text>
                                price: {props.price}<br/>
                                quantity: {props.amount}<br/>
                                id: {props.id}
                            </Card.Text>
                            <Button variant="primary" onClick = {()=>cartFunctions.addToCart(props.id,1)}>See more details</Button>
                        </Card.Body>

                    </Card>
     )
}
export default ProductFragment;