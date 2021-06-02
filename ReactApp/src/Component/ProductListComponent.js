import React, { Component } from 'react'
import ProductService from '../Service/ProductService'
import { Container, Row, Col } from 'react-bootstrap'
import { options } from '../constants/constants'
import "./ProductListComponent.css"
import ProductInList from "./fragments/ProductFragment"

class ProductListComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: []
        }
    }

    async componentDidMount() {
    let allProducts;
       await ProductService.getProducts(options).then((res) => {
           localStorage.setItem("allProducts", JSON.stringify(res.data));
            allProducts = res.data;
          })
        
        
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
        await this.setState({ products: allProductsToShow })


    }

    

    render() {
<<<<<<< HEAD
        console.log("DASDASDASDASDASDADS")
        return (
            <div className="wrapper">
                <Container>
                    <Row className="justify-content-center mt-5">
                        {
                            this.state.products.map(
                                (product, index) => <div key = {index}><Col  key={product.id} className = "mt-5"> {ProductInList(product)}</Col></div>
 
=======
        return (
            <div className="wrapper">
                <Container>
                    <Row >
                        {
                            this.state.products.map(
                                (product, index) => {
                                    
                                    return (
                                        
                                        <Col sm key={product.id}> {ProductInList(product)}</Col>

                                    )
                                }
>>>>>>> a068b07ada307434a85d5a93ddb95cd57d2e5d5e
                            )}
                    </Row>
                </Container>
            </div>
        )

    }


}
export default ProductListComponent