package api.thread;

import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.URL;

import org.springframework.web.bind.annotation.PathVariable;

public class sendnoterequest implements Runnable{

	public static HttpURLConnection connection;
	public String topic;
	public String message;
	public sendnoterequest(String topic,String message)
	{
		this.topic=topic;
		this.message=message;
	}

	public void run() {
		try {
			String urlstring="http://192.168.43.242:8080/scheduleing/send/Instructor/fromrunable";
			URL url=new URL(urlstring);
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("172.31.2.4", 8080));
			Authenticator authenticator = new Authenticator() {

			    public PasswordAuthentication getPasswordAuthentication() {
				return (new PasswordAuthentication("iim2017001", "sd.g8904".toCharArray()));
			    }
			};
	Authenticator.setDefault(authenticator);
	System.out.println("here in runnable;");
	proxy=null;
	if (proxy != null)
	{
		System.out.println("here in proxy not null");
		connection = (HttpURLConnection) url.openConnection(proxy);
	}
	else
	{
		System.out.println("here in null");
		connection = (HttpURLConnection) url.openConnection();
	}
			

	connection.setRequestMethod("GET");
	connection.setConnectTimeout(5000);
	connection.setReadTimeout(10000);
	
	System.out.println("here to print status");
	int status=connection.getResponseCode();
	System.out.println(status);
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
