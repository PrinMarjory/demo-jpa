package fr.diginamic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
		System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||\n");
		System.out.println("Livre d'ID 3:");
		System.out.println(livre);
		System.out.println("\n-------------------------------------------\n");
		
		Client client = em.find(Client.class, 2);
		System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||\n");
		System.out.println("Client d'ID 2:");
		System.out.println(client);
		System.out.println("\n-------------------------------------------\n");
		
		Emprunt emprunt = em.find(Emprunt.class, 4);
		System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||\n");
		System.out.println("Emprunt d'ID 4:");
		System.out.println(emprunt);
		System.out.println("\n-------------------------------------------\n");
		
		TypedQuery<Livre> query1 = em.createQuery("SELECT l FROM Livre l JOIN l.emprunts e WHERE e.id=:param1", Livre.class);
		query1.setParameter("param1", 2);
		List<Livre> listeLivres = query1.getResultList();
		
		System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||\n");
		System.out.println("Livres empruntés lors de l'emprunt n°2:");
		for (Livre l : listeLivres) {
			System.out.println(l);
		}
		System.out.println("\n-------------------------------------------\n");
		
		TypedQuery<Emprunt> query2 = em.createQuery("SELECT e FROM Emprunt e JOIN e.client c WHERE c.id=:param2", Emprunt.class);
		query2.setParameter("param2", 1);
		List<Emprunt> listeEmprunts = query2.getResultList();
		
		System.out.println("\n|||||||||||||||||||||||||||||||||||||||||||\n");
		System.out.println("Les emprunts de Pierre Brigand (ID n°1) :");
		for (Emprunt e : listeEmprunts) {
			System.out.println(e);
		}
		System.out.println("\n-------------------------------------------\n");
		
		transaction.commit();
	}
	
}
