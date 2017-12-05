package managers;



import java.util.List;
import javax.persistence.EntityManager;
import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Applicants;
import entity.Jobs;
import entity.Reply;

public class JobsManager {

	private final EntityManager entityManager;

	public JobsManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
	}

	public void update(Jobs jobs) {
		entityManager.getTransaction().begin();
		entityManager.merge(jobs);
		entityManager.getTransaction().commit();
	}

	public void create(Jobs jobs) {
		entityManager.getTransaction().begin();
		entityManager.persist(jobs);
		entityManager.getTransaction().commit();
	}

	public void delete(Jobs jobs) {
		entityManager.getTransaction().begin();
		entityManager.remove(jobs);
		entityManager.getTransaction().commit();
	}

	public Jobs get(Integer id) {
		return entityManager.find(Jobs.class, id);
	}

	public List<Jobs> getByName(String job) {
		String sql = "select * from jobs where job like '";
		return (List) entityManager.createNativeQuery(sql + job + "'", Jobs.class).getResultList();
	}
	
	public List<Jobs> getall() {
		String sql = "SELECT * FROM recruitment.jobs";
		return (List) entityManager.createNativeQuery(sql , Jobs.class).getResultList();
	}

	
	public Jobs createjob(String description,String yearsofexperience,String position,String archive,String name) {
		try {
			entityManager.getTransaction().begin();		
			Jobs job  = new Jobs(description,yearsofexperience,position,archive,name);
					System.out.println(job.getName() +" "+ job.getId());
			entityManager.persist(job);
			entityManager.getTransaction().commit();
		return job;
		} catch (Exception e) {
			Jobs job = new Jobs();
			return job;		
		}
	}
	
	public Reply updateJob(int id, String description, String yearsofexperience ,  String position,String name  ){
		Jobs jobs = new Jobs(id,description,yearsofexperience , position,name);
		
		try{
			
			
			entityManager.getTransaction().begin();
			entityManager.merge(jobs);
			entityManager.getTransaction().commit();
			return new Reply();
		} catch (Exception e) {
			Reply reply = new Reply();
			reply.setId(Reply.FAIL_ID);
			String s = e.getMessage();

			reply.setMsg(s);
			return reply;
	}

}

}
