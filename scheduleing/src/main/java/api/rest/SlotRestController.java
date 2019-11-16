package api.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.entity.Professor;
import api.entity.Slot;
import api.entity.Student;
import api.entity.slottime;
import api.thread.sendnoterequest;
import api.entity.Slotinfo;

@RestController
@RequestMapping("/Slot")
public class SlotRestController {

	@GetMapping(path = "/Cancel/{slotid}/{profid}")
	public String slot_update(@PathVariable String slotid, @PathVariable String profid)
	{
	
		Date date=new Date();
		String CurrentTime;
		int Currentday;
		System.out.println("Job trigged by scheduler");
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
		System.out.println(formatter.format(date));
		CurrentTime=formatter.format(date);	
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Currentday=calendar.get(Calendar.DAY_OF_WEEK);
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).addAnnotatedClass(slottime.class).buildSessionFactory();
		Session session=factory.openSession();
		Slot updatedslot=new Slot();
		try {
				Transaction tx=session.beginTransaction();
			System.out.println("I am saving"+slotid);
			slottime slotinfo=(slottime) session.get(slottime.class, slotid);
			if(Currentday==slotinfo.getDay())
			{
				System.out.println("day is same");
				String time1=slotinfo.getTime();
				String time2="03:00:00";
				 SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
				    timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
				    Date date1 = timeFormat.parse(time1);
				    Date date2 = timeFormat.parse(time2);
				    long sum = date1.getTime() + date2.getTime();

				    String date3 = timeFormat.format(new Date(sum));
				    System.out.println("The sum is "+ date3);
				    
				if(CurrentTime.compareTo(slotinfo.getTime())>=0 && CurrentTime.compareTo(date3)<0)
				{
					System.out.println("you cant cancel class");
					return "invalid";
				}
			}
			SQLQuery cancelslotquery=session.createSQLQuery("select * from slot where slotid='"+slotid+"' and profid='"+profid+"'");
			cancelslotquery.addEntity(Slot.class);
			List<Slot> slots=cancelslotquery.list();
			if(slots.size()==0)
			{
				System.out.println("no record");
				tx.commit();
				session.close();
				System.out.println("here to abort in cancellation where no record");
				return "invalid";
			}
			else
			{
				Slot tempslot=slots.get(0);
				String slotstatus=tempslot.getStatus();
				System.out.println("here is slotid:"+tempslot.getSlotid()+"profid:"+tempslot.getProfid());
				try {
					
					SQLQuery updateslotquery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+slotid+"'");
					updateslotquery.executeUpdate();
					updateslotquery.addEntity(Slot.class);
					if(slotstatus.contains("going"))
					{
						System.out.println("hete to delete table");
						String tablename="slot"+slotid;
						SQLQuery droptablequery=session.createSQLQuery("drop table "+tablename);
						droptablequery.executeUpdate();
					}
					tx.commit();
					session.close();
					System.out.println("going to send notify");
					String studentmessage="slot_"+slotid+"_of_prof_"+profid+"_is_cancelled_";
					sendnoterequest notifyobject=new sendnoterequest("Student",studentmessage);
					Thread thread  =new Thread(notifyobject);
					thread.run();
					System.out.println("sent notify");
					
					System.out.println("here is result value: return in cancelaltion success");
					return "success";
				} 
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("error in updating cancellation");
					return "invlaid";
				}
				//send botifucation for cancellation of slotid class
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error in cancellation ");
			return "invalid";
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
	
	@GetMapping("/Get")
	public List<Slot>  getslot()
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		List<Slotinfo> slotsinfo= new ArrayList<Slotinfo>();
		try {
			session.beginTransaction();
			Query slotgetquery=session.createQuery("from Slot");
			System.out.println("hey succesfully reach here");
			List<Slot> slots=slotgetquery.list();
			/*for(Slot s: slots)
			{
				String tempslotid=s.getSlotid();
				String tempprofid=s.getProfid();
				String tempstatus=s.getStatus();
				String tempsubjectid;
				Slotinfo tempslotinfo=new Slotinfo();
				if(tempprofid==null)
				{
					tempslotinfo.setSlotid(tempslotid);
					slotsinfo.add(tempslotinfo);
					continue;
				}
				System.out.println("hery too");
				Query subjectgetquery=session.createQuery("from Professor where profid='"+tempprofid+"'");
				System.out.println("hello");
				Professor tempprof=(Professor) subjectgetquery.uniqueResult();
				System.out.println("hehe");
				tempsubjectid=tempprof.getSubjectid();
				System.out.println("here sub");
				tempslotinfo.setSlotid(tempslotid);
				tempslotinfo.setStatus(tempstatus);
				tempslotinfo.setSubjectid(tempsubjectid);
				tempslotinfo.setProfid(tempprofid);
				slotsinfo.add(tempslotinfo);
				System.out.println("inside first loop");
			}*/
			session.getTransaction().commit();
			return slots;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("hey error");
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
		return null;
	}
	
