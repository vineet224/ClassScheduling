package api.service;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class Androidpushnotificationservice {

	  private static final String FIREBASE_SERVER_KEY = "AAAA91yEJMg:APA91bGGtlOi3AGZNwDF1ckWSfoW0lYUJE3zkg7pD7xOzD7a2c8SUdN_Fcjg87C4kZY0V19VSjXDSvFlrV1iupTGnbZfWisZ6u1Y8a3eSzJT6-b_4e9g2Fus0OXJ9tl_hxU6-fR3Wvah";
	  private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	  
	  @Async
	  public CompletableFuture<String> send(HttpEntity<String> entity) {
	 
	    RestTemplate restTemplate = new RestTemplate();
	 
	    /**
	    https://fcm.googleapis.com/fcm/send
	    Content-Type:application/json
	    Authorization:key=FIREBASE_SERVER_KEY*/
	 
	    System.out.println("hello here in apns1");
	    ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
	    interceptors.add(new Headerrequestinterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
	    interceptors.add(new Headerrequestinterceptor("Content-Type", "application/json"));
	    restTemplate.setInterceptors(interceptors);
	    System.out.println("hello here in apns2");
	    String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
	    System.out.println("hello here in apns3");
	    return CompletableFuture.completedFuture(firebaseResponse);
	  }
}
