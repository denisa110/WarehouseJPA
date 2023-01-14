package BagDetails.entities.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import BagDetails.entities.Bag;
import BagDetails.entities.Size;

public class TestBags {

	public static void main(String[] args) {

		EntityManagerFactory emf =Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
			em.createQuery("DELETE FROM Bag b").executeUpdate();
		em.getTransaction().commit();

		Bag b1 = new Bag(0, Size.big, "white", 23.0);
		Bag b2 = new Bag(1, Size.big, "green", 10.25);
		Bag b3 = new Bag(2, Size.big, "black", 15.0);
		Bag b4 = new Bag(3, Size.big, "yellow", 18.5);
		Bag b5 = new Bag(5, Size.big, "blue", 17.0);

		//Se colecteaza lista de persoane intr-un stream de obiecte:
		List<Bag> lstBags = Stream.of(b1, b2, b3, b4, b5).collect(Collectors.toList());
		
		// Inainte de persistenta
		System.out.println("Inainte de persistenta");
		printEntitateCerinta(lstBags);
		
		// Asociere context persistenta
		lstBags.forEach(p -> em.persist(p));
		System.out.println("Dupa asociere context persistenta");
		printEntitateCerinta(lstBags);
		
		// Sincronizare SQL: executie fraze DML-SQL
		em.getTransaction().begin();
		//save:
		em.flush();
		System.out.println("Dupa Sincronizare SQL: executie fraze DML-SQL");
		printEntitateCerinta(lstBags);
		
		// Efectuare tranzactie
		em.getTransaction().commit();
		System.out.println("Dupa efectuare tranzactie");
		System.out.println("Interogare cerinte: ");
		System.out.println("Interogare cerinte functionale: ");
		
		//Citire dupa creare
		List<Bag> bags = em.createQuery("SELECT b FROM Bag b").getResultList();
		printEntitateCerinta(bags);
	
		System.out.println("End");
	}
	static void printEntitateCerinta(List<Bag> bags) {
		System.out.println("-------------------------------");
		bags.stream().forEach(
				b -> System.out.println(b.getClass().getSimpleName() + ": " + b));
		System.out.println("-------------------------------");
	}
		
	}


