import React, { Component } from 'react'
import ProductService from '../Service/ProductService'
import {  Container, Row, Col } from 'react-bootstrap'
import { options } from '../constants/constants'
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



   async componentDidMount() {
        
       await ProductService.getProducts(options).then((res) => {
            localStorage.setItem("allProducts", JSON.stringify(res.data));
            
          })


        let allProducts = await JSON.parse(localStorage.getItem("allProducts"));
        console.log(this.props.productType);
        let allProductsToShow
        if(sessionStorage.getItem('role') ==="ROLE_ADMIN"){
             allProductsToShow = allProducts;
        }
        else{
             allProductsToShow = allProducts.filter(product=> product.available ===true);
        }
        console.log(allProductsToShow);
        this.setState({ products: allProductsToShow })/*, () =>*/ 
        //console.log(this.state.products));
        
        //console.log(JSON.parse(localStorage.getItem("allProducts")));


    }

    ListProductCards = (products) => {
        console.log()
        console.log(this.state.products)
        let productsToShow = this.state.products.filter(product=> product.productType ===this.props.productType)
        console.log(productsToShow);
        productsToShow.map(
            (product, index) => {
           
                return (
                   
                    ProductInList(product)
                )
            }
        )
    }

    render() {
        return (
            <div className="wrapper">
                <Container>
                    <Row>
                        {
                            this.state.products.map(
                                (product, index) => {
                                    // if((index+1)%3 ===0){
                                    //     return (
                                           
                                    //         <Col sm key={product.id}> {ProductInList(product)}</Col>
                                          
                                    //     )
                                    // }
                                    return (

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