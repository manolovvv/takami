import React, { Component } from 'react'

class MasterDetailsComponent extends Component{
    constructor(props){
        super(props);
        this.state ={
            productToShow: {}
        };
        
    }
    
    componentDidMount(){
        const { id } = this.props.params;;
        
    }
   
   

    render(){
      
        return (
            <h1>op</h1>
        )
    }
}
export default MasterDetailsComponent;