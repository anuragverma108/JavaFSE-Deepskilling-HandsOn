package com.anuragbytes.mockitodemo;

public class MyService {
    
    private final ExternalApi externalApi;
    
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
    
    public String fetchData() {
        return externalApi.getData();
    }
    
    public boolean sendData(String data) {
        return externalApi.sendData(data);
    }
    
    public String getApiStatus() {
        return externalApi.getStatus();
    }
    
    public boolean processData() {
        String data = externalApi.getData();
        if (data != null && !data.isEmpty()) {
            return externalApi.sendData("Processed: " + data);
        }
        return false;
    }
} 