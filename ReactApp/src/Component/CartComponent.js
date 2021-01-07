import React, { Component } from 'react'
import { Accordion, Card, Button, Container, Row, Col } from 'react-bootstrap';
import ProductFragment from './fragments/ProductFragment';
import ProductInCartFragment from './fragments/ProductInCartFragment'
import RequestService from '../Service/RequestService'


class CartComponent extends Component {
    constructor(props) {
        super(props)
        this.state = {
            productsInCart: [],
            productsToShow: []
        };
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    componentDidMount() {
        // this.state.productsInCart:productsInCart


        let allProducts = JSON.parse(localStorage.getItem("allProducts"));
        if (!Array.isArray((JSON.parse(sessionStorage.getItem('cart'))))) {
            let productInCart = (JSON.parse(sessionStorage.getItem('cart')));
            this.setState({ productsInCart: [productInCart] })
            //sessionStorage.setItem('cart', JSON.stringify(this.state.productsInCart));


            this.state.productsInCart.map(
                (product) => {
                    for (let i = 0; allProducts.length; i++) {
                        if (product.productId === allProducts[i]) {
                            //this.setState({productsToShow:allProducts[i]});
                            this.state.productsToShow.push(allProducts[i]);
                        }
                    }
                }
            )
            console.log("11")

        }
        else if ((JSON.parse(sessionStorage.getItem('cart'))) === null) {
            console.log("22")
            this.setState({ productsInCart: [] });

        }
        else {
            console.log("33")
            this.setState({ productsInCart: (JSON.parse(sessionStorage.getItem('cart'))) });
            console.log(this.state.productsInCart);
            console.log("12312")

            //sessionStorage.setItem('cart',JSON.stringify(this.state.productsInCart));

        }

    }

    handleSubmit(event) {

        const id = sessionStorage.getItem('id');
        const products = this.state.productsInCart;
        console.log(products);

        RequestService.makeRequest(this.state.productsInCart, id).then((res) => {
            console.log(res);
            if (res.status === 200) {
                alert("Request has been made!");
            }
        });


        //     AuthService.login(username, password).then((res) => {
        //     sessionStorage.clear();
        //     console.log(res);
        //     sessionStorage.setItem('JWTToken', res.data.jwt);
        //     console.log(sessionStorage.getItem('JWTToken'));
        //     sessionStorage.setItem("loggedIn", true);
        //     sessionStorage.setItem("role",res.data.role);
        //     sessionStorage.setItem("id",res.data.id);

        // })
        // this.props.history.push('/products');


    }


    render() {
        let allProducts = JSON.parse(localStorage.getItem("allProducts"));

        return (
            <div>
                <h1>My Cart</h1>
                <Container fluid>
                    {
                        this.state.productsInCart.map(
                            (product, index) => {
                                console.log(allProducts.length)
                                if (product !== null) {
                                    let q = product.quantity;
                                    for (let i = 0; i < allProducts.length; i++) {
                                        if (allProducts[i].id === product.productId) {
                                            product = allProducts[i];
                                            product.quantity = q;
                                            console.log(product);
                                        }
                                    }
                                    return (


                                        <Row key={index}>
                                            <Col>
                                                <ProductInCartFragment product={product} />
                                            </Col>
                                        </Row>






                                    )
                                }
                            }
                        )
                    }
                </Container>
                <Button variant="primary" onClick={this.handleSubmit} >Make a request</Button>
            </div>
        )
    }
}

export default CartComponent;