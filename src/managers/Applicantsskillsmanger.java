package managers;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Applicants;
import entity.Applicantsskills;
import entity.Jobssklls;
import entity.Reply;
import entity.Skills;





	public class Applicantsskillsmanger {

		private final EntityManager entityManager;

		public Applicantsskillsmanger(EntityManager entityManager) {
			this.entityManager = entityManager;
			((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
		}

		public void update(Applicantsskills applicantsskills) {
			entityManager.getTransaction().begin();
			entityManager.merge(applicantsskills);
			entityManager.getTransaction().commit();
		}

		public void create(Applicantsskills applicantsskills) {
			entityManager.getTransaction().begin();
			entityManager.persist(applicantsskills);
			entityManager.getTransaction().commit();
		}

		public void delete(Applicantsskills applicantsskills) {
			entityManager.getTransaction().begin();
			entityManager.remove(applicantsskills);
			entityManager.getTransaction().commit();
		}

		public Applicantsskills get(Integer id) {
			return entityManager.find(Applicantsskills.class, id);
		}

        public List<Applicantsskills> getskillsbyapp(int applicant) {
			
			String sql = "SELECT * FROM recruitment.applicantsskills where applicants ="+applicant;
			
			return (List<Applicantsskills>) entityManager.createNativeQuery(sql, Applicantsskills.class).getResultList();
			
   }

        public List<Applicantsskills> getallappskilss() {
			
			String sql = "SELECT * FROM recruitment.applicantsskills ";
			
			return (List<Applicantsskills>) entityManager.createNativeQuery(sql, Applicantsskills.class).getResultList();
			
   }
        
        public Reply deletappssklls(int id) {
    		
        	  try {

        		entityManager.getTransaction().begin();
        		Applicantsskills applicantsskills = get(id);
      			entityManager.remove(applicantsskills);
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
       
        	public Applicantsskills conectapptoskill(int applicant,int skill){
        		try {
        		Applicants applicant2 = ManagerHelper.getapplicantsManager().get(applicant);
        		System.out.println(applicant2);
        		
        		Skills skill2 = ManagerHelper.getskillsManager().get(skill);
        		System.out.println(skill2.getTechnology());
        		entityManager.getTransaction().begin();
        		
        		Applicantsskills as = new Applicantsskills(applicant2,skill2);
        		entityManager.persist(as);
        		entityManager.getTransaction().commit();
        		return as;	
        		} catch (Exception e) {
        			e.printStackTrace();
        			Applicantsskills	emplo = new Applicantsskills();
        			
        			return emplo;

        		}
        	
        	}

  			
    
	
	}

