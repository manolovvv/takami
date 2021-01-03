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
        sessionStorage.clear();
        window.location.reload();
    }
    render() {
        return (
            <div>
                <Link to="/products">
                    <Button type ="submit" variant="outline-info" onClick={this.handleClick}>Logout</Button>
                    </Link>
                    <Link to="/myCart">
                    {(sessionStorage.getItem('role') === "ROLE_USER")? <Button type ="submit" variant="outline-info" /*onClick={() }*/>Cart</Button>:<div></div>}
                    </Link>
            </div>


        )
    }
}

export default LogoutButtonInHeader