package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Users {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;	
	

	private String username;
	
	
	private String password;
	
	
	private String role;
	
	
		
    public Users(){
		
		
		
	}
	
    
    public Users(int id,String username,String passward,String role){
    	this.id=id;
    	this.password=passward;
    	this.role=role;
    	this.username=username;		
    	}
    
    
    public Users(String username,String passward,String role){    	
    	this.password=passward;
    	this.role=role;
    	this.username=username;		
    	}
    
    
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassward() {
		return password;
	}

	public void setPassward(String passward) {
		this.password = passward;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
