package BagDetails.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "deposits")
public class Deposit extends BaseId {
	 
	private String nameDepo;
	
	private int availableBag;
	
	@ManyToOne
	@JoinColumn(name="depositList")
	private Country country;
	
	public String getNameDepo() {
		return nameDepo;
	}
	
	public void setNameDepo(String nameDepo) {
		this.nameDepo = nameDepo;
	}
	
	public int getAvailableBag() {
		return availableBag;
	}
	
	public void setAvailableBag(int availableBag) {
		this.availableBag = availableBag;
	}

	public Deposit(int id, String nameDepo, int availableBag) {
		super(id);
		this.nameDepo = nameDepo;
		this.availableBag = availableBag;
	}

	public Deposit() {
		super();
	}

	public Deposit(int id) {
		super(id);
	}
}
