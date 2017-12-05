package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.apache.openjpa.persistence.jdbc.Unique;

@Entity
public class Jobs {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	
	private String description;
	
	private String yearsofexperience;
	
	private String position;
	
	private String archive;
	
	private String name;
	
	

	
	
	public Jobs( int id,String description,String yearsofexperience,String position,String archive,String name){
	this.archive=archive;
	this.description=description;
	this.id=id;
	this.name=name;
	this.yearsofexperience=yearsofexperience;
	this.position=position;
	}
	public Jobs( int id,String description,String yearsofexperience,String position,String name){
	this.id=id;
	this.description=description;
	this.name=name;
	this.yearsofexperience=yearsofexperience;
	this.position=position;
	}
    public Jobs(String description,String yearsofexperience,String position,String archive,String name){
    	this.name=name;
    	this.yearsofexperience=yearsofexperience;
    	this.position=position;
    	this.archive=archive;
    	this.description=description;
	}
    
    public Jobs(){
		
	}
	
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getYearsofexperience() {
		return yearsofexperience;
	}

	public void setYearsofexperience(String yearsofexperience) {
		this.yearsofexperience = yearsofexperience;
	}

	public String getSkills() {
		return position;
	}

	public void setSkills(String skills) {
		this.position = skills;
	}

	public String getArchive() {
		return archive;
	}

	public void setArchive(String archive) {
		this.archive = archive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
