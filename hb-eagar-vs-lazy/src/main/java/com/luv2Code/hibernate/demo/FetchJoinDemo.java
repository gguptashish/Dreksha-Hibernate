package com.luv2Code.hibernate.demo;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.luv2Code.hibernate.demo.entity.Course;
import com.luv2Code.hibernate.demo.entity.Instructor;

public class FetchJoinDemo {
	public static void main(String[] args) {
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory sessionFactory = meta.getSessionFactoryBuilder().build();

		
		//FETCH LAZY DATA BY HQL
		// create session
		Session session = sessionFactory.openSession();

		try {
			// Start the transcation
			session.beginTransaction();

			// bring Instructor from Instructor Table
			int id = 1;
			
			//System.out.println("Love 2 Code :  Instructor :" + instructor);

			
			// commit transaction
			session.getTransaction().commit();
			session.close(); 
			
			//below code work Courses are already loaded in memory 
			
			System.out.println("Session is closed");
			// get cources from Instructor

			System.out.println("Love 2 Code : Course :" + instructor.getCourseList());

			for (Course course : instructor.getCourseList()) {
				System.out.println("----" + course.getTitle());
			}

			System.out.println("Done");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}
}