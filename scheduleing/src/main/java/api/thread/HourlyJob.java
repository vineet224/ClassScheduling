package api.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import api.entity.Slot;

public class HourlyJob implements Runnable{

	public void run() {
		Date date = new Date(); 
		String Time1="07:00:00";
		String Time2="08:00:00";
		String Time3="09:15:00";
		String Time4="10:15:00";
		String Time5="13:00:00";
		String Time6="14:00:00";
		String Time7="15:00:00";
		String temptime="01:05:00";
		String CurrentTime;
		int Currentday;
		System.out.println("Job trigged by scheduler");
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
		System.out.println(formatter.format(date));
		CurrentTime=formatter.format(date);	
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Currentday=calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println("day is:"+Currentday);
        List<String> Slots=new ArrayList<String>();
		String slotid1="mon1";
		String slotid2="tue1";
		String slotid3="wed1";
		String slotid4="thu1";
		String slotid5="fri1";
		String slotid6="sat1";
		String slotid7="sun1";
		Slots.add(slotid1);
		Slots.add(slotid2);
		Slots.add(slotid3);
		Slots.add(slotid4);
		Slots.add(slotid5);
		Slots.add(slotid6);
		Slots.add(slotid7);
		
        if(Currentday==1)
        {
        	//sunday
        	if(CurrentTime.compareTo(temptime)==0)
        	{
        		firstslotscheduleing("sun5","sun6");
        	}
        	if(CurrentTime.compareTo(Time2)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time3)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time4)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time5)==0)
        	{
        		firstslotscheduleing("sun5","sun6");
        	}
        	if(CurrentTime.compareTo(Time6)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time7)==0)
        	{
        		
        	}
        	
        }
        if(Currentday==2)
        {
        	//monday
        	if(CurrentTime.compareTo(Time1)==0)
        	{
        		firstslotscheduleing("mon1","mon2");
        	}
        	if(CurrentTime.compareTo(Time2)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time3)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time4)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time5)==0)
        	{
        		firstslotscheduleing("mon5","mon6");
        	}
        	if(CurrentTime.compareTo(Time6)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time7)==0)
        	{
        		
        	}
        }
        if(Currentday==3)
        {
        	//tuesday
        	if(CurrentTime.compareTo(temptime)==0)
        	{
        		firstslotscheduleing("sun5","sun6");
        	}
        	if(CurrentTime.compareTo(Time2)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time3)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time4)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time5)==0)
        	{
        		//firstslotscheduleing("tue5");
        	}
        	if(CurrentTime.compareTo(Time6)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time7)==0)
        	{
        		
        	}
        }
        if(Currentday==4)
        {
        	//wednessday
        	if(CurrentTime.compareTo(Time1)==0)
        	{
        		firstslotscheduleing("wed1","wed2");
        	}
        	if(CurrentTime.compareTo(Time2)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time3)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time4)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time5)==0)
        	{
        		//firstslotscheduleing("wed5");
        	}
        	if(CurrentTime.compareTo(Time6)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time7)==0)
        	{
        		
        	}
        }
        if(Currentday==5)
        {
        	//thursday
        	if(CurrentTime.compareTo(Time1)==0)
        	{
        		firstslotscheduleing("thu1","thu2");
        	}
        	if(CurrentTime.compareTo(Time2)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time3)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time4)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time5)==0)
        	{
        		//firstslotscheduleing("thu5");
        	}
        	if(CurrentTime.compareTo(Time6)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time7)==0)
        	{
        		
        	}
        }
        if(Currentday==6)
        {
        	//friday
        	if(CurrentTime.compareTo(Time1)==0)
        	{
        		//firstslotscheduleing("fri1","fri2");
        	}
        	if(CurrentTime.compareTo(Time2)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time3)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time4)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time5)==0)
        	{
        		//firstslotscheduleing("fri5");
        	}
        	if(CurrentTime.compareTo(Time6)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time7)==0)
        	{
        		
        	}
        }
        if(Currentday==7)
        {
        	//saturday
        	if(CurrentTime.compareTo(Time1)==0)
        	{
        		firstslotscheduleing("sat1","sat2");
        	}
        	if(CurrentTime.compareTo(Time2)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time3)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time4)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time5)==0)
        	{
        		//firstslotscheduleing("sat2");
        	}
        	if(CurrentTime.compareTo(Time6)==0)
        	{
        		
        	}
        	if(CurrentTime.compareTo(Time7)==0)
        	{
        		
        	}
        }
		/*if(CurrentTime.contentEquals(temptime))
		{
			
			
			SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).buildSessionFactory();
			Session session=factory.openSession();
			String status;
			String profid;
			try {
				Transaction tx=session.beginTransaction();
				System.out.println("hey here to get slot info");
				Slot slot1=(Slot) session.get(Slot.class,slotid1);
				System.out.println("profid:"+slot1.getProfid()+" status:"+slot1.getStatus()+" ");
				status=slot1.getStatus();
				profid=slot1.getProfid();
				if(profid==null)
				{
					System.out.println("do nothing status empty");
				}
				else if(status.contentEquals("filled"))
				{
					//send notification for filled
					System.out.println("here status is filled");
				}
				else if(status.contentEquals("ongoing"))
				{
					System.out.println("status is ongoing");
					String tablename="slot"+slotid1;
					int acceptvote,declinevote;
					SQLQuery getvotequery=session.createSQLQuery("select * from "+tablename+" where vote='yes'");
					List accepters=getvotequery.list();
					acceptvote=accepters.size();
					SQLQuery getvotequery2=session.createSQLQuery("select * from "+tablename+" where vote='no'");
					List decliners=getvotequery2.list();
					declinevote=decliners.size();
					if(acceptvote>declinevote)
					{
						SQLQuery addquery=session.createSQLQuery("update slot set profid='"+profid+"',status='filled' where slotid='"+slotid1+"'");
						addquery.executeUpdate();
						//send notification for scheduling ongoing class
					}
					else
					{
						SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL where slotid='"+slotid1+"'");
						deletequery.executeUpdate();
						//send notification for cancelling ongoing class
					}
					SQLQuery deletevotequery=session.createSQLQuery("drop table "+tablename);
					deletevotequery.executeUpdate();
				}
				else
				{
					System.out.println("status is empty");
					//do nothing case where no class is schedule in this slot
				}
				tx.commit();
				session.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally {
				factory.close();
				System.out.println("All done");
			}
		}*/
	}

	public void firstslotscheduleing(String firstslotid,String secondslotid)
	{
		System.out.println("slotid is:"+firstslotid);
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).buildSessionFactory();
		Session session=factory.openSession();
		String firststatus;
		String firstprofid;
		String secondstatus;
		String secondprofid;
		String firstsubjectid;
		String secondsubjectid;
		int firstacceptvotes = 0,firstdeclinevotes=0,secondacceptvotes=0,seconddeclinevotes=0;
		try {
			Transaction tx=session.beginTransaction();
			System.out.println("hey here to get slot info");
			Slot firstslot=(Slot) session.get(Slot.class,firstslotid);	
			Slot secondslot=(Slot) session.get(Slot.class, secondslotid);
			System.out.println("profid:"+firstslot.getProfid()+" status:"+firstslot.getStatus()+" ");
			System.out.println("profid:"+secondslot.getProfid()+" status:"+secondslot.getStatus()+" ");
			firststatus=firstslot.getStatus();
			firstprofid=firstslot.getProfid();
			firstsubjectid=firstslot.getSubjectid();
			secondprofid=secondslot.getProfid();
			secondstatus=secondslot.getStatus();
			secondsubjectid=secondslot.getSubjectid();
			if(firstprofid!=null && firststatus.contentEquals("ongoing"))
			{
				System.out.println("status is ongoing");
				String tablename="slot"+firstslotid;
				SQLQuery getvotequery=session.createSQLQuery("select * from "+tablename+" where vote='yes'");
				List accepters=getvotequery.list();
				firstacceptvotes=accepters.size();
				SQLQuery getvotequery2=session.createSQLQuery("select * from "+tablename+" where vote='no'");
				List decliners=getvotequery2.list();
				firstdeclinevotes=decliners.size();
				System.out.println("accept:"+firstacceptvotes+"decline"+firstdeclinevotes);
			}
			if(secondprofid!=null && secondstatus.contentEquals("ongoing"))
			{
				System.out.println("status is ongoing");
				String tablename="slot"+secondslotid;
				SQLQuery getvotequery=session.createSQLQuery("select * from "+tablename+" where vote='yes'");
				List accepters=getvotequery.list();
				secondacceptvotes=accepters.size();
				SQLQuery getvotequery2=session.createSQLQuery("select * from "+tablename+" where vote='no'");
				List decliners=getvotequery2.list();
				seconddeclinevotes=decliners.size();
				System.out.println("saccept:"+secondacceptvotes+"sdecline"+seconddeclinevotes);
			}
			//starting main if else logic
			if(firststatus==null)
			{
				// do nothing
			}
			else if(firststatus!=null && secondstatus==null)
			{
				if(firststatus.contentEquals("filled"))
				{
					System.out.println("here in this in 1 func1");
					//send notification of 1 hr class
	
				}
				else if(firststatus.contentEquals("ongoing"))
				{
					if(firstacceptvotes>firstdeclinevotes)
					{
						SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
						addquery.executeUpdate();
						System.out.println("here in this in 2 func1");
						//send notification of 1 hr class
					}
					else
					{
						SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
						deletequery.executeUpdate();
						System.out.println("here in this in 3 func1");
						//send notification for cancelling ongoing class
					}
				}
				else
				{
					System.out.println("in this unexpected else 4");
				}
			}
			else if(firststatus!=null && secondstatus!=null)
			{
				if(firstprofid.contentEquals(secondprofid) && firstsubjectid.contentEquals(secondsubjectid))
				{
					if(firststatus.contentEquals("filled") && secondstatus.contentEquals("filled"))
					{
						System.out.println("here in this in 5 func1");
						//send notification of 2 hr
					}
					else if(firststatus.contentEquals("filled") && secondstatus.contentEquals("ongoing"))
					{
						if(secondacceptvotes>seconddeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
							addquery.executeUpdate();
							System.out.println("here in this in 6 func1");
							//send notification for 2 hr
						}
						else
						{
							//SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+secondslotid+"'");
							//deletequery.executeUpdate();
							System.out.println("here in this in 7 func1");
							//send notification for 1 hr class
						}
						
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("filled"))
					{
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							System.out.println("here in this in 8 func1");
							//send notification of 2 hr class
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							System.out.println("here in this in 9 func1");
							//send notification for cancelling ongoing class
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("ongoing"))
					{
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							if(secondacceptvotes>seconddeclinevotes)
							{
								SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
								addquery2.executeUpdate();
								System.out.println("here in this in 10 func1");
								// notification for 2 hr
							}
							else
							{
								//SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+secondslotid+"'");
								//deletequery.executeUpdate();
								System.out.println("here in this in 11 func1");
								//notification for 1 hr
							}
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							System.out.println("here in this in 12 func1");
							//send notification for cancelling ongoing class
						}
					}
				}
				else
				{
					if(firststatus.contentEquals("filled"))
					{
						System.out.println("here in this in 13 func1");
						//send notification of 1 hr class
					}
					else if(firststatus.contentEquals("ongoing"))
					{
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							System.out.println("here in this in 14 func1");
							//send notification of 1 hr class
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							System.out.println("here in this in 15 func1");
							//send notification for cancelling ongoing class
						}
					}
					else
					{
						
						System.out.println("in this unexpected 16 else");
					}
				}
			}
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
	public void secondslotscheduling(String firstslotid,String secondslotid)
	{
		System.out.println("slotid is:"+firstslotid);
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).buildSessionFactory();
		Session session=factory.openSession();
		String firststatus;
		String firstprofid;
		String secondstatus;
		String secondprofid;
		String firstsubjectid;
		String secondsubjectid;
		int firstacceptvotes = 0,firstdeclinevotes=0,secondacceptvotes=0,seconddeclinevotes=0;
		try {
			Transaction tx= session.beginTransaction();
			System.out.println("hey success");
			Slot firstslot=(Slot) session.get(Slot.class,firstslotid);	
			Slot secondslot=(Slot) session.get(Slot.class, secondslotid);
			System.out.println("profid:"+firstslot.getProfid()+" status:"+firstslot.getStatus()+" ");
			System.out.println("profid:"+secondslot.getProfid()+" status:"+secondslot.getStatus()+" ");
			firststatus=firstslot.getStatus();
			firstprofid=firstslot.getProfid();
			firstsubjectid=firstslot.getSubjectid();
			secondprofid=secondslot.getProfid();
			secondstatus=secondslot.getStatus();
			secondsubjectid=secondslot.getSubjectid();
			if(firstprofid!=null && firststatus.contentEquals("ongoing"))
			{
				System.out.println("status is ongoing of firstid in func2");
				String tablename="slot"+firstslotid;
				SQLQuery getvotequery=session.createSQLQuery("select * from "+tablename+" where vote='yes'");
				List accepters=getvotequery.list();
				firstacceptvotes=accepters.size();
				SQLQuery getvotequery2=session.createSQLQuery("select * from "+tablename+" where vote='no'");
				List decliners=getvotequery2.list();
				firstdeclinevotes=decliners.size();
			}
			if(secondprofid!=null && secondstatus.contentEquals("ongoing"))
			{
				System.out.println("status is ongoing of secondid in func2");
				String tablename="slot"+secondslotid;
				SQLQuery getvotequery=session.createSQLQuery("select * from "+tablename+" where vote='yes'");
				List accepters=getvotequery.list();
				secondacceptvotes=accepters.size();
				SQLQuery getvotequery2=session.createSQLQuery("select * from "+tablename+" where vote='no'");
				List decliners=getvotequery2.list();
				seconddeclinevotes=decliners.size();
			}
			if(secondstatus==null)
			{
				System.out.println("here in this in 1 func1");
				//do nothin
			}
			else if(secondstatus!=null && firststatus==null)
			{
				if(secondstatus.contentEquals("filled"))
				{
					System.out.println("here in this in 2 func1");
					//send notification of 1 hr
				}
				else if(secondstatus.contentEquals("ongoing"))
				{
					if(secondacceptvotes>seconddeclinevotes)
					{
						SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
						addquery.executeUpdate();
						System.out.println("here in this in 3 func1");
						//send notification for 1 hr
					}
					else
					{
						SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+secondslotid+"'");
						deletequery.executeUpdate();
						System.out.println("here in this in 4 func1");
						//send notification for cancellation
					}
				}
				else
				{
					System.out.println(" unexpected in 5 func2");
				}
			}
			else if(secondstatus!=null && firststatus!=null)
			{
				if(firstprofid.contentEquals(secondprofid) && firstsubjectid.contentEquals(secondsubjectid))
				{
					if(secondstatus.contentEquals("filled") && firststatus.contentEquals("filled"))
					{
						System.out.println("here in this in 6 func1");
						//no notification to be send notification has been sent in previous class
					}
					else if(secondstatus.contentEquals("ongoing") && firststatus.contentEquals("filled"))
					{
						if(secondacceptvotes>seconddeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
							addquery.executeUpdate();
							System.out.println("here in this in 7 func1");
							//send notification for 1 hr
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+secondslotid+"'");
							deletequery.executeUpdate();
							System.out.println("here in this in 8 func1");
							//send notification for cancellation
						}
					}
					else
					{
						//make right to work with previous ongoing
						System.out.println("no such case exists firststatus:"+firststatus+" seconstatus:"+secondstatus);
					}
				}
				else
				{
					if(secondstatus.contentEquals("filled"))
					{
						System.out.println("here in this in 9 func1");
						//send notification of 1 hr
					}
					else if(secondstatus.contentEquals("ongoing"))
					{
						if(secondacceptvotes>seconddeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
							addquery.executeUpdate();
							System.out.println("here in this in 10 func1");
							//send notification for 1 hr
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+secondslotid+"'");
							deletequery.executeUpdate();
							System.out.println("here in this in 11 func1");
							//send notification for cancellation
						}
					}
					else
					{
						
						System.out.println(" unexpected in 12 func2");
					}
				}
			}
			tx.commit();
			session.close();
		}
		catch(Exception e)
		{
			
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
	
	public void fifthslotscheduling(String firstslotid,String secondslotid,String thirdslotid)
	{
		System.out.println("slotid is:"+firstslotid);
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).buildSessionFactory();
		Session session=factory.openSession();
		String firststatus;
		String firstprofid;
		String firstsubjectid;
		String secondstatus;
		String secondprofid;
		String secondsubjectid;
		String thirdstatus;
		String thirdprofid;
		String thirdsubjectid;
		int firstacceptvotes = 0,firstdeclinevotes=0,secondacceptvotes=0,seconddeclinevotes=0,thirdacceptvotes=0,thirddeclinevotes=0;
		try {
			Transaction tx= session.beginTransaction();
			System.out.println("hey success");
			Slot firstslot=(Slot) session.get(Slot.class,firstslotid);	
			Slot secondslot=(Slot) session.get(Slot.class, secondslotid);
			Slot thirdslot=(Slot) session.get(Slot.class, thirdslotid);
			System.out.println("profid:"+firstslot.getProfid()+" status:"+firstslot.getStatus()+" ");
			System.out.println("profid:"+secondslot.getProfid()+" status:"+secondslot.getStatus()+" ");
			System.out.println("profid:"+thirdslot.getProfid()+" status:"+thirdslot.getStatus()+" ");
			firststatus=firstslot.getStatus();
			firstprofid=firstslot.getProfid();
			firstsubjectid=firstslot.getSubjectid();
			secondprofid=secondslot.getProfid();
			secondstatus=secondslot.getStatus();
			secondsubjectid=secondslot.getSubjectid();
			thirdstatus=thirdslot.getStatus();
			thirdprofid=thirdslot.getProfid();
			thirdsubjectid=thirdslot.getSubjectid();
			
			if(firstprofid!=null && firststatus.contentEquals("ongoing"))
			{
				System.out.println("status is ongoing");
				String tablename="slot"+firstslotid;
				SQLQuery getvotequery=session.createSQLQuery("select * from "+tablename+" where vote='yes'");
				List accepters=getvotequery.list();
				firstacceptvotes=accepters.size();
				SQLQuery getvotequery2=session.createSQLQuery("select * from "+tablename+" where vote='no'");
				List decliners=getvotequery2.list();
				firstdeclinevotes=decliners.size();
				System.out.println("accept:"+firstacceptvotes+"decline"+firstdeclinevotes);
			}
			if(secondprofid!=null && secondstatus.contentEquals("ongoing"))
			{
				System.out.println("status is ongoing");
				String tablename="slot"+secondslotid;
				SQLQuery getvotequery=session.createSQLQuery("select * from "+tablename+" where vote='yes'");
				List accepters=getvotequery.list();
				secondacceptvotes=accepters.size();
				SQLQuery getvotequery2=session.createSQLQuery("select * from "+tablename+" where vote='no'");
				List decliners=getvotequery2.list();
				seconddeclinevotes=decliners.size();
				System.out.println("saccept:"+secondacceptvotes+"sdecline"+seconddeclinevotes);
			}
			if(thirdprofid!=null && thirdstatus.contentEquals("ongoing"))
			{
				System.out.println("status is ongoing");
				String tablename="slot"+thirdslotid;
				SQLQuery getvotequery=session.createSQLQuery("select * from "+tablename+" where vote='yes'");
				List accepters=getvotequery.list();
				thirdacceptvotes=accepters.size();
				SQLQuery getvotequery2=session.createSQLQuery("select * from "+tablename+" where vote='no'");
				List decliners=getvotequery2.list();
				thirddeclinevotes=decliners.size();
				System.out.println("accept:"+firstacceptvotes+"decline"+firstdeclinevotes);
			}
			//main if else logic
			if(firststatus==null)
			{
				//do nothing
			}
			else if(firststatus!=null && secondstatus==null && thirdstatus==null)
			{
				if(firststatus.contentEquals("filled"))
				{
					System.out.println("here in this in 1 func3");
					// send notification of 1 hr
				}
				else if(firststatus.contentEquals("ongoing"))
				{
					String tablename="slot"+firstslotid;
					if(firstacceptvotes>firstdeclinevotes)
					{
						SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
						addquery.executeUpdate();
						SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
						deltablequery.executeUpdate();
						System.out.println("here in this in 2 func1");
						//send notification of 1 hr class
					}
					else
					{
						SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
						deletequery.executeUpdate();
						SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
						deltablequery.executeUpdate();
						System.out.println("here in this in 3 func1");
						//send notification for cancelling ongoing class
					}
				}
				else
				{
					System.out.println("unexpected else 4 in func3");
				}
			}
			else if(firststatus!=null && secondstatus!=null && thirdstatus==null)
			{
				if(firstprofid.contentEquals(secondprofid) && firstsubjectid.contentEquals(secondsubjectid))
				{
					if(firststatus.contentEquals("filled") && secondstatus.contentEquals("filled"))
					{
						//second notification for 2 hrs
					}
					else if(firststatus.contentEquals("filled") && secondstatus.contentEquals("ongoing"))
					{
						if(secondacceptvotes>seconddeclinevotes)
						{
							String tablename="slot"+secondslotid;
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
							addquery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 6 func1");
							//send notification for 2 hr
						}
						else
						{
							System.out.println("here in this in 7 func1");
							//send notification for 1 hr class
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("filled"))
					{
						String tablename="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 8 func1");
							//send notification of 2 hr class
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 9 func1");
							//send notification for cancelling ongoing class
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("ongoing"))
					{
						String tablename1="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename1);
							deltablequery.executeUpdate();
							if(secondacceptvotes>seconddeclinevotes)
							{
								String tablename2="slot"+secondslotid;
								SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
								addquery2.executeUpdate();
								SQLQuery deltablequery2=session.createSQLQuery("drop table "+tablename2);
								deltablequery2.executeUpdate();
								System.out.println("here in this in 10 func1");
								// notification for 2 hr
							}
							else
							{
								System.out.println("here in this in 11 func1");
								//notification for 1 hr
							}
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename1);
							deltablequery.executeUpdate();
							System.out.println("here in this in 12 func1");
							//send notification for cancelling ongoing class
						}
					}
					else
					{
						//unexpected
					}
				}
				else
				{
					if(firststatus.contentEquals("filled"))
					{
						System.out.println("here in this in 1 func3");
						// send notification of 1 hr
					}
					else if(firststatus.contentEquals("ongoing"))
					{
						String tablename="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 2 func1");
							//send notification of 1 hr class
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 3 func1");
							//send notification for cancelling ongoing class
						}
					}
					else
					{
						System.out.println("unexpected else 4 in func3");
					}
				}
			}
			else if(firststatus!=null && secondstatus!=null && thirdstatus!=null)
			{
				if(firstprofid.contentEquals(secondprofid) && firstsubjectid.contentEquals(secondsubjectid) && thirdprofid.contentEquals(secondprofid) && thirdsubjectid.contentEquals(secondsubjectid))
				{
					if(firststatus.contentEquals("filled") && secondstatus.contentEquals("filled") && thirdstatus.contentEquals("filled"))
					{
						//send notificatio for 3 hr
					}
					else if(firststatus.contentEquals("filled") && secondstatus.contentEquals("filled") && thirdstatus.contentEquals("ongoing"))
					{
						if(thirdacceptvotes>thirddeclinevotes)
						{
							String tablename3="slot"+thirdslotid;
							SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+thirdslotid+"'");
							addquery2.executeUpdate();
							SQLQuery deltablequery2=session.createSQLQuery("drop table "+tablename3);
							deltablequery2.executeUpdate();
							System.out.println("here in this in 10 func1");
							// notification for 3 hr
						}
						else
						{
							System.out.println("here in this in 11 func1");
							//notification for 2 hr
						}
					}
					else if(firststatus.contentEquals("filled") && secondstatus.contentEquals("ongoing") && thirdstatus.contentEquals("filled"))
					{
						if(secondacceptvotes>seconddeclinevotes)
						{
							String tablename2="slot"+secondslotid;
							SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
							addquery2.executeUpdate();
							SQLQuery deltablequery2=session.createSQLQuery("drop table "+tablename2);
							deltablequery2.executeUpdate();
							System.out.println("here in this in 10 func1");
							// notification for 3 hr
						}
						else
						{
							System.out.println("here in this in 11 func1");
							//notification for 1 hr
						}
					}
					else if(firststatus.contentEquals("filled") && secondstatus.contentEquals("ongoing") && thirdstatus.contentEquals("ongoing"))
					{
						if(secondacceptvotes>seconddeclinevotes)
						{
							String tablename2="slot"+secondslotid;
							SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
							addquery2.executeUpdate();
							SQLQuery deltablequery2=session.createSQLQuery("drop table "+tablename2);
							deltablequery2.executeUpdate();
							if(thirdacceptvotes>thirddeclinevotes)
							{
								String tablename3="slot"+thirdslotid;
								SQLQuery addquery3=session.createSQLQuery("update slot set status='filled' where slotid='"+thirdslotid+"'");
								addquery3.executeUpdate();
								SQLQuery deltablequery3=session.createSQLQuery("drop table "+tablename3);
								deltablequery3.executeUpdate();
								//send notification for 3 hr 
							}
							else
							{
								//send notification for 2 hr f s
							}
						}
						else
						{
							//notfification for 1 hr
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("filled") && thirdstatus.contentEquals("filled"))
					{
						String tablename1="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery1=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery1.executeUpdate();
							SQLQuery deltablequery1=session.createSQLQuery("drop table "+tablename1);
							deltablequery1.executeUpdate();
							//notification for 3 hr class
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename1);
							deltablequery.executeUpdate();
							//notifiaction for cancelling class
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("filled") && thirdstatus.contentEquals("ongoing"))
					{
						String tablename1="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery1=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery1.executeUpdate();
							SQLQuery deltablequery1=session.createSQLQuery("drop table "+tablename1);
							deltablequery1.executeUpdate();
							if(thirdacceptvotes>thirddeclinevotes)
							{
								String tablename3="slot"+thirdslotid;
								SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+thirdslotid+"'");
								addquery2.executeUpdate();
								SQLQuery deltablequery2=session.createSQLQuery("drop table "+tablename3);
								deltablequery2.executeUpdate();
								//send notification for 3 hr
							}
							else
							{
								//send notify for 2 hr f s
							}
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename1);
							deltablequery.executeUpdate();
							//notifiaction for cancelling class
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("ongoing") && thirdstatus.contentEquals("filled"))
					{
						String tablename1="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery1=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery1.executeUpdate();
							SQLQuery deltablequery1=session.createSQLQuery("drop table "+tablename1);
							deltablequery1.executeUpdate();
							if(secondacceptvotes>seconddeclinevotes)
							{
								String tablename2="slot"+secondslotid;
								SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
								addquery2.executeUpdate();
								SQLQuery deltablequery2=session.createSQLQuery("drop table "+tablename2);
								deltablequery2.executeUpdate();
								//send notify for 3 hr
							}
							else
							{
								// send notify for 1 hr
							}
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename1);
							deltablequery.executeUpdate();
							//notifiaction for cancelling class
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("ongoing") && thirdstatus.contentEquals("ongoing"))
					{
						String tablename1="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery1=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery1.executeUpdate();
							SQLQuery deltablequery1=session.createSQLQuery("drop table "+tablename1);
							deltablequery1.executeUpdate();
							if(secondacceptvotes>seconddeclinevotes)
							{
								String tablename2="slot"+secondslotid;
								SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
								addquery2.executeUpdate();
								SQLQuery deltablequery2=session.createSQLQuery("drop table "+tablename2);
								deltablequery2.executeUpdate();
								if(thirdacceptvotes>thirddeclinevotes)
								{
									String tablename3="slot"+thirdslotid;
									SQLQuery addquery3=session.createSQLQuery("update slot set status='filled' where slotid='"+thirdslotid+"'");
									addquery3.executeUpdate();
									SQLQuery deltablequery3=session.createSQLQuery("drop table "+tablename3);
									deltablequery3.executeUpdate();
								}
								else
								{
									//notify for 2 hr
								}
							}
							else
							{
								//notify for 1 hr
							}
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename1);
							deltablequery.executeUpdate();
							//notifiaction for cancelling class
						}
					}
					else
					{
						//unexpected
					}
				}
				else if(firstprofid.contentEquals(secondprofid) && firstsubjectid.contentEquals(secondsubjectid) && ( !thirdprofid.contentEquals(secondprofid) || !thirdsubjectid.contentEquals(secondsubjectid)))
				{
					if(firststatus.contentEquals("filled") && secondstatus.contentEquals("filled"))
					{
						//second notification for 2 hrs
					}
					else if(firststatus.contentEquals("filled") && secondstatus.contentEquals("ongoing"))
					{
						if(secondacceptvotes>seconddeclinevotes)
						{
							String tablename="slot"+secondslotid;
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
							addquery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 6 func1");
							//send notification for 2 hr
						}
						else
						{
							System.out.println("here in this in 7 func1");
							//send notification for 1 hr class
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("filled"))
					{
						String tablename="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 8 func1");
							//send notification of 2 hr class
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 9 func1");
							//send notification for cancelling ongoing class
						}
					}
					else if(firststatus.contentEquals("ongoing") && secondstatus.contentEquals("ongoing"))
					{
						String tablename1="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename1);
							deltablequery.executeUpdate();
							if(secondacceptvotes>seconddeclinevotes)
							{
								String tablename2="slot"+secondslotid;
								SQLQuery addquery2=session.createSQLQuery("update slot set status='filled' where slotid='"+secondslotid+"'");
								addquery2.executeUpdate();
								SQLQuery deltablequery2=session.createSQLQuery("drop table "+tablename2);
								deltablequery.executeUpdate();
								System.out.println("here in this in 10 func1");
								// notification for 2 hr
							}
							else
							{
								System.out.println("here in this in 11 func1");
								//notification for 1 hr
							}
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename1);
							deltablequery.executeUpdate();
							System.out.println("here in this in 12 func1");
							//send notification for cancelling ongoing class
						}
					}
					else
					{
						//unexpected
					}
				}
				else
				{
					if(firststatus.contentEquals("filled"))
					{
						System.out.println("here in this in 1 func3");
						// send notification of 1 hr
					}
					else if(firststatus.contentEquals("ongoing"))
					{
						String tablename="slot"+firstslotid;
						if(firstacceptvotes>firstdeclinevotes)
						{
							SQLQuery addquery=session.createSQLQuery("update slot set status='filled' where slotid='"+firstslotid+"'");
							addquery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 2 func1");
							//send notification of 1 hr class
						}
						else
						{
							SQLQuery deletequery=session.createSQLQuery("update slot set profid=NULL,status=NULL,subjectid=NULL where slotid='"+firstslotid+"'");
							deletequery.executeUpdate();
							SQLQuery deltablequery=session.createSQLQuery("drop table "+tablename);
							deltablequery.executeUpdate();
							System.out.println("here in this in 3 func1");
							//send notification for cancelling ongoing class
						}
					}
					else
					{
						System.out.println("unexpected else 4 in func3");
					}
				}
			}
			else
			{
				//unexpected
			}
		}
		catch(Exception e)
		{
			
		}
		finally
		{
			factory.close();
			System.out.println("All done");
		}
	}
}
