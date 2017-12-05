package managers;



import java.util.List;
import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import entity.Skills;

public class SkillsManager {

	private final EntityManager entityManager;

	public SkillsManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
	}

	public void update(Skills skills) {
		entityManager.getTransaction().begin();
		entityManager.merge(skills);
		entityManager.getTransaction().commit();
	}

	public void create(Skills skills) {
		entityManager.getTransaction().begin();
		entityManager.persist(skills);
		entityManager.getTransaction().commit();
	}

	public void delete(Skills skills) {
		entityManager.getTransaction().begin();
		entityManager.remove(skills);
		entityManager.getTransaction().commit();
	}

	/**
	 * The function returns the customer's id
	 * 
	 * @param id
	 * @return
	 */
	public Skills get(Integer id) {
		return entityManager.find(Skills.class, id);
	}

	/**
	 * This function returns a customer list by name
	 * 
	 * @param id
	 * @return
	 */
	public List<Skills> getByName(String technology) {
		String sql = "select * from skills where technology like '";
		return (List) entityManager.createNativeQuery(sql + technology + "'", Skills.class).getResultList();
	}
	
	public List<Skills> getByall() {
		String sql = "select * from recruitment.skills ";
		return (List) entityManager.createNativeQuery(sql , Skills.class).getResultList();
	}
	
	
	
	
}