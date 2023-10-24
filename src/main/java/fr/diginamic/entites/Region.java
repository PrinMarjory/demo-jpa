package fr.diginamic.entites;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Représente une région avec son id et son nom
 * 
 * @author Marjory PRIN
 */
@Entity
@Table(name="region")
public class Region {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/** L'id de la région **/
	private int id;
	
	@Column(name = "nom", length = 20, nullable = false)
	/** Le nom de la région **/
	private String nom;

	/**
	 * Constructeur pour JPA
	 */
	public Region() {
	}
	
	/**
	 * Constructeur 
	 * @param id : id de la région
	 * @param nom : nom de la région
	 */
	public Region(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	

	@Override
	public String toString() {
		return "Region [id=" + id + ", nom=" + nom + "]";
	}

	/** Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/** Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/** Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
