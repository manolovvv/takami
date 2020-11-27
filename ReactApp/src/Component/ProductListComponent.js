import React, { Component } from 'react'
import ProductService from '../Service/ProductService'
import { Card, Button } from 'react-bootstrap'
import {options} from '../constants/constants'

class ProductListComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: []
        }
    }

    componentDidMount() {
        ProductService.getProducts(options).then((res) => {
            this.setState({ products: res.data })
        })

    }

    render() {
        return (
            /* <div>
                 <table>
                     <tbody>
                         <tr>
                             <th>Name</th>
                             <th>Price</th>
                             <th>Quantity</th>
                         </tr>
                     </tbody>
                     <tbody>
                     {
                         this.state.products.map(
                             product =>
                                 <tr key={product.id}>
                                 <td> {product.name}</td>
                                 <td> {product.price}</td> 
                                 <td> {product.quantity}</td> 
                                 </tr> 
 
 
                                 
                         )
 
                     }
                     </tbody>
                    </table>
             </div>*/


            this.state.products.map(
                (product, index) => {

                    return     <Card style={{ width: '15rem' }} key = {product.id}>
                            <Card.Img variant="top" src="holder.js/100px180" />
                            <Card.Body>
                                <Card.Title>{product.name}</Card.Title>
                                <Card.Text>
                                    price: {product.price}<br/>
                                    quantity: {product.amount}<br/>
                                    {index}
                                </Card.Text>
                                <Button variant="primary">See more details</Button>
                            </Card.Body>

                        </Card>
                  
                }
            )

        )
    }


}
export default ProductListComponent