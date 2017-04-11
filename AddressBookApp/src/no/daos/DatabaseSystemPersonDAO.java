package no.daos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import no.entities.Person;

public class DatabaseSystemPersonDAO implements PersonDAO {

	private Configuration con;
	private SessionFactory sf;
	private Session session;
	private Transaction tx;
	
	
	@Override
	public List<Person> loadPerson() throws IOException {
		List<Person> list = new ArrayList<Person>();
		con = new Configuration().configure().addAnnotatedClass(Person.class);
		sf = con.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		list = session.createCriteria(Person.class).list();
		tx.commit();
		return list;
	}

	@Override
	public void savePerson(Person person) throws IOException {
		con = new Configuration().configure().addAnnotatedClass(Person.class);
		sf = con.buildSessionFactory();
		session = sf.openSession();
		tx = session.beginTransaction();
		session.save(person);
		tx.commit();
	}

	@Override
	public void deletePerson(Person person) throws IOException {
		// TODO Auto-generated method stub
		
	}
	
}
