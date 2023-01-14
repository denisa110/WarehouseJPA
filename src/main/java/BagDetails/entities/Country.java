package BagDetails.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "countries")
public class Country extends BaseId {
	
	private String countyName;
	
	@OneToMany(fetch = LAZY, cascade = ALL, mappedBy ="country" )
List <Deposit> depositList = new ArrayList<>();


	public String getCountyName() {
		return countyName;
	}

	public void setCountyName(String countyName) {
		this.countyName = countyName;
	}

	public Country(int id, String countyName) {
		super(id);
		this.countyName = countyName;
	}

	public Country() {
		super();
	}

	public Country(int id) {
		super(id);
	}
}
