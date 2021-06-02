import React, { useEffect, useState } from 'react'
import { useParams, Redirect } from 'react-router-dom'
<<<<<<< HEAD
import { Button, Container, Row, Col, Image } from 'react-bootstrap'
import ProductService from '../Service/ProductService'
import * as CartFunctions from '../CartFunctions'
import './MasterDetailss.css'
=======
import {Button} from 'react-bootstrap'
import ProductService from '../Service/ProductService'
import * as CartFunctions from '../CartFunctions'
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e


const MasterDetails = (props) => {

    const [product, setProduct] = useState({
        name: "name",
        amount: 0,
        available: true,
<<<<<<< HEAD
        description: ["desc", "desc"],
=======
        description: ["desc","desc"],
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e
        id: 0,
        pathToImage: "<Image>",
        price: 0,
        productType: "ROD"
    });

<<<<<<< HEAD
    const[quantity, setQuantity] = useState(0);

=======
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e
    const { id } = useParams();

    console.log("id");
    console.log(id);

    useEffect(() => {
<<<<<<< HEAD
=======
        //let allProducts = JSON.parse(localStorage.getItem('allProducts'));
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e
        ProductService.getProduct(id).then((res) => {
            console.log(res.data);
            let item = res.data;
            let desc = res.data.description;
            let description = desc.split("/");
            item.description = description;
            setProduct(item);
            console.log(item.description);

        })

<<<<<<< HEAD
=======
        // console.log(product);
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e

    }, [id]);

    return (
<<<<<<< HEAD
        <Container >
            <Row xs={1} lg={2} className="justify-content-center mt-5 pt-5">
                <Col className = "product_img">
                    <Image variant="top" src="https://via.placeholder.com/300" />
                </Col>
                <Col className="product sm-mt-5">
                    <h4>{product.name}</h4>
                   
                    <ul className="product_desc">
                        {
                            product.description.map((desc, index) => {
                                return <li key={index}>{desc}</li>
                            })
                        }
                    </ul>
                    <div>
                    <h4 className="product_quantity">Left: {product.amount}</h4>
                    <h4 className="product_price">Price: €{product.price}</h4>
                    </div>
              
                    <Button variant="primary" className="btnAddToCart mt-5" onClick={() => CartFunctions.addToCart(product.id, 1)}>Add item to cart</Button>

                </Col>
            </Row>
        </Container>

=======
        <div>
            <h4>{product.name}</h4>
            <h4>Left: {product.amount}</h4>
            <ul>
            {
                product.description.map((desc,index)=>{
                   return <li key = {index}>{desc}</li>
                }

                )
            }
            </ul>
            <h4>Price: €{product.price}</h4>
            <Button variant="primary" onClick={()=> CartFunctions.addToCart(product.id,1)}>Add item to cart</Button>
        </div>
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e
    )
}

export default MasterDetails;