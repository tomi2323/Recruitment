package managers;

import java.util.List;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;


import entity.Recrutingmanager;

public class Rmmanager {

	private final EntityManager entityManager;

	

	public Rmmanager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
	}

	public void update(Recrutingmanager recrutingmanager) {
		entityManager.getTransaction().begin();
		entityManager.merge(recrutingmanager);
		entityManager.getTransaction().commit();
	}

	public void create(Recrutingmanager recrutingmanager) {
		entityManager.getTransaction().begin();
		entityManager.persist(recrutingmanager);
		entityManager.getTransaction().commit();
	}

	public void delete(Recrutingmanager recrutingmanager) {
		entityManager.getTransaction().begin();
		entityManager.remove(recrutingmanager);
		entityManager.getTransaction().commit();
	}

	public Recrutingmanager get(Integer id) {
		return entityManager.find(Recrutingmanager.class, id);
	}
	
	public List<Recrutingmanager> getall() {
		String sql = "SELECT * FROM recruitment.recrutingmanager";
		return (List) entityManager.createNativeQuery(sql , Recrutingmanager.class).getResultList();
		
	}
	
	
	
	
}
