import React,{Component} from 'react'

import {Link} from 'react-router-dom'
import {Button} from 'react-bootstrap'


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
                <Link to="/myCart">
                    {(sessionStorage.getItem('role') === "ROLE_USER")? <svg width="3em" id="cart-icon" height="3em" viewBox="0 0 16 16" className="bi bi-cart" fill="blue" xmlns="http://www.w3.org/2000/svg">
  <path fillRule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
</svg>:<div></div>}
                    </Link>
                <Link to="/products">
                    <Button type ="submit" variant="outline-info" onClick={this.handleClick}>Logout</Button>
                    </Link>
                    
            </div>


        )
    }
}

export default LogoutButtonInHeader