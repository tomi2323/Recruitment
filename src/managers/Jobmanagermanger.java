package managers;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Applicants;
import entity.Applicantsskills;
import entity.Jobrecruting;
import entity.Jobs;
import entity.Jobssklls;
import entity.Recrutingmanager;
import entity.Reply;
import entity.Skills;

public class Jobmanagermanger {

	
	private final EntityManager entityManager;

	public Jobmanagermanger(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
	}

	public void update(Jobrecruting jobrecruting) {
		entityManager.getTransaction().begin();
		entityManager.merge(jobrecruting);
		entityManager.getTransaction().commit();
	}

	public void create(Jobrecruting jobrecruting) {
		entityManager.getTransaction().begin();
		entityManager.persist(jobrecruting);
		entityManager.getTransaction().commit();
	}

	public void delete(Jobrecruting jobrecruting) {
		entityManager.getTransaction().begin();
		entityManager.remove(jobrecruting);
		entityManager.getTransaction().commit();
	}

	public Jobrecruting get(Integer id) {
		return entityManager.find(Jobrecruting.class, id);
	}
	
    public List<Jobrecruting> getjobbymanager(int job) {
		
			String sql = "SELECT * FROM recruitment.jobrecruting where job ="+job;
			
			return (List<Jobrecruting>) entityManager.createNativeQuery(sql, Jobrecruting.class).getResultList();
			
}

     public List<Jobrecruting> getalljobmanger() {
			
			String sql = "SELECT * FROM recruitment.jobrecruting ";
			
			return (List<Jobrecruting>) entityManager.createNativeQuery(sql, Jobrecruting.class).getResultList();
			
}
     
     public Reply deletJobsmaneger(int id) {
 		
   	  try {

   		entityManager.getTransaction().begin();
   		Jobrecruting jobrecruting = get(id);
 			entityManager.remove(jobrecruting);
 			entityManager.getTransaction().commit();

 			return new Reply();

 		} catch (Exception e) {
 			e.printStackTrace();
 			Reply reply = new Reply();
 			reply.setId(Reply.FAIL_ID);
 			reply.setMsg("error id is wrong");
 			return reply;

 		}
 	}
 
     
     	public Jobrecruting conectjobtomanger(int job,int manager){
     		try {
     		Jobs job2 = ManagerHelper.getjobsManager().get(job);
     		System.out.println(job2);
     		
     		Recrutingmanager manager2 = ManagerHelper.getRecrutingmanager().get(manager);
     		System.out.println(manager2.getPosition());
     		entityManager.getTransaction().begin();
     		
     		Jobrecruting as = new Jobrecruting(job2,manager2);
     		entityManager.persist(as);
     		entityManager.getTransaction().commit();
     		return as;	
     		} catch (Exception e) {
     			e.printStackTrace();
     			Jobrecruting	emplo = new Jobrecruting();
     			
     			return emplo;

     		}
     	
     	}


}
