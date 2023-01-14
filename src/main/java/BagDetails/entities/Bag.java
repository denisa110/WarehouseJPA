package BagDetails.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "bags")
public class Bag extends BaseId {
	
	private Size size;
	
	private String color;
	
	private Double weight;
	 
	@ManyToOne
	@JoinColumn(name="person")
	private Person person;
	
	
	public Size getSize() {
		return size;
	}
	public void setSize(Size size) {
		this.size = size;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Bag() {
		super();
	}
	public Bag(int id) {
		super(id);
	}
	public Bag(int id, Size size, String color, Double weight) {
		super(id);
		this.size = size;
		this.color = color;
		this.weight = weight;
		
	}
}
