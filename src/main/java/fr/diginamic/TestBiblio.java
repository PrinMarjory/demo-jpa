package fr.diginamic;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import fr.diginamic.entites.Client;
import fr.diginamic.entites.Emprunt;
import fr.diginamic.entites.Livre;

public class TestBiblio {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("biblio");
		EntityManager em = emf.createEntityManager();
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		
		Livre livre = em.find(Livre.class, 3);
		System.out.println(livre);
		
		Client client = em.find(Client.class, 2);
		System.out.println(client);
		
		Emprunt emprunt = em.find(Emprunt.class, 4);
		System.out.println(emprunt);
		
		transaction.commit();
	}
	
}
