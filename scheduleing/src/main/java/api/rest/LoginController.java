package api.rest;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.entity.Professor;
import api.entity.Student;

@RestController
@RequestMapping("/Login")
public class LoginController {

	@GetMapping(path = "/Student/{id}/{password}")
	public String loginstudent(@PathVariable String id, @PathVariable String password)
	{
		String invalid_str="isinvalid";
		System.out.println("here is "+id+" "+password);
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query logincheckquery=session.createQuery("from Student where studentid='"+id+"'");
			List<Student> studentlist=logincheckquery.list();
			if(studentlist.size()==0)
			{
				session.getTransaction().commit();
				return invalid_str;
			}
			else
			{
				Student user;
				String userpassword;
				user=studentlist.get(0);
				userpassword=user.getPassword();
				if(userpassword.contentEquals(password))
				{
					session.getTransaction().commit();
					return "valid";
				}
				session.getTransaction().commit();
				return invalid_str;
			}
			
		}
		catch(Exception e) {
			return invalid_str;
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
	
	@GetMapping(path = "/Professor/{id}/{password}")
	public String loginprofessor(@PathVariable String id, @PathVariable String password)
	{
		String invalid_str="isinvalid";
		id.trim();
		password.trim();
		System.out.println("here is "+id+" "+password);
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Professor.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			Query logincheckquery=session.createQuery("from Professor where profid='"+id+"'");
			List<Professor> proflist=logincheckquery.list();
			if(proflist.size()==0)
			{
				System.out.println("no record");
				session.getTransaction().commit();
				return invalid_str;
			}
			else
			{
				Professor user;
				String userpassword;
				String subjectid;
				user=proflist.get(0);
				
				userpassword=user.getPassword();
				System.out.println(password+"  "+userpassword);
				if(userpassword.contentEquals(password))
				{
					session.getTransaction().commit();
					return "valid";
				}
				session.getTransaction().commit();
				return invalid_str;
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return invalid_str;
		}
		finally {
			factory.close();
			System.out.println("All done");
		}

	}

	
}
