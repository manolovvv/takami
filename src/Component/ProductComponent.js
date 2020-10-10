import React, { Component } from 'react'
import ProductService from '../Service/ProductService'

class ListProductComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            products: []
        }
    }

    componentDidMount() {
        ProductService.getProducts().then((res) => {
            this.setState({ products: res.data })
        })

    }

    render() {
        return (
            <div>
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
        )
    }


}
export default ListProductComponent