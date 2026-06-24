package com.sample.Mockito1;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.sample.ExternalApi;
import com.sample.MyService;
public class MyServiceTest {
	@Test
 	public void testVerifyInteraction() {
		ExternalApi mockApi = Mockito.mock(ExternalApi.class);
		MyService service = new MyService(mockApi);
		service.fetchData();
		verify(mockApi).getData();
 }
} 
