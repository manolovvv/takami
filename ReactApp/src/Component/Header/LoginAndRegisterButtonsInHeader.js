import React, { Component } from 'react'

import {Link} from 'react-router-dom'
import {Navbar,Nav,Form,Button,Image} from 'react-bootstrap'

class LoginAndRegisterButtonsInHeader extends Component {


    render() {
        return (
            <div>
                <Link to="/login">
                    <Button variant="outline-info">Login</Button>
                </Link>
                <Button variant="outline-info">Register</Button>
            </div>


        )
    }
}
export default LoginAndRegisterButtonsInHeader