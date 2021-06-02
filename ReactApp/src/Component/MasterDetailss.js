import React, { useEffect, useState } from 'react'
import { useParams } from 'react-router-dom'
import { Button, Container, Row, Col, Image } from 'react-bootstrap'
import ProductService from '../Service/ProductService'
import * as CartFunctions from '../CartFunctions'
import './MasterDetailss.css'

const MasterDetails = (props) => {

    const [product, setProduct] = useState({
        name: "name",
        amount: 0,
        available: true,
        description: ["desc", "desc"],
        id: 0,
        pathToImage: "<Image>",
        price: 0,
        productType: "ROD"
    });



    const { id } = useParams();

    console.log("id");
    console.log(id);

    useEffect(() => {
        ProductService.getProduct(id).then((res) => {
            console.log(res.data);
            let item = res.data;
            let desc = res.data.description;
            let description = desc.split("/");
            item.description = description;
            setProduct(item);
            console.log(item.description);

        })


    }, [id]);

    return (
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

    )
}

export default MasterDetails;