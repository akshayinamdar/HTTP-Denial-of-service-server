package com.example.zemanta.demo.service;

import org.springframework.http.ResponseEntity;

/**
 * Interface for the Service Layer
 */
public interface ClientService {

    ResponseEntity getResponse(long clientId);

}
