import React, { Component } from 'react'
import { Accordion, Card, Button,Container,Row,Col } from 'react-bootstrap';
import ProductFragment from './fragments/ProductFragment';
import ProductInCartFragment from './fragments/ProductInCartFragment'


class CartComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            productsInCart: [],
            productsToShow:[]
        };
    }


    componentDidMount() {
        // this.state.productsInCart:productsInCart
        let allProducts  = JSON.parse(localStorage.getItem("allProducts"));
        if (!Array.isArray((JSON.parse(sessionStorage.getItem('cart'))))) {
            let productInCart = (JSON.parse(sessionStorage.getItem('cart')));
            this.setState({ productsInCart: [productInCart] })
            sessionStorage.setItem('cart', JSON.stringify(this.state.productsInCart));
           

            this.state.productsInCart.map(
                (product)=>{
                    for(let i = 0;allProducts.length;i++){
                        if(product.productId === allProducts[i]){
                            //this.setState({productsToShow:allProducts[i]});
                            this.state.productsToShow.push(allProducts[i]);
                        }
                    }
                }
            )

        }
        else if ((JSON.parse(sessionStorage.getItem('cart'))) === null) {
            this.setState({ productsInCart: [] });
         
        }
        else {
             this.setState({ productsInCart: (JSON.parse(sessionStorage.getItem('cart'))) });
             console.log(this.state.productsInCart);
             console.log("12312")
            //sessionStorage.setItem('cart',JSON.stringify(this.state.productsInCart));
            
        }
    }


    render() {
        let allProducts  = JSON.parse(localStorage.getItem("allProducts"));

        return (
            <div>
                <h1>My Cart</h1>
                <Container fluid>
                {
                    this.state.productsInCart.map(
                        (product, index) => {
                            console.log(allProducts.length)
                            if(product.quantity !== null){
                            let q = product.quantity;
                            for(let i = 0;i<allProducts.length;i++){
                                if(allProducts[i].id ===product.productId){
                                    product = allProducts[i];
                                    product.quantity = q;
                                    console.log(product);
                                }
                            }
                            return (
                                
                               
                                    <Row>
                                        <Col>
                                            <ProductInCartFragment product={product} />
                                        </Col>
                                    </Row>
                                
                                




                            )}
                        }
                    )
                }
                </Container>
            </div>
        )
    }
}

export default CartComponent;