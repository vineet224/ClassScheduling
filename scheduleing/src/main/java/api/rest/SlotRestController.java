package api.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
				if(CurrentTime.compareTo(slotinfo.getTime())>=0)
				{
					System.out.println("you cant cancell class");
					return "abort";
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
				return "abort";
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
					String studentmessage="slot "+slotid+" of prof "+profid+" is cancelled ";
					sendnoterequest notifyobject=new sendnoterequest("Student",studentmessage);
					notifyobject.run();
					System.out.println("sent notify");
					
					System.out.println("here is result value:");
					
				} 
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("error in updating");
					return "abort";
				}
				//send botifucation for cancellation of slotid class
				return "success";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("error in cancellation ");
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
		return "abort";
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
			System.out.println("hey success");
			slottime slotinfo=(slottime) session.get(slottime.class, slotid);
			if(Currentday==slotinfo.getDay())
			{
				System.out.println("day is same");
				if(CurrentTime.compareTo(slotinfo.getTime())>=0)
				{
					System.out.println("you cant cancell class");
					return "notscheduledfortoday";
				}
			}
			SQLQuery checkprofsubjectquery=session.createSQLQuery("select * from profsubject where profid='"+profid+"' and subjectid='"+subjectid+"'");
			List<Object[]> proflist=checkprofsubjectquery.list(); 
			if(proflist.size()==0)
			{
				System.out.println("here no record for prof and subject");
				return "invalid";
			}
			SQLQuery updateslotquery=session.createSQLQuery("update slot set profid='"+profid+"',status='ongoing',subjectid='"+subjectid+"' where slotid='"+slotid+"'");
			updateslotquery.executeUpdate();
			String tablename="slot"+slotid;
			System.out.println("name of table:"+tablename);
			SQLQuery createtablequery=session.createSQLQuery("create table "+tablename+"(studentid varchar(255) primary key,vote varchar(255))");
			createtablequery.executeUpdate();
			tx.commit();
			session.close();
			String studentmessage="A class on "+slotid+" of prof "+profid+" of subject "+subjectid+" is scheduled ongoing vote ypur decission";
			
			Session session2=factory.openSession();
			Transaction tx2=session2.beginTransaction();
			Slot updatedslot=(Slot) session2.get(Slot.class,slotid);
			tx2.commit();
			session2.close();
			//notification for this week class slotid profid subjectid
			return "success";
		}
		catch(Exception e)
		{
			
			System.out.println("update error");
			e.printStackTrace();
			return "invalid";
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
	
	@GetMapping(path = "/Updates/{slotid}/{profid}/{subjectid}")
	public String updates(@PathVariable String slotid, @PathVariable String profid,@PathVariable String subjectid)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		Session session=factory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			System.out.println("hey success");
			SQLQuery checkprofsubjectquery=session.createSQLQuery("select * from profsubject where profid='"+profid+"' and subjectid='"+subjectid+"'");
			List<Object[]> proflist=checkprofsubjectquery.list(); 
			if(proflist.size()==0)
			{
				System.out.println("here no record for prof and subject");
				return "invalid";
			}
			SQLQuery updateslotquery=session.createSQLQuery("update slot set profid='"+profid+"',status='ongoing',subjectid='"+subjectid+"' where slotid='"+slotid+"'");
			updateslotquery.executeUpdate();
			String tablename="slot"+slotid;
			System.out.println("name of table:"+tablename);
			SQLQuery createtablequery=session.createSQLQuery("create table "+tablename+"(studentid varchar(255) primary key,vote varchar(255))");
			createtablequery.executeUpdate();
			tx.commit();
			session.close();
			String studentmessage="A class on "+slotid+" of prof "+profid+" of subject "+subjectid+" is scheduled in next week ongoing vote ypur decission";
			
			Session session2=factory.openSession();
			Transaction tx2=session2.beginTransaction();
			Slot updatedslot=(Slot) session2.get(Slot.class,slotid);
			tx2.commit();
			session2.close();
			// notify for schduling class for next week slotid profid subject id
			return "success";
		}
		catch(Exception e)
		{
			
			System.out.println("update error");
			e.printStackTrace();
			return "invalid";
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
}
