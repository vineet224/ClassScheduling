package api.rest;

import java.util.ArrayList;
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
import api.entity.Slotinfo;

@RestController
@RequestMapping("/Slot")
public class SlotRestController {

	@GetMapping(path = "/Cancell/{slotid}/{profid}")
	public Slot slot_update(@PathVariable String slotid, @PathVariable String profid)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).buildSessionFactory();
		Session session=factory.openSession();
		Slot updatedslot=new Slot();
		try {
				Transaction tx=session.beginTransaction();
			System.out.println("I am saving");
			SQLQuery cancelslotquery=session.createSQLQuery("select * from slot where slotid='"+slotid+"' and profid='"+profid+"'");
			cancelslotquery.addEntity(Slot.class);
			List<Slot> slots=cancelslotquery.list();
			if(slots.size()==0)
			{
				tx.commit();
				session.close();
				return null;
			}
			else
			{
				Slot tempslot=slots.get(0);
				String slotstatus=tempslot.getStatus();
				System.out.println("here is slotid:"+tempslot.getSlotid()+"profid:"+tempslot.getProfid());
				try {
					
					SQLQuery updateslotquery=session.createSQLQuery("update slot set profid=NULL,status=NULL where slotid='"+slotid+"'");
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
					Session session2=factory.openSession();
					Transaction tx2=session2.beginTransaction();
					updatedslot=(Slot) session2.get(Slot.class,slotid);
					System.out.println("hello slotid:"+updatedslot.getSlotid()+" profid:"+updatedslot.getProfid()+"status:"+updatedslot.getStatus());
					tx2.commit();
					session2.close();
					System.out.println("here is result value:");

				} 
				catch(Exception e)
				{
					e.printStackTrace();
					System.out.println("error in updating");
				}
				return updatedslot;
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
		return null;
	}
	
	@GetMapping("/Get")
	public List<Slotinfo>  getslot()
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		List<Slotinfo> slotsinfo= new ArrayList<Slotinfo>();
		try {
			session.beginTransaction();
			Query slotgetquery=session.createQuery("from Slot");
			System.out.println("hey succesfully reach here");
			List<Slot> slots=slotgetquery.list();
			for(Slot s: slots)
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
				Professor tempprof=(Professor) subjectgetquery.uniqueResult();
				tempsubjectid=tempprof.getSubjectid();
				tempslotinfo.setSlotid(tempslotid);
				tempslotinfo.setStatus(tempstatus);
				tempslotinfo.setSubjectid(tempsubjectid);
				tempslotinfo.setProfid(tempprofid);
				slotsinfo.add(tempslotinfo);
			}
			session.getTransaction().commit();
			return slotsinfo;
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
	
	@GetMapping(path = "/Update/{slotid}/{profid}")
	public Slot update(@PathVariable String slotid, @PathVariable String profid)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).addAnnotatedClass(Professor.class).buildSessionFactory();
		Session session=factory.openSession();
		try {
			Transaction tx=session.beginTransaction();
			System.out.println("hey success");
			SQLQuery updateslotquery=session.createSQLQuery("update slot set profid='"+profid+"',status='Ongoing' where slotid='"+slotid+"'");
			updateslotquery.executeUpdate();
			String tablename="slot"+slotid;
			System.out.println("name of table:"+tablename);
			SQLQuery createtablequery=session.createSQLQuery("create table "+tablename+"(studentid varchar(255) primary key,vote varchar(255))");
			createtablequery.executeUpdate();
			tx.commit();
			session.close();
			Session session2=factory.openSession();
			Transaction tx2=session2.beginTransaction();
			Slot updatedslot=(Slot) session2.get(Slot.class,slotid);
			tx2.commit();
			session2.close();
			return updatedslot;
		}
		catch(Exception e)
		{
			System.out.println("update error");
			e.printStackTrace();
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
		return null;
	}
}
