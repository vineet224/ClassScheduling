package api.rest;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.entity.Slot;

@RestController
@RequestMapping("/Vote")
public class VoteRestController {

	@RequestMapping(path ="/Post/{studentid}/{slotid}/{decission}")
	public String givevote(@PathVariable String studentid, @PathVariable String slotid,@PathVariable String decission)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Slot.class).buildSessionFactory();
		Session session=factory.openSession();
		try {
			session.beginTransaction();
			String tablename="slot"+slotid;
			System.out.println("yea here to vote");
			SQLQuery checkvoterquery=session.createSQLQuery("select * from "+tablename+" where studentid='"+studentid+"'");
			List<Object[]> voterlist=checkvoterquery.list();
			if(voterlist.size()>0)
			{
				session.getTransaction().commit();
				session.close();
				return "alread voted";
			}
			else {
				SQLQuery voteinsertquery=session.createSQLQuery("insert into "+tablename+" values('"+studentid+"','"+decission+"')");
				voteinsertquery.executeUpdate();
				session.getTransaction().commit();
				session.close();
				return "success";
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
		return "yeah";
		
	}
}
