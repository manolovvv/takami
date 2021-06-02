import React from 'react'
import { Card, Button } from 'react-bootstrap'
import ProductService from '../../Service/ProductService'


const ProductFragment = (props) => {
    return (
        <Card style={{ width: '15rem' }} key={props.id}>
<<<<<<< HEAD
            <Card.Img variant="top" src="https://via.placeholder.com/150" />
=======
            <Card.Img variant="top" src="holder.js/100px180" />
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e

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