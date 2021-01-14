import React, { Component } from 'react'
import { Dropdown, Form, Button } from 'react-bootstrap'
import ProductService from '../Service/ProductService'

class AddProductComponent extends Component {

  constructor(props) {
    super(props)
    this.state = {
      itemToAdd: "ROD",
      name: "",
      quantity: 1,
      price: 1,
      description:""
    };

    this.handleDropdownChange = this.handleDropdownChange.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleDropdownChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    });
    this.setState({ itemToAdd: event.target.getAttribute("value") });

    console.log(this.state.itemToAdd);
  }

  handleSubmit(event) {
    event.preventDefault();
    const { itemToAdd, name, quantity, price, description } = this.state;
    console.log("odas")
    console.log(itemToAdd);
    console.log(name);
    console.log(quantity);
    console.log(price);
    console.log(description);
    ProductService.addNewProduct(name,quantity,price,description,itemToAdd).then(res=>{
      alert(res.data);
      
    })


  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value
    });



    if (this.state.quantity < 1) {
      this.setState({
        quantity: 1
      })
    }

    if (this.state.price < 0.01) {
      this.setState({
        price: 1
      })
    }

    console.log(this.state[event.target.name]);

  }




  render() {
    console.log(this.state);
    return (




      <Form onSubmit={this.handleSubmit}>

        <Dropdown  >
          <Dropdown.Toggle variant="success" id="dropdown-basic" >
            {this.state.itemToAdd}
          </Dropdown.Toggle>

          <Dropdown.Menu name="itemToAdd" value={this.state.itemToAdd}  >
            <Dropdown.Item name="rod" onClick={this.handleDropdownChange} value="ROD" >Add new rod</Dropdown.Item>
            <Dropdown.Item name="reel" value="REEL" onClick={this.handleDropdownChange}>Add new reel</Dropdown.Item>
            <Dropdown.Item name="hook" value="HOOK" onClick={this.handleDropdownChange}>Add new line</Dropdown.Item>
          </Dropdown.Menu>
        </Dropdown>

        <Form.Group controlId="formBasicName">
          <Form.Label>Name</Form.Label>
          <Form.Control type="text" placeholder="Name" name="name" value={this.state.name} onChange={this.handleChange} />
        </Form.Group>

        <Form.Group controlId="formBasicQuantity">
          <Form.Label>Quantity</Form.Label>
          <Form.Control type="number" placeholder="Quantity" name="quantity" value={this.state.quantity} onChange={this.handleChange} />
        </Form.Group>

        <Form.Group controlId="formBasicPrice">
          <Form.Label>Price</Form.Label>
          <Form.Control type="number" placeholder="Price" name="price" value={this.state.price} onChange={this.handleChange} />
        </Form.Group>

        <Form.Group controlId="formBasicName">
          <Form.Label>Name</Form.Label>
          <Form.Control type="text" placeholder="Description" name="description" value={this.state.description} onChange={this.handleChange} />
        </Form.Group>

        <Button variant="primary" type="submit" onClick={this.handleSubmit}>
          Add product
  </Button>
      </Form>

    );
  }
}
export default AddProductComponent;