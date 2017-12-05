package managers;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Applicants;
import entity.Applicantsskills;
import entity.Jobs;
import entity.Jobssklls;
import entity.Reply;
import entity.Skills;

public class Jobsskllsmanager {	

		private final EntityManager entityManager;

		public Jobsskllsmanager(EntityManager entityManager) {
			this.entityManager = entityManager;
			((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
		}

		public void update(Jobssklls jobssklls) {
			entityManager.getTransaction().begin();
			entityManager.merge(jobssklls);
			entityManager.getTransaction().commit();
		}

		public void create(Jobssklls jobssklls) {
			entityManager.getTransaction().begin();
			entityManager.persist(jobssklls);
			entityManager.getTransaction().commit();
		}

		public void delete(Jobssklls jobssklls) {
			entityManager.getTransaction().begin();
			entityManager.remove(jobssklls);
			entityManager.getTransaction().commit();
		}

		public Jobssklls get(Integer id) {
			return entityManager.find(Jobssklls.class, id);
		}

        public List<Jobssklls> getskillsbyjob(int job) {
			
			String sql = "SELECT * FROM recruitment.jobssklls where job ="+job;
			
			return (List<Jobssklls>) entityManager.createNativeQuery(sql, Jobssklls.class).getResultList();
			
   }

        public List<Jobssklls> getalljobssklls() {
			
			String sql = "SELECT * FROM recruitment.jobssklls ";
			
			return (List<Jobssklls>) entityManager.createNativeQuery(sql, Jobssklls.class).getResultList();
			
   }
        
        
        
        public Reply deletJobssklls(int id) {
    		
        	  try {

        		entityManager.getTransaction().begin();
        		Jobssklls jobssklls = get(id);
      			entityManager.remove(jobssklls);
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
       
        	public Jobssklls conectjobtoskill(int job,int skill){
        		try {
        			Jobs job2 = ManagerHelper.getjobsManager().get(job);
        		System.out.println(job2);
        		
        		Skills skill2 = ManagerHelper.getskillsManager().get(skill);
        		System.out.println(skill2.getTechnology());
        		entityManager.getTransaction().begin();
        		
        		Jobssklls as = new Jobssklls(job2,skill2);
        		entityManager.persist(as);
        		entityManager.getTransaction().commit();
        		return as;	
        		} catch (Exception e) {
        			e.printStackTrace();
        			Jobssklls	emplo = new Jobssklls();
        			
        			return emplo;

        		}
        	
        	}

  			
    
	
	}	
	

