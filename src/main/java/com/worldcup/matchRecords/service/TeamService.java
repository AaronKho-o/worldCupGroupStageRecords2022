package com.worldcup.matchRecords.service;

public interface TeamService {

    public default Object findAll() {
        Object object = new Object();
        return object;
    }
}
