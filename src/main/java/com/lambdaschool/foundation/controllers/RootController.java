package com.lambdaschool.foundation.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController
{
    @GetMapping(value = "/",
        produces = "application/json")
    public ResponseEntity<?> sayHello()
    {
        return new ResponseEntity<>("Hello From the Labs28 Citrics-D team! Please review documentation for valid endpoint.",
            HttpStatus.OK);
    }
}
