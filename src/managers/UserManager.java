package managers;

import javax.persistence.EntityManager;

import org.apache.openjpa.persistence.EntityManagerImpl;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import entity.Recrutingmanager;
import entity.Reply;
import entity.Users;




public class UserManager {

	
	private final EntityManager entityManager;

	public UserManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);
	}

	public void update(Users User) {
		entityManager.getTransaction().begin();
		entityManager.merge(User);
		entityManager.getTransaction().commit();
	}

	public void create(Users User) {
		
		entityManager.getTransaction().begin();
		entityManager.persist(User);
		entityManager.getTransaction().commit();
	}
	public Users createUsers(String username,String password,String role){
		
		try{
			
		Users user2 = new Users(username,password,role);
		
		entityManager.getTransaction().begin();
		entityManager.persist(user2);
		entityManager.getTransaction().commit();
		return user2;
	}catch (Exception e){
		e.printStackTrace();
		Users u=new Users();
		return u;
	}
		
}


	public void delete(Users User) {
		entityManager.getTransaction().begin();
		entityManager.remove(User);
		entityManager.getTransaction().commit();
	}
	
	public Reply deleteUser (int id){
		
		try{
			Users users = get(id);
			
			entityManager.getTransaction().begin();
			entityManager.remove(users);
			entityManager.getTransaction().commit();
			
			return new Reply();
			
		}catch (Exception e){
			e.printStackTrace();
			Reply r = new Reply();
			r.setId(id);
			r.setMsg(e.getMessage());
			return r;
			
		}
	}
	
	
	public Users get(Integer id) {
		return entityManager.find(Users.class, id);
	}
	
	public Users getUserByUsernameAndPass(String username, String password) {
		try{
		String loginUser = "select * from users where username like '"+username+"' && password like '" +password+"'";
		return (Users) entityManager.createNativeQuery(loginUser, Users.class).getSingleResult();
		}catch (Exception e ) {
			return null;
		}
		
	}
	
	public Reply sendLink(int id) throws javax.mail.MessagingException {
		System.out.println("in manager");
		String sql = "SELECT id , email FROM recruitment.recrutingmanager where id =" + id;
		Recrutingmanager rc = (Recrutingmanager) entityManager.createNativeQuery(sql, Recrutingmanager.class).getSingleResult();


		MailHelper.sendMail(rc.getEmail(),"Link To New Applicant:",
		"Press Me " + " "+ "http://localhost/recruitment/main.html?uname=neta&passsword=1#!/1");
		Reply r = new Reply();
		return r;

	}



	
}
