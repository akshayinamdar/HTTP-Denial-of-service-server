package com.example.zemanta.demo.controller;

import com.example.zemanta.demo.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Entry point for the server
 */
@RestController
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    @RequestMapping(path = "/clientId", method = RequestMethod.POST)
    public ResponseEntity greeting(@RequestParam(value="clientId", defaultValue="0") long clientId) {
        return clientService.getResponse(clientId);
    }
}