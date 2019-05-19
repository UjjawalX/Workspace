package org.hibernatex.main;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernatex.model.Employee;
import org.hibernatex.util.HibernateUtil;

public class HQLSample {
	public static void main(String args[]) {
		Transaction tx = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.getCurrentSession();
			tx = session.beginTransaction();
//		session.flush();
			Query query;
			query = session.createQuery("update Employee set name= :name where id = :id");
			query.setParameter("name", "Pankaj udas");
			query.setLong("id", 1);
			int result = query.executeUpdate();
			System.out.println("Employee update status : " + result);
			// Get All Employees
			query = session.createQuery("from Employee");
			List<Employee> empList = query.list();
			for (Employee emp : empList) {
				System.out.println("Employee " + emp.getId() + "," + emp.getAddress().getCity());

			}
			// Get Employee with id
			query = session.createQuery("from Employee where id= :id");
			query.setLong("id", 3);
			Employee emp = (Employee) query.uniqueResult();
			System.out.println("emp name " + emp.getName() + ", city=" + emp.getAddress().getCity());
			// update employee

			// Delete employee
			query = session.createQuery("delete from Address where id = :id");
			query.setLong("id", 4);
			result = query.executeUpdate();
			// Delete address
			System.out.println("Address delete status " + result);
			query = session.createQuery("delete from Employee where id = :id");
			query.setLong("id", 4);
			result = query.executeUpdate();
			System.out.println("Employee delete status " + result);
			// Aggregate function example
			query = session.createQuery("select sum(salary) from Employee");
			Double sumSalary = (Double) query.uniqueResult();
			System.out.println("Sum of All Salaries=" + sumSalary);
			// join example
			query = session.createQuery("select e.name , a.city from Employee e INNER JOIN e.address a");
			List<Object[]> list = query.list();
			for (Object[] l : list) {
				System.out.println(Arrays.toString(l));

			}
		} catch (Exception e) {

		} finally {
			if (tx != null)
				tx.rollback();
			if (sessionFactory != null)
				sessionFactory.close();
		}

	}
}
