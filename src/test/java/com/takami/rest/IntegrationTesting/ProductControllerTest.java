package com.takami.rest.IntegrationTesting;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.takami.rest.Service.ProductService;
import com.takami.rest.model.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Profile("test")
@AutoConfigureTestDatabase

public class ProductControllerTest {



    @Autowired
    private WebApplicationContext webAppContext;

    private MockMvc mvc;


    @MockBean
    private ProductService service;

    List<Product> products;

    ObjectMapper objectMapper = new ObjectMapper();

    @Before
    public void setMockMvc(){
        MockitoAnnotations.initMocks(this);
        mvc = MockMvcBuilders.webAppContextSetup(webAppContext).build();

        products = new ArrayList<Product>();

        Product p1 = new Product();
        p1.setName("product 1");
        p1.setAmount(3);
        p1.setId(0L);
        products.add(p1);

        Product p2 = new Product();
        p1.setName("product 2");
        p1.setAmount(4);
        p1.setId(1L);
        products.add(p2);
    }


   @Test
   public void testGetAllProducts() throws Exception {


        Mockito.when(service.findAllProducts()).thenReturn(products);

       RequestBuilder builder = MockMvcRequestBuilders.get("/products");

       MvcResult mvcResult = mvc.perform(builder).andReturn();

       String content = mvcResult.getResponse().getContentAsString();
       String expected = objectMapper.writeValueAsString(products);

       Assert.assertEquals(content,expected);

    }

    @Test
    public void testAddNewProduct() throws Exception{

        Product newProduct = new Product();
        newProduct.setId(2L);
        newProduct.setAmount(3);
        newProduct.setName("new product");
        Mockito.doNothing().when(service).addNewProduct(isA(Product.class));
        products.add(newProduct);

        String json = objectMapper.writeValueAsString(newProduct);
        RequestBuilder builder = MockMvcRequestBuilders.post("/products").contentType(APPLICATION_JSON_UTF8)
                .content(json);

        int result = mvc.perform(builder).andReturn().getResponse().getStatus();

        Assert.assertNotNull(products.get(2));
        Assert.assertEquals(201,result);

    }

    @Test
    public void testGetProductById() throws  Exception{
        Mockito.when(service.findProductById(1L)).thenReturn(products.get(1));

        RequestBuilder builder = MockMvcRequestBuilders.get("/products/1");

        String content = mvc.perform(builder).andReturn().getResponse().getContentAsString();
        String expected = objectMapper.writeValueAsString(products.get(1));

        Assert.assertEquals(expected,content);

    }
    }
