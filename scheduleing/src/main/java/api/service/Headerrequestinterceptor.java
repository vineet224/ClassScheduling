package api.service;

import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

public class Headerrequestinterceptor implements ClientHttpRequestInterceptor{

	private final String headerName;
	  private final String headerValue;
	 
	  public Headerrequestinterceptor(String headerName, String headerValue) {
	    this.headerName = headerName;
	    this.headerValue = headerValue;
	  }
	  
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {	
		HttpRequest wrapper = new HttpRequestWrapper(request);
	    wrapper.getHeaders().set(headerName, headerValue);
	    return execution.execute(wrapper, body);
	}

}
