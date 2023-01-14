package BagDetails.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "persons")
public class Person extends BaseId {

    private String firstName;
    
    private String lastName;
    
   private LocalDate birthDate;
   
	private String country;

	@OneToMany(fetch = FetchType.LAZY, mappedBy ="person")
	private List<Bag> bagList = new ArrayList<Bag>();

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<Bag> getBagList() {
		return bagList;
	}

	public void setBagList(List<Bag> bagList) {
		this.bagList = bagList;
	}

	public Person(int id, String firstName, String lastName, LocalDate birthDate, String country, List<Bag> bagList) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.country = country;
		this.bagList = bagList;
	}
	
	public Person(int id, String firstName, String lastName, LocalDate birthDate, String country) {
		super(id);
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.country = country;
	}

	public Person() {
		super();
	}

	public Person(int id) {
		super(id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(bagList, birthDate, country, firstName, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(bagList, other.bagList) && Objects.equals(birthDate, other.birthDate)
				&& Objects.equals(country, other.country) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName);
	}

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName + ", birthDate=" + birthDate + ", country="
				+ country + ", bagList=" + bagList + "]";
	}

	public Person get(int i) {
		return null;
	}

	

	
}
