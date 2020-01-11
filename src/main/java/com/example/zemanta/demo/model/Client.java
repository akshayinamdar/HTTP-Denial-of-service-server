package com.example.zemanta.demo.model;

/**
 * Model for each HTTP client
 */
public class Client {
    private long count;         //counter to check if it exceeds upper limit i.e., 5
    private long startTime;     //time to check difference with current time

    public Client(long count, long startTime) {
        this.count = count;
        this.startTime = startTime;
    }

    public long getCount() {
        return count;
    }

    public long getStartTime() {
        return startTime;
    }

}
