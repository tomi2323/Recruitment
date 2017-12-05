package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Jobssklls {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
   
    @ManyToOne
    @JoinColumn(name="Job" )
	private Jobs Job;
    
    
    

	@ManyToOne
    @JoinColumn(name="skill" )
	private Skills skills;
    
    
	public Jobssklls(int id, Jobs Job, Skills skills) {
		this.id = id;
		this.Job = Job;
		this.skills = skills;
	}
	
	public Jobssklls(Jobs Job, Skills skills) {
		
		this.Job = Job;
		this.skills = skills;
	}

	
	
	
    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Jobs getJob() {
		return Job;
	}


	public void setJob(Jobs job) {
		Job = job;
	}


	public Skills getSkills() {
		return skills;
	}


	public void setSkills(Skills skills) {
		this.skills = skills;
	}



	
    public Jobssklls() {
		
	}

	
}
