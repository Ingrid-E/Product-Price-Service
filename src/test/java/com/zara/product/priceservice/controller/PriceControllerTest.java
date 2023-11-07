package com.zara.product.priceservice.controller;

import com.zara.product.priceservice.controller.response.PriceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PriceControllerTest {
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    public void test1() throws Exception {
        String startDate = "2020-06-14-10.00.00";
        Integer productId = 35455;
        Integer brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/product/price?startDate="+startDate+"&productId="+productId+"&brandId="+brandId, PriceResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(35.5, response.getBody().getPrice());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals("2020-06-14T00:00", response.getBody().getStartDate().toString());
        assertEquals("2020-12-31T23:59:59", response.getBody().getEndDate().toString());
    }

    @Test
    public void test2() throws Exception {
        String startDate = "2020-06-14-16.00.00";
        Integer productId = 35455;
        Integer brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/product/price?startDate="+startDate+"&productId="+productId+"&brandId="+brandId, PriceResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(25.45, response.getBody().getPrice());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals("2020-06-14T15:00", response.getBody().getStartDate().toString());
        assertEquals("2020-06-14T18:30", response.getBody().getEndDate().toString());
    }

    @Test
    public void test3() throws Exception {
        String startDate = "2020-06-14-21.00.00";
        Integer productId = 35455;
        Integer brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/product/price?startDate="+startDate+"&productId="+productId+"&brandId="+brandId, PriceResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(35.5, response.getBody().getPrice());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals("2020-06-14T00:00", response.getBody().getStartDate().toString());
        assertEquals("2020-12-31T23:59:59", response.getBody().getEndDate().toString());
    }

    @Test
    public void test4() throws Exception {
        String startDate = "2020-06-15-10.00.00";
        Integer productId = 35455;
        Integer brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/product/price?startDate="+startDate+"&productId="+productId+"&brandId="+brandId, PriceResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(30.5, response.getBody().getPrice());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals("2020-06-15T00:00", response.getBody().getStartDate().toString());
        assertEquals("2020-06-15T11:00", response.getBody().getEndDate().toString());
    }

    @Test
    public void test5() throws Exception {
        String startDate = "2020-06-16-21.00.00";
        Integer productId = 35455;
        Integer brandId = 1;

        ResponseEntity<PriceResponse> response = restTemplate.getForEntity("/product/price?startDate="+startDate+"&productId="+productId+"&brandId="+brandId, PriceResponse.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(38.95, response.getBody().getPrice());
        assertEquals(35455, response.getBody().getProductId());
        assertEquals(1, response.getBody().getBrandId());
        assertEquals("2020-06-15T16:00", response.getBody().getStartDate().toString());
        assertEquals("2020-12-31T23:59:59", response.getBody().getEndDate().toString());
    }
}
