package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.apache.openjpa.persistence.jdbc.Unique;

@Entity

   public class Skills {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;

	private String technology;

	
	
	public Skills(){
		
		
	}
	
    public Skills(String technology,int id ){
		this.technology=technology;
		this.id=id;
		
	}
	
    public Skills(String technology ){
		this.technology=technology;
	
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}
	
}

