package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Applicantsskills {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
   
    @ManyToOne
    @JoinColumn(name="applicants" )
	private Applicants applicants;
    
    
    @ManyToOne
    @JoinColumn(name="skills" )
	private Skills skills;

	
    public Applicantsskills() {
		
	}

    
    
	
	public Applicantsskills(int id, Applicants applicants, Skills skills) {
		this.id = id;
		this.applicants = applicants;
		this.skills = skills;
	}
	
	public Applicantsskills(Applicants applicants, Skills skills) {
		
		this.applicants = applicants;
		this.skills = skills;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Applicants getApplicant() {
		return applicants;
	}

	public void setApplicant(Applicants applicants) {
		this.applicants = applicants;
	}

	public Skills getSkillsid() {
		return skills;
	}

	public void setSkillsid(Skills skills) {
		this.skills = skills;
	}

}
