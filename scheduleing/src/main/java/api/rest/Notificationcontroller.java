package api.rest;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
 
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.service.Androidpushnotificationservice;

@RestController
public class Notificationcontroller {

	 private final String TOPIC = "Instructor";
	 
	 @Autowired
	  Androidpushnotificationservice androidPushNotificationsService;
	 
	  @GetMapping(path = "/send/{topic}/{message}", produces = "application/json")
	  public ResponseEntity<String> send(@PathVariable String topic,@PathVariable String message) throws JSONException {
		  
		  JSONObject body = new JSONObject();
		    body.put("to", "/topics/" + topic);
		    body.put("priority", "high");
		 
		    JSONObject notification = new JSONObject();
		    notification.put("title", "JSA Notification");
		    notification.put("body", message);
		    
		    JSONObject data = new JSONObject();
		    data.put("Key-1", "JSA Data 1");
		    data.put("Key-2", "JSA Data 2");
		 
		    body.put("notification", notification);
		    body.put("data", data);
		    
		    HttpEntity<String> request = new HttpEntity<String>(body.toString());
		    
		    CompletableFuture<String> pushNotification = androidPushNotificationsService.send(request);
		    CompletableFuture.allOf(pushNotification).join();
		    
		    try {
		        String firebaseResponse = pushNotification.get();
		        
		        return new ResponseEntity<String>(firebaseResponse, HttpStatus.OK);
		      } catch (InterruptedException e) {
		        e.printStackTrace();
		      } catch (ExecutionException e) {
		        e.printStackTrace();
		      }
		    
		return new ResponseEntity<String>("Push Notification ERROR!", HttpStatus.BAD_REQUEST);
	  }
	  
}
