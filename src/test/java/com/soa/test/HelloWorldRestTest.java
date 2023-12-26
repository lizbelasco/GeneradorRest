/**
 * 
 */
package com.soa.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.soa.dto.Response;

/**
 * 
 */
class HelloWorldRestTest {

    @Test
    void test() {
        String url = "http://localhost:8080/generador/10";
        RestTemplate restTemplate = new RestTemplate();
        MultiValueMap headers = new HttpHeaders();
        headers.add("noControl", "12345");
//        Compra c = new Compra(); -> si fuera body compra
//        HttpEntity request = new HttpEntity(c, headers );
        HttpEntity request = new HttpEntity(headers );
        ResponseEntity<Response> re = restTemplate.exchange(url, HttpMethod.GET, request , Response.class);
        int size = re.getBody().getCompra().getAbc().getBoletos().size();
        assertEquals(10,size);
        assertEquals(200,re.getStatusCode().value());
    }

}
