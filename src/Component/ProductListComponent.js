import React, { Component } from 'react'
import ProductService from '../Service/ProductService'
import { Card, Button, Container,Row, Col } from 'react-bootstrap'
import {options} from '../constants/constants'
import "./ProductListComponent.css"
import ProductInList from "./fragments/ProductFragment"

class ProductListComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: []
        }
        this.ListProductCards = this.ListProductCards(this);
    }

    componentDidMount() {
        ProductService.getProducts(options).then((res) => {
            this.setState({ products: res.data })
        })

    }

     ListProductCards = (products) =>{
        this.state.products.map(
            (product, index) => {

                return  (
                
                ProductInList(product)
                )
            }
        )
    }

    render() {
        return (
        <div className = "wrapper">
            <Container>
            <Row>
            {
           this.state.products.map(
            (product, index) => {
                
                return  (
                 
               <Col sm key={product.id}> {ProductInList(product)}</Col>
                
                )
            }
        )}
        </Row>
        {/* {this.ListProductCards(this.state.products)} */}
        </Container>
        </div>
        )
        
    }


}
export default ProductListComponent