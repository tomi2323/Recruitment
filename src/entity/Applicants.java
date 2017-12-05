package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Applicants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String cv;
	private String lastname;
	private String phone;
	private String email;
	private String yearsofexperience;
	private String locked;
	private String archive;
	private String status;
	private String summery ;

	
	
	public Applicants(){
		
		
	}
	
   public Applicants(String firstname,String lastname,String phone,String email,String yearsofexperience,String archive,String cv,String locked,String status,String summery){
	this.cv=cv;   
	this.firstname=firstname;
	this.lastname=lastname;
	this.phone=phone;
	this.locked=locked;
	this.yearsofexperience=yearsofexperience;
	this.email=email;
	this.archive=archive;
	this.summery= summery;
	this.setStatus(status);
		
	}
   
   public Applicants(String firstname,String lastname,String phone,String email,String yearsofexperience,String archive,int id,String cv,String locked,String status,String summery){
	    this.cv=cv; 
	    this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.phone=phone;
		this.locked=locked;
		this.yearsofexperience=yearsofexperience;
		this.email=email;
		this.archive=archive;
		this.summery= summery;
		this.setStatus(status);
			
		}
   public Applicants(String firstname,String lastname,String phone,String email,String yearsofexperience,String archive,int id,String cv,String locked){
	    this.cv=cv; 
	    this.id=id;
		this.firstname=firstname;
		this.lastname=lastname;
		this.phone=phone;
		this.locked=locked;
		this.yearsofexperience=yearsofexperience;
		this.email=email;
		this.archive=archive;
			
		}
   
   public Applicants(String firstname,String lastname,String phone,String email,String yearsofexperience,String archive,String status,String summery){
	    this.setStatus(status); 
	    this.summery= summery;
		this.firstname=firstname;
		this.lastname=lastname;
		this.phone=phone;
		
		this.yearsofexperience=yearsofexperience;
		this.email=email;
		this.archive=archive;
			
		}
   
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getYearofexperience() {
		return yearsofexperience;
	}

	public void setYearofexperience(String yearsofexperience) {
		this.yearsofexperience = yearsofexperience
		
		;
	}

	

	public String getArchive() {
		return archive;
	}

	public void setArchive(String archive) {
		this.archive = archive;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getLocked() {
		return locked;
	}

	public void setLocked(String locked) {
		this.locked = locked;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getsummery() {
		return summery;
	}

	public void setsummery(String nA) {
		summery = nA;
	}

}
