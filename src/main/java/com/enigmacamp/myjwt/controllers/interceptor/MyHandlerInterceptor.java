package com.enigmacamp.myjwt.controllers.interceptor;

import com.enigmacamp.myjwt.controllers.UrlMappings;
import com.enigmacamp.myjwt.exception.UnauthorizedException;
import com.enigmacamp.myjwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class MyHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    RestTemplate restTemplate;

    @Value("${service.authentication}")
    String authServiceUrl;

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       if(request.getRequestURI().contains(UrlMappings.TOKEN_URL)){
//           return true;
//       }
        try {
            String tokenHeader = request.getHeader("Authorization").split(" ")[1];
            restTemplate.getForEntity(authServiceUrl + "?token=" + tokenHeader, String.class);
            return true;
        }
        catch (RestClientException e){
            throw new RuntimeException(e);
        }
    }
}
