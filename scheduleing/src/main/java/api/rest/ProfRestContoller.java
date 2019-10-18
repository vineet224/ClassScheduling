package api.rest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.entity.Professor;
import api.entity.Student;

@RestController
@RequestMapping("/Professor")
public class ProfRestContoller {

	@RequestMapping("/addprof")
	public Professor addprof(Professor prof)
	{
		SessionFactory factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Professor.class).buildSessionFactory();
		Session session=factory.getCurrentSession();
		try {
			session.beginTransaction();
			System.out.println("I am saving");
			session.save(prof);
			session.getTransaction().commit();
			return prof;
			
			
		}
		finally {
			factory.close();
			System.out.println("All done");
		}
	}
}
