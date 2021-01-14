import React from 'react'
import { Card, Button } from 'react-bootstrap'
import * as cartFunctions from '../../CartFunctions'
import ProductService from '../../Service/ProductService'
import {Link} from 'react-router-dom'
import { Redirect, Route, useHistory,withRouter } from 'react-router-dom'


const ProductFragment = (props) => {
    return (
        <Card style={{ width: '15rem' }} key={props.id}>
            <Card.Img variant="top" src="holder.js/100px180" />

            <Card.Body>
                <Card.Title>{props.name}</Card.Title>
                <Card.Text>
                    price: {props.price}<br />
                                quantity: {props.amount}<br />
                                id: {props.id}
                </Card.Text>
                
                    <Button variant="primary" onClick={()=>{window.location.href = "/masterDetails/"+props.id }} >See more details</Button>
                    {sessionStorage.getItem('role')==="ROLE_ADMIN"&& props.available ===true ? <Button variant="danger" onClick={()=>ProductService.setProductUnavailable(props.id)} >Make item unavailable</Button>:null}
                    {sessionStorage.getItem('role')==="ROLE_ADMIN"&& props.available ===false ? <Button variant="success" onClick={()=>ProductService.setProductAvailable(props.id)} >Make item available</Button>:null}
               
                
            </Card.Body>

        </Card>
    )
}
export default ProductFragment;