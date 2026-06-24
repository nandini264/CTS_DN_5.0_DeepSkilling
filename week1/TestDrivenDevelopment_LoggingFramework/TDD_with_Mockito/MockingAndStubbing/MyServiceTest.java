package com.sample.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;


import org.mockito.Mockito;

import com.sample.ExternalApi;
import com.sample.MyService;

public class MyServiceTest {

    @org.junit.Test
    public void testExternalApi() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");
        MyService service = new MyService(mockApi);
        String result = service.fetchData();
        assertEquals("Mock Data", result);
    }
}