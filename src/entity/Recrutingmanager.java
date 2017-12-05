package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Recrutingmanager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	private String firstname;	
	private String lastname;
	private String position;
	private int user;	
	private String phone;
	private String email;
	
	
    public Recrutingmanager(){
		
		
	}
	
    public Recrutingmanager(int id,String firstname,String lastname,String position,int user,String phone,String email){
    	this.id=id;   
    	this.firstname=firstname;
    	this.lastname=lastname;
    	this.phone=phone;
    	this.position=position;    
    	this.email=email;
    	this.user=user;
		
	}
    public Recrutingmanager(String firstname,String lastname,String position,int user,String phone,String email){	
    	  
    	this.firstname=firstname;
    	this.lastname=lastname;
    	this.phone=phone;
    	this.position=position;    
    	this.email=email;
    	this.user=user;
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	
	
}
