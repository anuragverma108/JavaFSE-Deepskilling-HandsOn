package com.anuragbytes.mockitodemo;

public class MyService {
    
    private final ExternalApi externalApi;
    
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
    
    public String fetchData() {
        return externalApi.getData();
    }
    
    public boolean processAndSendData(String data, int priority) {
        return externalApi.sendData(data, priority);
    }
    
    public String performComplexOperation(String inputData) {
        String externalData = externalApi.getData();
        
        boolean sent = externalApi.sendData(inputData + " processed with " + externalData, 1);
        
        if (sent) {
            return "Operation completed successfully";
        } else {
            return "Operation failed";
        }
    }
} 