import React, { useEffect, useState } from 'react'
import { useParams, Redirect } from 'react-router-dom'
import {Button} from 'react-bootstrap'
import ProductService from '../Service/ProductService'
import * as CartFunctions from '../CartFunctions'


const MasterDetails = (props) => {

    const [product, setProduct] = useState({
        name: "name",
        amount: 0,
        available: true,
        description: ["desc","desc"],
        id: 0,
        pathToImage: "<Image>",
        price: 0,
        productType: "ROD"
    });

    const { id } = useParams();

    console.log("id");
    console.log(id);

    useEffect(() => {
        ProductService.getProduct(id).then((res) => {
            console.log(res.data);
            let item = res.data;
            let desc = res.data.description;
            let description = desc.split("/");
            item.description = description;
            setProduct(item);
            console.log(item.description);

        })


    }, [id]);

    return (
        <div>
            <h4>{product.name}</h4>
            <h4>Left: {product.amount}</h4>
            <ul>
            {
                product.description.map((desc,index)=>{
                   return <li key = {index}>{desc}</li>
                }

                )
            }
            </ul>
            <h4>Price: €{product.price}</h4>
            <Button variant="primary" onClick={()=> CartFunctions.addToCart(product.id,1)}>Add item to cart</Button>
        </div>
    )
}

export default MasterDetails;