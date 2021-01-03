package com.takami.rest.model;

import org.assertj.core.util.diff.Delta;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.security.core.parameters.P;

public class ProductTest {

    private static final double DELTA = 1e-15;


    @Test
    void testEmptyConstructor() {
        Product product = new Product();
        Assert.assertNotNull(product);
    }

    @Test
    void testConstructor() {
        Product product = new Product(1L, 2, 3, "product", "img", ProductType.HOOK, "hook");
        Assert.assertEquals(1, product.getId().intValue());
        Assert.assertEquals(2, product.getAmount());
        Assert.assertEquals(3, product.getPrice(), DELTA);
        Assert.assertEquals("product", product.getName());
        Assert.assertEquals("img", product.getPathToImage());
        Assert.assertEquals(ProductType.HOOK, product.getProductType());
        Assert.assertEquals("hook", product.getDescription());

    }

    @Test
    void testSetId(){
        Product product = new Product();
        product.setId(1L);
        Assert.assertEquals(1,product.getId().intValue());
    }

    @Test
    void testSetAmount(){
        Product  product = new Product();
        product.setAmount(3);
        Assert.assertEquals(3,product.getAmount());
    }

    @Test
    void testSetPrice(){
        Product product = new Product();
        product.setPrice(3.50);
        Assert.assertEquals(3.50,product.getPrice(),DELTA);
    }

    @Test
    void testSetName(){
        Product product = new Product();
        product.setName("product");
        Assert.assertEquals("product",product.getName());
    }

    @Test
    void testSetProductType(){
        Product product = new Product();
        product.setProductType(ProductType.ROD);
        Assert.assertEquals(ProductType.ROD,product.getProductType());
    }

    @Test
    void testSetDescription(){
        Product product = new Product();
        product.setDescription("description");
        Assert.assertEquals("description", product.getDescription());
    }

    @Test
    void testBuyProduct(){
        Product product = new Product();
        product.setAmount(5);
        Assert.assertEquals(5,product.getAmount());
        product.buyProduct(3);
        Assert.assertEquals(2,product.getAmount());
    }

}