package managers;

import java.util.List;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Applicants;

import entity.Hr;

import entity.Reply;
import entity.Users;

public class HrManager {

	private final EntityManager entityManager;

	public HrManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
	}

	public void update(Hr hr) {
		entityManager.getTransaction().begin();
		entityManager.merge(hr);
		entityManager.getTransaction().commit();
	}

	public void create(Hr hr) {

		entityManager.getTransaction().begin();
		entityManager.persist(hr);
		entityManager.getTransaction().commit();
	}

	public void delete(Hr hr) {
		entityManager.getTransaction().begin();
		entityManager.remove(hr);
		entityManager.getTransaction().commit();
	}

	public Hr get(Integer id) {
		return entityManager.find(Hr.class, id);
	}


}