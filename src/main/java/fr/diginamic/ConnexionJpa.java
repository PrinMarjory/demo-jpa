package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entites.Region;

public class ConnexionJpa {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("recensement_jpa");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		
		transaction.begin();
		
		Region r = em.find(Region.class, 1);
		System.out.println(r);
		r = new Region();
		r.setNom("Normandie");
		em.persist(r);
		
		transaction.commit();
		
		

	}

}
