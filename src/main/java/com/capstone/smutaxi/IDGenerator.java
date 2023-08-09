package com.capstone.smutaxi;

import org.springframework.stereotype.Component;

@Component
public class IDGenerator {
    private long nextId = 1;

    public synchronized long getNextId() {
        return nextId++;
    }
}
