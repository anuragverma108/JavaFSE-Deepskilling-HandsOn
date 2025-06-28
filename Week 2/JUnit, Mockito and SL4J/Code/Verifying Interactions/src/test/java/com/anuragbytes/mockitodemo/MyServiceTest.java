package com.anuragbytes.mockitodemo;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.mockito.Mockito;
import org.mockito.InOrder;

public class MyServiceTest {
    
    private ExternalApi mockApi;
    private MyService service;
    
    @BeforeEach
    public void setUp() {
        mockApi = Mockito.mock(ExternalApi.class);
        service = new MyService(mockApi);
    }
    
    @Test
    @DisplayName("Test basic interaction verification - verify getData() is called")
    public void testVerifyInteraction() {
        service.fetchData();
        verify(mockApi).getData();
    }
    
    @Test
    @DisplayName("Test verification with specific arguments")
    public void testVerifyInteractionWithSpecificArguments() {
        when(mockApi.sendData("test data", 1)).thenReturn(true);
        
        boolean result = service.processAndSendData("test data", 1);
        
        verify(mockApi).sendData("test data", 1);
        assertTrue(result);
    }
    
    @Test
    @DisplayName("Test verification of multiple interactions")
    public void testVerifyMultipleInteractions() {
        when(mockApi.getData()).thenReturn("external data");
        when(mockApi.sendData(anyString(), eq(1))).thenReturn(true);
        
        String result = service.performComplexOperation("input data");
        
        verify(mockApi).getData();
        verify(mockApi).sendData("input data processed with external data", 1);
        assertEquals("Operation completed successfully", result);
    }
    
    @Test
    @DisplayName("Test verification of interaction count")
    public void testVerifyInteractionCount() {
        when(mockApi.getData()).thenReturn("data");
        
        service.fetchData();
        service.fetchData();
        service.fetchData();
        
        verify(mockApi, times(3)).getData();
    }
    
    @Test
    @DisplayName("Test verification that method was never called")
    public void testVerifyMethodNeverCalled() {
        service.fetchData();
        
        verify(mockApi).getData();
        verify(mockApi, never()).sendData(anyString(), anyInt());
    }
    
    @Test
    @DisplayName("Test verification with argument matchers")
    public void testVerifyWithArgumentMatchers() {
        when(mockApi.sendData(anyString(), anyInt())).thenReturn(true);
        
        service.processAndSendData("any data", 5);
        
        verify(mockApi).sendData(anyString(), eq(5));
        verify(mockApi).sendData(startsWith("any"), anyInt());
    }
    
    @Test
    @DisplayName("Test verification of interaction order")
    public void testVerifyInteractionOrder() {
        when(mockApi.getData()).thenReturn("external data");
        when(mockApi.sendData(anyString(), anyInt())).thenReturn(true);
        
        service.performComplexOperation("test input");
        
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockApi).sendData(anyString(), eq(1));
    }
    
    @Test
    @DisplayName("Test verification with timeout")
    public void testVerifyWithTimeout() {
        when(mockApi.getData()).thenReturn("data");
        
        service.fetchData();
        
        verify(mockApi, timeout(1000)).getData();
    }
} 