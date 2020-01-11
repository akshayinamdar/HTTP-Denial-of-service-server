package com.example.zemanta.demo.service.impl;

import com.example.zemanta.demo.common.Constants;
import com.example.zemanta.demo.model.Client;
import com.example.zemanta.demo.model.Content;
import com.example.zemanta.demo.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Service to handle all requests
 */
@Service
public class ClientServiceImpl implements ClientService {

    private static final String template = Constants.TEMPLATE;
    private final Map<Long, Client> idList = new HashMap<>();

    @Override
    public ResponseEntity getResponse(long clientId) {
        Client client = idList.get(clientId);
        if(client!=null && (System.currentTimeMillis() - client.getStartTime())<=Constants.UPPER_TIME_LIMIT_IN_MILLISECONDS) { //if the time is within the timeout(5 seconds) then add the client request to map, else send 503 error
            long timeDifference = System.currentTimeMillis() - client.getStartTime();
            if(client.getCount()<Constants.UPPER_TIME_LIMIT_IN_SECONDS) {
                idList.put(clientId, new Client(client.getCount() + 1, client.getStartTime()));
                return new ResponseEntity(new Content(String.format(template, clientId, idList.get(clientId).getCount(), (Constants.UPPER_TIME_LIMIT_IN_SECONDS - (timeDifference/Constants.SECOND_TO_MILLISECOND)))), HttpStatus.OK);
            } return new ResponseEntity(new Content(String.format(template, clientId, client.getCount(), (Constants.UPPER_TIME_LIMIT_IN_SECONDS - (timeDifference/Constants.SECOND_TO_MILLISECOND)))), HttpStatus.SERVICE_UNAVAILABLE);
        }  //if the time limit has exceeded or client does not existent then reset the count and clock and add the client request
        idList.put(clientId, new Client(Constants.INITIAL_COUNT, System.currentTimeMillis()));
        return new ResponseEntity(new Content(String.format(template, clientId, Constants.INITIAL_COUNT, Constants.UPPER_TIME_LIMIT_IN_SECONDS)), HttpStatus.OK);
    }

}
