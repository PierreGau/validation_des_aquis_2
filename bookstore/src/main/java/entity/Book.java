package entity;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "etudiant")
@Table(name = "etudiant")
@ManagedBean(name="etudiant")
@ApplicationScoped
public class Book 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name="title")
	String title;
	
	@Column(name="autor")
	String autor;
	
	@Column(name="releaseDate")
	String releaseDate;
}
