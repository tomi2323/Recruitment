package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ApplicantsJobs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "applicantid")
	private Applicants applicantid;

	@ManyToOne
	@JoinColumn(name = "jobsid")
	private Jobs jobsid;

	
	
	
	public ApplicantsJobs(){
		
	}
	

	
	public ApplicantsJobs(Applicants applicantid, Jobs jobsid) {
		this.applicantid = applicantid;
		this.jobsid = jobsid;
	}

	public ApplicantsJobs(int id, Applicants applicantid, Jobs jobsid) {
		this.id = id;
		this.applicantid = applicantid;
		this.jobsid = jobsid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Applicants getApplicantid() {
		return applicantid;
	}

	public void setApplicantid(Applicants applicantid) {
		this.applicantid = applicantid;
	}

	public Jobs getJobsid() {
		return jobsid;
	}

	public void setJobsid(Jobs jobsid) {
		this.jobsid = jobsid;
	}

	
}
