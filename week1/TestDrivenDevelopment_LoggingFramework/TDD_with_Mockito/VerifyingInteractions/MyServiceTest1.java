package com.sample.Mockito;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;

import com.sample.ExternalApi;
import com.sample.MyService;

public class MyServiceTest1 {

    @Test
    public void testVerifyInteraction() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.fetchData();
        verify(mockApi).getData();
    }
}