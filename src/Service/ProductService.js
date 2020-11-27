import axios from 'axios'

const PRODUCT_API_BASE_URL = "http://localhost:8080/products"


class ProductService{
    getProducts(options){
        return axios.get(PRODUCT_API_BASE_URL,options);
    }

}

export default new ProductService()