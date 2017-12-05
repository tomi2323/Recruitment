package managers;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entity.Jobrecruting;
import entity.Recrutingmanager;



public class ManagerHelper {

	public static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("recruitment");

	private static EntityManager entityManager=entityManagerFactory.createEntityManager();

		
	
	
	public static UserManager getusermanager() {

		return new UserManager(entityManagerFactory.createEntityManager());

	}
	
	
	public static ApplicantsManager getapplicantsManager() {

		return new ApplicantsManager(entityManagerFactory.createEntityManager());

	}
	
	public static JobsManager getjobsManager() {

		return new JobsManager(entityManagerFactory.createEntityManager());

	}
	
	public static SkillsManager getskillsManager() {

		return new SkillsManager(entityManagerFactory.createEntityManager());

	}
	
	public static Applicantsskillsmanger getapplicantsskillsmanger() {

		return new Applicantsskillsmanger(entityManagerFactory.createEntityManager());

	}
	
	public static ApplicantsJobsManager getApplicantsJobsManager() {

		return new ApplicantsJobsManager(entityManagerFactory.createEntityManager());

	}
	
	public static Jobsskllsmanager getJobsskllsmanager() {

		return new Jobsskllsmanager(entityManagerFactory.createEntityManager());

	}
	
	public static Rmmanager getRecrutingmanager() {

		return new Rmmanager(entityManagerFactory.createEntityManager());

	}
	
	public static Jobmanagermanger getJobrecruting() {

		return new Jobmanagermanger(entityManagerFactory.createEntityManager());

	}
	public static HrManager getHrManager() {

		return new HrManager(entityManagerFactory.createEntityManager());

	}
	
	
}