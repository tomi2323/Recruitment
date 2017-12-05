package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Jobrecruting {

	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
   
    @ManyToOne
    @JoinColumn(name="job" )
	private Jobs job;
    
    
   

	@ManyToOne
    @JoinColumn(name="manager" )
	private Recrutingmanager manager;

	
	public Jobrecruting(){
		
		
		
	}
	
    public Jobrecruting(int id,Jobs job,Recrutingmanager manager) {
		this.id=id;
		this.job=job;
		this.manager=manager;
		
	}
    
    public Jobrecruting(Jobs job,Recrutingmanager manager) {    	
    	this.job=job;
		this.manager=manager;		
   	}
    
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	public Recrutingmanager getManager() {
		return manager;
	}

	public void setManager(Recrutingmanager manager) {
		this.manager = manager;
	}
}
