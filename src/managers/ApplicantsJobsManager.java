package managers;



import java.util.List;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Applicants;
import entity.ApplicantsJobs;
import entity.Jobs;
import entity.Reply;



public class ApplicantsJobsManager {
	

		private final EntityManager entityManager;

		public ApplicantsJobsManager(EntityManager entityManager) {
			this.entityManager = entityManager;
			((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true); 

		}

		public void update(ApplicantsJobs applicantsJobs) {
			entityManager.getTransaction().begin();
			entityManager.merge(applicantsJobs);
			entityManager.getTransaction().commit();
		}

		public Reply updateApplicantsJobs (int id, int applicantsid,int jobsid) {
			Applicants ap = ManagerHelper.getapplicantsManager().get(applicantsid);
			Jobs jo = ManagerHelper.getjobsManager().get(jobsid);
			try {
				ApplicantsJobs applicantsJobs = new ApplicantsJobs(id,ap,jo);
				entityManager.getTransaction().begin();
				entityManager.merge(applicantsJobs);
				entityManager.getTransaction().commit();
				return new Reply();
			} catch (Exception e) {
				e.printStackTrace();
				Reply r = new Reply();
				r.setId(Reply.FAIL_ID);
				r.setMsg(e.getMessage());
				return r;
			}

		}

		public void create(ApplicantsJobs applicantsJobs) {
			entityManager.getTransaction().begin();
			entityManager.persist(applicantsJobs);
			entityManager.getTransaction().commit();
		}

		public ApplicantsJobs createApplicantsJobs  (int applicantsid,int jobsid) {
			
			Applicants ap = ManagerHelper.getapplicantsManager().get(applicantsid);
			Jobs jo = ManagerHelper.getjobsManager().get(jobsid);
			try {
				
				ApplicantsJobs applicantsJobs = new ApplicantsJobs(ap,jo);
			

				entityManager.getTransaction().begin();
				entityManager.persist(applicantsJobs);
				entityManager.getTransaction().commit();
				return applicantsJobs;

			} catch (Exception e) {
				e.printStackTrace();

				return null;
			}
		}

		public void delete(ApplicantsJobs applicantsJobs) {
			entityManager.getTransaction().begin();
			entityManager.remove(applicantsJobs);
			entityManager.getTransaction().commit();

		}

		public Reply deleteApplicantsJobs(int id) {
			try {
				ApplicantsJobs applicantsJobs = get(id);
				entityManager.getTransaction().begin();
				entityManager.remove(applicantsJobs);
				entityManager.getTransaction().commit();
				return new Reply();
			} catch (Exception e) {
				e.printStackTrace();
				Reply r = new Reply();
				r.setId(Reply.FAIL_ID);
				r.setMsg(e.getMessage());
				return r;
			}

		}

		public ApplicantsJobs get(Integer id) {
			return entityManager.find(ApplicantsJobs.class, id);
		}

		
		public List<ApplicantsJobs> getAllApplicantsJobs () {
			String sql = "select * from recruitment.applicantsjobs ";
			return (List<ApplicantsJobs>)entityManager.createNativeQuery(sql,ApplicantsJobs.class).getResultList();
	}

	}


