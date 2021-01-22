import React, { Component } from 'react'

import {Link} from 'react-router-dom'
import {Button} from 'react-bootstrap'

class LoginAndRegisterButtonsInHeader extends Component {


    render() {
        return (
            <div>
                <Link to="/login">
                    <Button variant="outline-info">Login</Button>
                </Link>
                <Link to="/register">
                <Button variant="outline-info">Register</Button>
                </Link>            
            </div>


        )
    }
}
export default LoginAndRegisterButtonsInHeader