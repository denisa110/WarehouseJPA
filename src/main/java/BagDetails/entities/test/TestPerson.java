package BagDetails.entities.test;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.*;

import BagDetails.entities.Person;

public class TestPerson {

	public static void main(String[] args) {

		EntityManagerFactory emf =Persistence.createEntityManagerFactory("default");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
			em.createQuery("DELETE FROM Person e").executeUpdate();
		em.getTransaction().commit();

		Person p1 = new Person(0, "Lupancu","Denisa", LocalDate.of(2000,10,12), "Romania");
		Person p2 = new Person(1, "Ionescu","Alina", LocalDate.of(2000,10,12), "Romania");
		Person p3 = new Person(2, "Popescu","I.", LocalDate.of(2001,12,12), "Romania");
		Person p4 = new Person(3, "Popescu","Mihai", LocalDate.of(1995,06,10), "Romania");
		Person p5 = new Person(4, "Ionescu","Maria", LocalDate.of(1990,03,2), "Romania");

		//Se colecteaza lista de persoane intr-un stream de obiecte:
		List<Person> persons = Stream.of(p1, p2, p3, p4, p5).collect(Collectors.toList());
		
		// Inainte de persistenta
		System.out.println("Inainte de persistenta");
		printEntitateCerinta(persons);
		
		// Asociere context persistenta
		persons.forEach(p -> em.persist(p));
		System.out.println("Dupa asociere context persistenta");
		printEntitateCerinta(persons);
		
		// Sincronizare SQL: executie fraze DML-SQL
		em.getTransaction().begin();
		//save:
		em.flush();
		System.out.println("Dupa Sincronizare SQL: executie fraze DML-SQL");
		printEntitateCerinta(persons);
		
		// Efectuare tranzactie
		em.getTransaction().commit();
		System.out.println("Dupa efectuare tranzactie");
		System.out.println("Interogare cerinte: ");
		System.out.println("Interogare cerinte functionale: ");
		
		//Citire dupa creare
		List<Person> personals = em.createQuery("SELECT p FROM Person p").getResultList();
		printEntitateCerinta(personals);
	
		System.out.println("End");
	}
	static void printEntitateCerinta(List<Person> persons) {
		System.out.println("-------------------------------");
		persons.stream().forEach(
				p -> System.out.println(p.getClass().getSimpleName() + ": " + p));
		System.out.println("-------------------------------");
	}
}
