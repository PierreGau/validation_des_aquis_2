package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import entity.BookMark;
import util.HibernateUtil;

public class BookMarkDao 
{
	public static void persist(BookMark p)
	{
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			session.persist(p);
			t.commit();
		} catch (Exception e) {
			System.out.println("Erreur lors de l'insertion de d'etudiant : " + e.getMessage());
			t.rollback();
		}
		session.close();
	}
	
	

	public static void update(BookMark p) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(p);
			t.commit();
		} catch (Exception e) {
			System.out.println("Erreur lors de l'update de Personne : " + e.getMessage());
			t.rollback();
		}
		session.close();
	}
	
	public void saveOrUpdate(BookMark p)
	{
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			session.saveOrUpdate(p);
			t.commit();
		} catch (Exception e) {
			t.rollback();			
			System.out.println("Erreur lors du saveOrUpdate de Personne : " + e.getMessage());
		}
		session.close();
	}
	
	public static BookMark get(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			BookMark p = session.get(BookMark.class, id);
			t.commit();
			session.close();
			return p;
		} catch (Exception e) {
			t.rollback();
			System.err.println("Erreur lors de la récupération de personne dans la DATABASE à l'id " + id + " : " + e.getMessage());
			session.close();
			return null;
		}
	}
	
	public static void delete(BookMark p) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			BookMark temp = session.get(BookMark.class, p.getId());
			session.delete(temp);
			//ids.remove(p.getId());
			t.commit();	
		} catch (Exception e) {
			t.rollback();
			System.out.println("Erreur lors de la suppression de personne" + p.getId() + " : " + e.getMessage());
		}
		session.close();
	}
}
