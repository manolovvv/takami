

export function addToCart (productId,quantity){
    let allProducts = JSON.parse(localStorage.getItem("allProducts"));
   
    let cartItems = [];
    if(JSON.parse(sessionStorage.getItem("cart")) ==null){
        sessionStorage.setItem("cart",JSON.stringify({productId, quantity}));
        console.log(1);

    }
    else if(!Array.isArray(JSON.parse(sessionStorage.getItem("cart")))){
        let itemInCart = JSON.parse(sessionStorage.getItem("cart"));
        console.log(itemInCart);
        if(itemInCart.productId ===productId){
            itemInCart.quantity +=quantity;
            sessionStorage.setItem("cart",JSON.stringify(itemInCart));
        }
        else{
        cartItems.push(JSON.parse(sessionStorage.getItem("cart")));
        cartItems.push({productId,quantity});
        sessionStorage.setItem("cart",JSON.stringify(cartItems));}
        console.log(2);
    }
    else{
        console.log(3);
        cartItems = JSON.parse(sessionStorage.getItem("cart"));
        
        let existsInCart = false;
        //cartItems.push({productId,quantity});
        console.log(cartItems.length);
        //sessionStorage.setItem("cart",JSON.stringify(cartItems));
        //console.log(cartItems);
        for(let i=0;i<cartItems.length;i++){
            if(cartItems[i].productId === productId){
                cartItems[i].quantity+= quantity;
                existsInCart = true;
                sessionStorage.setItem("cart",JSON.stringify(cartItems));
            }
        }
        if(!existsInCart){
            cartItems.push({productId,quantity});
            sessionStorage.setItem("cart",JSON.stringify(cartItems));
        }
        

        
    }
    
}

export function decreaseProductQuantityFromCart(productId,quantity){
    let cartItems = JSON.parse(sessionStorage.getItem('cart'));
    if(!Array.isArray(cartItems)){
        if(cartItems.productId === productId){
            cartItems.quantity -= quantity;
        }
    }
    else{
    for(let i=0;i<cartItems.length;i++){
        if(cartItems[i] ===productId){
        cartItems[i].quantity -=quantity;
        }
    }
    }
}

export function setProductQuantityFromCart(productId,quantity){
    let cartItems = JSON.parse(sessionStorage.getItem('cart'));
    if(!Array.isArray(cartItems)){
        if(cartItems.productId === productId){
            cartItems.quantity = quantity;
        }
    }
    else{
    for(let i=0;i<cartItems.length;i++){
        if(cartItems[i] ===productId){
        cartItems[i].quantity =quantity;
        }
    }
    }
}

export function getProductsIdAndQuantityFromCart(){
    let cartItems = JSON.parse(sessionStorage.getItem('cart'));
    return cartItems;
}


export function deleteCart(){
    sessionStorage.removeItem('cart');
}

export async function deleteProductFromCart(productId){
    let cartItems = JSON.parse(sessionStorage.getItem('cart'));
  
    console.log(sessionStorage.getItem('cart'));
    //console.log("delete");
    //console.log(cartItems);
    if(!Array.isArray(cartItems) || (cartItems.length ===1)){
        //console.log(1);
        sessionStorage.removeItem('cart');
    }
    else{
        //console.log("delete222")
    for(let i=0;i<cartItems.length;i++){
        //console.log(cartItems[i].productId+"cikal")
        
        if(cartItems[i].productId === productId){
          
        cartItems = cartItems.splice(i,1);
        //console.log("sled");
        //console.log(JSON.stringify(cartItems));
        sessionStorage.setItem('cart',JSON.stringify(cartItems))

        }
        //console.log(cartItems);
    }
    }
    window.location.reload();
}

