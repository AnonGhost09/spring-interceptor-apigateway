package com.enigmacamp.myjwt.controllers;

import com.enigmacamp.myjwt.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/token")
public class TokenController {

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping
    public ResponseEntity getToken(){
        return ResponseEntity.ok(jwtUtil.generateToken("tes"));
    }

}
