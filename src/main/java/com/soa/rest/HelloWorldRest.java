/**
 * 
 */
package com.soa.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.soa.dto.Abc;
import com.soa.dto.Compra;
import com.soa.dto.Response;

/**
 * 
 */
@RestController
public class HelloWorldRest {
    
    @GetMapping("/generador/{no_boletos}") //URL donde lo va a publicar, es el mas simple
    public ResponseEntity<Response> generar(@PathVariable Integer no_boletos) {
        ResponseEntity<Response> re = null;
        Response response = new Response();
        Compra compra = new Compra();
        Abc abc = new Abc();
        Random random = new Random();
        DoubleStream doubles = random.doubles(55);
        IntStream ints = random.ints(100, 1, 11);
        Stream<Integer> boxed = ints.boxed();
        
        //Collect to list
        //Streams
        List<Integer> boletos = random.ints(no_boletos,1,11).boxed().collect(Collectors.toList());
        
/*        List<Integer> boletos = new ArrayList<>();
        int noBoletos = Integer.parseInt(no_boletos);
        for (int i = 0; i < noBoletos; i++) {
            boletos.add(random.nextInt(1,50001));
        }*/
        
        abc.setBoletos(boletos);
        compra.setAbc(abc);
        response.setCompra(compra);
        re = new ResponseEntity<Response>(response, HttpStatus.OK);
        return re;
    }
}
