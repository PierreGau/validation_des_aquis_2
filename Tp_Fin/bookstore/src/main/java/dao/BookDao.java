package dao;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.transform.Transformers;

import entity.Book;
import util.HibernateUtil;

@ManagedBean(name ="bookDao")
@RequestScoped
public class BookDao 
{
	private List<Integer> prix = new ArrayList<>();
	private Book selected;

	public BookDao() {
	}


	public BookDao(List<Integer> prix) {
		this.prix = prix;
	}


	public Book getSelected() {
		return selected;
	}


	public void setSelected(Book selected) {
		this.selected = selected;
	}


	public void setPrix(List<Integer> prix) {
		this.prix = prix;
	}


	public  List<Integer> getPrix()
	{
		prix.clear();
		for(int i = 1; i < 51; i++)
		{
			prix.add(i);
			
		}
		return prix;
	}

	
	public void setPrix(ArrayList<Integer> prix) {
		this.prix = prix;
	}
	
	public static List<Book> getAll()
	{
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			//String hql = "from etudiant";
			//Query query = session.createQuery(hql);
			//List<Etudiant> listCategories = query.list();
			
			Query<Book> query = session.createSQLQuery("SELECT * FROM book");
			query.setResultTransformer(Transformers.aliasToBean(Book.class));
			List<Book> temp = query.list();
			
			t.commit();
			session.close();
			return temp;
		} catch (Exception e) {
			System.out.println("Erreur lors de la récupération de la liste : " + e.getMessage());
			t.rollback();
			session.close();
			return null;
		}
	}

	public static void persist(Book p) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			session.persist(p);
			t.commit();
		} catch (Exception e) {
			System.out.println("Erreur lors de l'insertion de livres : " + e.getMessage());
			t.rollback();
		}
		session.close();
	}
	
	

	public static void update(Book p) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			session.update(p);
			t.commit();
		} catch (Exception e) {
			System.out.println("Erreur lors de l'update livre : " + e.getMessage());
			t.rollback();
		}
		session.close();
	}
	
	public void saveOrUpdate(Book p)
	{
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			session.saveOrUpdate(p);
			t.commit();
		} catch (Exception e) {
			t.rollback();			
			System.out.println("Erreur lors du saveOrUpdate livres : " + e.getMessage());
		}
		session.close();
	}
	
	public static Book get(int id) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();
		try {
			Book p = session.get(Book.class, id);
			t.commit();
			session.close();
			return p;
		} catch (Exception e) {
			t.rollback();
			System.err.println("Erreur lors de la récupération de livre dans la DATABASE à l'id " + id + " : " + e.getMessage());
			session.close();
			return null;
		}
	}
	
	public static void delete(Book p) {
		Session session = HibernateUtil.getSessionfactory().openSession();
		Transaction t = session.beginTransaction();

		try {
			Book temp = session.get(Book.class, p.getId());
			session.delete(temp);
			//ids.remove(p.getId());
			t.commit();	
		} catch (Exception e) {
			t.rollback();
			System.out.println("Erreur lors de la suppression de livres" + p.getId() + " : " + e.getMessage());
		}
		session.close();
	}


	@Override
	public String toString() {
		return String.format("BookDao [prix=%s, selected=%s]", prix, selected);
	}


	
}
