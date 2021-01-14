import React, { Component } from 'react'
import ProductService from '../Service/ProductService'
import { Card, Button, Container, Row, Col } from 'react-bootstrap'
import { options } from '../constants/constants'
import "./ProductListComponent.css"
import ProductInList from "./fragments/ProductFragment"

class ProductListComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: []
        }
       // this.ListProductCards = this.ListProductCards(this);
    }

    async componentDidMount() {
       await ProductService.getProducts(options).then((res) => {
           localStorage.setItem("allProducts", JSON.stringify(res.data));
            
          })
        
        


        let allProducts = JSON.parse(localStorage.getItem("allProducts"));
        console.log("ptyper")
        console.log(this.props.productType);
        let allProductsToShow
        if(sessionStorage.getItem('role') ==="ROLE_ADMIN"){
             allProductsToShow = allProducts.filter(product=>product.productType === this.props.productType);
        }
        else{
             allProductsToShow = allProducts.filter(product=>product.productType ===this.props.productType && product.available ===true);
        }
        console.log(allProductsToShow);
        await this.setState({ products: allProductsToShow })/*, () =>*/ 
        //console.log(this.state.products));
        console.log("tuk");
        console.log(this.state.products)
        //console.log(JSON.parse(localStorage.getItem("allProducts")));


    }

    // 

    render() {
        return (
            <div className="wrapper">
                <Container>
                    <Row>
                        {
                            this.state.products.map(
                                (product, index) => {

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