package com.anuragbytes.mockitodemo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;

public class MyServiceTest {
    
    private ExternalApi mockApi;
    private MyService service;
    
    @BeforeEach
    void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
    }
    
    @Test
    @DisplayName("Test fetching data from external API")
    public void testExternalApi() {
        when(mockApi.getData()).thenReturn("Mock Data");
        
        String result = service.fetchData();
        
        assertEquals("Mock Data", result);
        
        verify(mockApi).getData();
    }
    
    @Test
    @DisplayName("Test sending data to external API")
    public void testSendData() {
        when(mockApi.sendData("Test Data")).thenReturn(true);
        
        boolean result = service.sendData("Test Data");
        
        assertTrue(result);
        verify(mockApi).sendData("Test Data");
    }
    
    @Test
    @DisplayName("Test getting API status")
    public void testGetApiStatus() {
        when(mockApi.getStatus()).thenReturn("ONLINE");
        
        String status = service.getApiStatus();
        
        assertEquals("ONLINE", status);
        verify(mockApi).getStatus();
    }
    
    @Test
    @DisplayName("Test processing data with successful flow")
    public void testProcessData_Success() {
        when(mockApi.getData()).thenReturn("Original Data");
        when(mockApi.sendData("Processed: Original Data")).thenReturn(true);
        
        boolean result = service.processData();
        
        assertTrue(result);
        verify(mockApi).getData();
        verify(mockApi).sendData("Processed: Original Data");
    }
    
    @Test
    @DisplayName("Test processing data with empty data")
    public void testProcessData_EmptyData() {
        when(mockApi.getData()).thenReturn("");
        
        boolean result = service.processData();
        
        assertFalse(result);
        verify(mockApi).getData();
        verify(mockApi, never()).sendData(anyString());
    }
    
    @Test
    @DisplayName("Test processing data with null data")
    public void testProcessData_NullData() {
        when(mockApi.getData()).thenReturn(null);
        
        boolean result = service.processData();
        
        assertFalse(result);
        verify(mockApi).getData();
        verify(mockApi, never()).sendData(anyString());
    }
    
    @Test
    @DisplayName("Test multiple calls with different responses")
    public void testMultipleCalls() {
        when(mockApi.getData())
            .thenReturn("First Call")
            .thenReturn("Second Call")
            .thenReturn("Third Call");
        
        assertEquals("First Call", service.fetchData());
        assertEquals("Second Call", service.fetchData());
        assertEquals("Third Call", service.fetchData());
        
        verify(mockApi, times(3)).getData();
    }
    
    @Test
    @DisplayName("Test exception handling with mock")
    public void testExceptionHandling() {
        when(mockApi.getData()).thenThrow(new RuntimeException("API Error"));
        
        assertThrows(RuntimeException.class, () -> {
            service.fetchData();
        });
        
        verify(mockApi).getData();
    }
} 