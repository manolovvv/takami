import React, { Component } from 'react'
import { useParams } from 'react-router-dom';
import { withRouter } from "react-router";

class MasterDetailsComponent extends Component{
    constructor(props){
        super(props);
        this.state ={
           // productId:useParams(),
            productToShow: {}
        };
        
    }
    
    componentDidMount(){
        //const {handle} = this.props.match.params.id;
       // const{productId } = this.props.location.state;
        const { id } = this.props.params;;
        //let {id} = useParams();
        
    }
   
   

    render(){
      
        return (
            <h1>op</h1>
        )
    }
}
export default MasterDetailsComponent;