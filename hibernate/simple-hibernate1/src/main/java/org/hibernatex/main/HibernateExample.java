package org.hibernatex.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernatex.model.Laptop;
import org.hibernatex.model.Student;
import org.hibernatex.util.HibernateUtil;

public class HibernateExample {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			// laptop makin
			Laptop laptop = new Laptop();
			laptop.setLid(10);
			laptop.setLname("veino");
			Laptop laptop1 = new Laptop();
			laptop1.setLid(11);
			laptop1.setLname("hp");
			// laptop end
			// studetn makin
			Student student = new Student();
			student.setRollno(1);
			student.setMarks(90);
			student.setName("raj");
			List<Laptop> listLap = new ArrayList<Laptop>();
			listLap.add(laptop);
			listLap.add(laptop1);
			student.setLaptops(listLap);
			// student2
			Student student1 = new Student();
			student1.setRollno(2);
			student1.setMarks(95);
			student1.setName("rita");
			List<Laptop> listLap1 = new ArrayList<Laptop>();
			listLap1.add(laptop);
			student1.setLaptops(listLap1);
			List<Student> students = new ArrayList<Student>();
			students.add(student);
			students.add(student1);
			laptop.setStudents(students);
			List<Student> students1 = new ArrayList<Student>();
			students1.add(student1);
			laptop1.setStudents(students1);
			session.save(laptop1);
			session.save(laptop);
			session.save(student);
			session.save(student1);
			// student end
			// laptop again
			session.getTransaction().commit();
		} catch (Exception e) {
			if (session != null)
				session.getTransaction().rollback();
			System.out.println(e);
		} finally {
			if (sessionFactory != null)
				sessionFactory.close();
		}
	}

}
