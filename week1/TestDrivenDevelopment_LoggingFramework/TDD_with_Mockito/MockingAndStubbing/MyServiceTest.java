package com.sample.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.sample.ExternalApi;
import com.sample.MyService;
public class MyServiceTest {
	@Test
 	public void testExternalApi() {
		ExternalApi mockApi = Mockito.mock(ExternalApi.class);
		when(mockApi.getData()).thenReturn("Mock Data");
		MyService service = new MyService(mockApi);
		String result = service.fetchData();
		assertEquals("Mock Data", result);
 }
}