	@GetMapping("/Save")
	public Slot saveslot(Slot slot)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("hey success");
			session.save(slot);
			session.getTransaction().commit();
			return slot;
		}
		catch(Exception e)
		{
			
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
		return slot;
	}
	
	@GetMapping(path = "/Update/{slotid}/{profid}/{subjectid}")
	public String update(@PathVariable String slotid, @PathVariable String profid,@PathVariable String subjectid)
	{
		Date date=new Date();
		String CurrentTime;
		int Currentday;
		System.out.println("Job trigged by scheduler");
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
		System.out.println(formatter.format(date));
		CurrentTime=formatter.format(date);	
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Currentday=calendar.get(Calendar.DAY_OF_WEEK);
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).addAnnotatedClass(Professor.class).addAnnotatedClass(slottime.class).buildSessionFactory();
		Session session=factory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			System.out.println("hey success in getting in update");
			slottime slotinfo=(slottime) session.get(slottime.class, slotid);
			if(Currentday==slotinfo.getDay())
			{
				String time1=slotinfo.getTime();
				String time2="03:00:00";
				 SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
				    timeFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
				    Date date1 = timeFormat.parse(time1);
				    Date date2 = timeFormat.parse(time2);
				    long sum = date1.getTime() + date2.getTime();

				    String date3 = timeFormat.format(new Date(sum));
				    System.out.println("The sum is "+ date3);
				System.out.println("day is same");
				if(CurrentTime.compareTo(slotinfo.getTime())>=0 && CurrentTime.compareTo(date3)<0)
				{
					System.out.println("you cant update class here to return in update return invalid");
					return "nextweek";
				}
			}
			SQLQuery checkprofsubjectquery=session.createSQLQuery("select * from profsubject where profid='"+profid+"' and subjectid='"+subjectid+"'");
			List<Object[]> proflist=checkprofsubjectquery.list(); 
			if(proflist.size()==0)
			{
				System.out.println("here no record for prof and subject in update return invalid");
				return "invalid";
			}
			SQLQuery updateslotquery=session.createSQLQuery("update slot set profid='"+profid+"',status='ongoing',subjectid='"+subjectid+"' where slotid='"+slotid+"'");
			updateslotquery.executeUpdate();
			String tablename="slot"+slotid;
			System.out.println("creating name of table:"+tablename);
			SQLQuery createtablequery=session.createSQLQuery("create table "+tablename+"(studentid varchar(255) primary key,vote varchar(255))");
			createtablequery.executeUpdate();
			tx.commit();
			session.close();
			System.out.println("going to send notify in simple update");
			String studentmessage="Prof_"+profid+""+"Subject_"+subjectid+""+"Scheduled_on_"+"Slot_"+slotid;
			sendnoterequest notifyobject=new sendnoterequest("Student",studentmessage);
			Thread thread  =new Thread(notifyobject);
			thread.run();
			System.out.println("notify sent for simple update");
			
			//notification for this week class slotid profid subjectid
			System.out.println("here returning success in update");
			return "success";
		}
		catch(Exception e)
		{
			
			System.out.println("update error returning invalid");
			e.printStackTrace();
			System.out.println("returning invalid");
			return "invalid";
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
	
	@GetMapping(path = "/Nextupdate/{slotid}/{profid}/{subjectid}")
	public String updates(@PathVariable String slotid, @PathVariable String profid,@PathVariable String subjectid)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		Session session=factory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			System.out.println("hey success in next update");
			SQLQuery checkprofsubjectquery=session.createSQLQuery("select * from profsubject where profid='"+profid+"' and subjectid='"+subjectid+"'");
			List<Object[]> proflist=checkprofsubjectquery.list(); 
			if(proflist.size()==0)
			{
				System.out.println("here no record for prof and subject in next update return");
				return "invalid";
			}
			SQLQuery updateslotquery=session.createSQLQuery("update slot set profid='"+profid+"',status='ongoing',subjectid='"+subjectid+"' where slotid='"+slotid+"'");
			updateslotquery.executeUpdate();
			String tablename="slot"+slotid;
			System.out.println("name of table:"+tablename);
			System.out.println("now creating table for tablename in next update");
			SQLQuery createtablequery=session.createSQLQuery("create table "+tablename+"(studentid varchar(255) primary key,vote varchar(255))");
			createtablequery.executeUpdate();
			tx.commit();
			session.close();
			System.out.println("sending notify for next update");
			String studentmessage="Prof:"+profid+"\n"+"Subject:"+subjectid+"\n"+"Scheduled on:\n"+"Slot:"+slotid;
			sendnoterequest notifyobject=new sendnoterequest("Student",studentmessage);
			Thread thread  =new Thread(notifyobject);
			thread.run();
			System.out.println("sent notify for next update");
			// notify for schduling class for next week slotid profid subject id
			System.out.println("returning in next update with success");
			return "success";
		}
		catch(Exception e)
		{
			
			System.out.println("next update error");
			e.printStackTrace();
			System.out.println("returning in next update");
			return "invalid";
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
}
