package com.enigmacamp.myjwt.utils;

import com.enigmacamp.myjwt.exception.UnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Component
public class RestUtil {
    private final RestTemplate restTemplate;

    public RestUtil(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String get(String url){
        try{
            ResponseEntity result = restTemplate.getForEntity(url,String.class);
            return result.getBody().toString();
        }catch (HttpClientErrorException ee){
            if(ee.getStatusCode().equals(HttpStatus.UNAUTHORIZED)){
                throw new UnauthorizedException(ee.getMessage());
            }
            if(ee.getStatusCode().equals((HttpStatus.NOT_FOUND))){
                throw new UnauthorizedException(ee.getMessage());
            }
        }catch (RestClientException e){
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return null;
    }
}
