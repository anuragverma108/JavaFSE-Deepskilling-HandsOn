package com.anuragbytes.mockitodemo;

public interface ExternalApi {
    
    String getData();
    
    boolean sendData(String data, int priority);
} 