import axios from 'axios'
import { options } from '../constants/constants';

const PRODUCT_API_BASE_URL = "http://localhost:8080/products"


class ProductService{
    getProducts(){
        return axios.get(PRODUCT_API_BASE_URL);
    }

    getProduct(productId){
        return axios.get(PRODUCT_API_BASE_URL+"/"+productId);
    }

    async setProductUnavailable(productId){
        await axios.delete(PRODUCT_API_BASE_URL+"/"+productId,options);
          this.getProducts().then((res)=> localStorage.setItem('allProducts',res.data));
          window.location.reload();
          
    }
    async setProductAvailable(productId){
         axios.put(PRODUCT_API_BASE_URL+"/"+productId,{},options);
         this.getProducts().then((res)=> localStorage.setItem('allProducts',res.data));
         window.location.reload();
    }

   async addNewProduct(name,quantity,price,description,productType){
        return await axios.post(PRODUCT_API_BASE_URL,
            {
                amount: quantity,
                price: price,
                name: name,
                productType: productType,
                description: description
            
            },options);
    }

}



export default new ProductService();