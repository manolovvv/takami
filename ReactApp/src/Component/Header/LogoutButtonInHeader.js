import React,{Component} from 'react'

import {Link} from 'react-router-dom'
import {Navbar,Nav,Form,Button,Image} from 'react-bootstrap'


class LogoutButtonInHeader extends Component{
    constructor(props) {
        super(props)
    

        this.handleClick = this.handleClick.bind(this);
    };

    handleClick(event){
        alert("loggedOut");
        sessionStorage.setItem("loggedIn", false);
        sessionStorage.setItem("JWTToken", null);
        window.location.reload();
    }
    render() {
        return (
            <div>
                <Link to="/products">
                    <Button type ="submit" variant="outline-info" onClick={this.handleClick}>Logout</Button>
                    </Link>
            </div>


        )
    }
}

export default LogoutButtonInHeader