package api.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class Backgroundjob implements ServletContextListener{

	private ScheduledExecutorService scheduler;
	
	
	public void contextInitialized(ServletContextEvent event) {
		// TODO Auto-generated method stub
		 scheduler = Executors.newSingleThreadScheduledExecutor();
		   // scheduler.scheduleAtFixedRate(new DailyJob(), 0, 1, TimeUnit.DAYS);
		    //scheduler.scheduleAtFixedRate(new HourlyJob(), 0, 1, TimeUnit.SECONDS);
		   //scheduler.scheduleAtFixedRate(new MinJob(), 0, 1, TimeUnit.MINUTES);
		   // scheduler.scheduleAtFixedRate(new SecJob(), 0, 15, TimeUnit.SECONDS);
	}

	public void contextDestroyed(ServletContextEvent event) {
		// TODO Auto-generated method stub
		
	}

}
