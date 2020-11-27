import React, { Component } from 'react'
import { Dropdown } from 'react-bootstrap'

class AddProductComponent extends Component {

  constructor(props) {
    super(props)
    this.state = {
      itemToAdd: ""
    };

    this.handleChange = this.handleChange.bind(this);
  }

  handleChange (event){
     // this.setState({
     //   [event.target.name]:event.target.value
    //  });
      this.setState({[event.target.getAttribute("name")]: event.target.getAttribute("value")});

  }



  render() {
    console.log(this.state);
    return (
        
       <Dropdown  >
         <Dropdown.Toggle variant="success" id="dropdown-basic" >
          Select what item do you want to add
     </Dropdown.Toggle>

        <Dropdown.Menu  name = "itemToAdd" value = {this.state.itemToAdd}  >
          <Dropdown.Item name = "itemToAdd"  onClick= {this.handleChange}  value = "Rod" >Add new rod</Dropdown.Item>
          <Dropdown.Item name = "itemToAdd" value = "Reel" onClick= {this.handleChange}>Add new reel</Dropdown.Item>
          <Dropdown.Item name = "itemToAdd" value = "Hook" onClick= {this.handleChange}>Add new line</Dropdown.Item>
        </Dropdown.Menu>
      </Dropdown>
  
    );
  }
}
export default AddProductComponent;