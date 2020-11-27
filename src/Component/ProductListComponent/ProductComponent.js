import React, { Component } from 'react'
import ProductService from '../../Service/ProductService'
import {Card, Button} from 'react-bootstrap'
import options from 'constants'

class ListProductComponent extends Component {

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

            this.state.products.map(
                product =>
                <Card style={{ width: '18rem' }}>
                <Card.Img variant="top" src="holder.js/100px180" />
                <Card.Body>
                  <Card.Title>{product.name}</Card.Title>
                  <Card.Text>
                     Product costs {product.price} and we have {product.quantity} of it.
                  </Card.Text>
                  <Button variant="primary">Buy</Button>
                </Card.Body>
              </Card>
            )

          /*  <div>
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
            </div>
        )*/
        )
    }


}
export default ListProductComponent