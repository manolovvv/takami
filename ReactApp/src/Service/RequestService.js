import axios from 'axios'
import { Container } from 'react-bootstrap';
import * as Constants from '../constants/constants'

const REQUEST_API_BASE_URL = "http://localhost:8080/requests"



class RequestService {
    makeRequest(products, userId) {
        return axios.post(REQUEST_API_BASE_URL + /newRequest/ + userId, products, Constants.options);
    }

}

export default new RequestService()