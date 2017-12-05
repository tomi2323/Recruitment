package managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.regex.Pattern;

import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import org.apache.openjpa.persistence.EntityManagerImpl;
import entity.Applicants;
import entity.Hr;


public class ApplicantsManager {

	private final EntityManager entityManager;

	public ApplicantsManager(EntityManager entityManager) {
		this.entityManager = entityManager;
		((EntityManagerImpl) this.entityManager).getBroker().setAllowReferenceToSiblingContext(true);

	}

	public void update(Applicants applicants) {
		entityManager.getTransaction().begin();
		entityManager.merge(applicants);
		entityManager.getTransaction().commit();
	}

	public void create(Applicants applicants) {
		entityManager.getTransaction().begin();
		entityManager.persist(applicants);
		entityManager.getTransaction().commit();
	}

	public void delete(Applicants applicants) {
		entityManager.getTransaction().begin();
		entityManager.remove(applicants);
		entityManager.getTransaction().commit();

	}

	public Applicants get(Integer id) {
		return entityManager.find(Applicants.class, id);
	}

	public List<Applicants> getall() {
		String sql = "SELECT * FROM recruitment.applicants order by archive ="+"'"+true+"'";
		return (List) entityManager.createNativeQuery(sql, Applicants.class).getResultList();
	}

	
			
		public List<Applicants> getallarchivetrue() {
		String sql = "SELECT * FROM recruitment.applicants where archive ="+"'"+false+"'";
		return (List) entityManager.createNativeQuery(sql, Applicants.class).getResultList();
	}		
			
	public Applicants getacv(String cv, int app,String firstname,String lastname,String email,String phone ,String yearsofexperience,String archive,String locked,String status,String summery) {
		 
		try {
			entityManager.getTransaction().begin();		
			Applicants applicant  = new Applicants(firstname,lastname,phone,email,yearsofexperience,archive,app,cv,locked, status, summery);
					System.out.println(applicant.getFirstname() +" "+ applicant.getLastname());
			entityManager.merge(applicant);
			entityManager.getTransaction().commit();
		return applicant;
		} catch (Exception e) {
			Applicants app3 = new Applicants();
			return app3;		
		}
	}
		
		
	
	

	public Applicants updateapplicant(String firstname,String lastname,String email,String phone ,String yearsofexperience,String archive,int id,String job,String cv,String locked,String status,String summery) {
		try {
			entityManager.getTransaction().begin();		
			Applicants applicant  = new Applicants(firstname,lastname,phone,email,yearsofexperience,archive,id,cv,locked, status, summery);
					System.out.println(applicant.getFirstname() +" "+ applicant.getLastname());
			entityManager.merge(applicant);
			entityManager.getTransaction().commit();
		return applicant;
		} catch (Exception e) {
			Applicants app = new Applicants();
			return app;		
		}
	}
	
	@SuppressWarnings("finally")
	public String uploadfile( String x) throws IOException {
				 
		    final String path = "C:/Users/user/web/recruitment/WebContent/applicantcv";
		    String[] array = x.split(Pattern.quote(File.separator));
		    String str = array[2];
		    System.out.println(x);
		    System.out.println(str);
		    InputStream in = null;
		    OutputStream out = null;
	               
	        try {
	       	File a = new File(path + File.separator + str);
	       	File b = new File(array[0]+ File.separator +array[1],array[2]);
	        System.out.println(array[0]+ File.separator +array[1]);
	         out = new FileOutputStream(a);
	         in = new  FileInputStream(b);        
	         
	         

	            int read = 0;
	            final byte[] bytes = new byte[1024];
				
				 while ((read = in.read(bytes)) != -1) {
		              out.write(bytes, 0, read);
		            }         
	       } catch (FileNotFoundException fne) {	          
               String no = "somthing has gone wrong";
               return no;  
	    	   
	      } finally {
	            if (out != null) {
	              out.close();
	            }
	           if (in != null) {
	        	   in.close();
	           }
	         
	               return x;
	           }
	        }
	   
		
	public Applicants createapplicant(String firstname,String lastname,String email,String phone ,String yearsofexperience,String archive,String job,String locked,String status,String summery) {
		try {
			entityManager.getTransaction().begin();		
			Applicants applicant  = new Applicants(firstname,lastname,email,phone,yearsofexperience,archive,job,locked,status,summery);
					System.out.println(applicant.getFirstname() +" "+ applicant.getLastname());
			entityManager.persist(applicant);
			entityManager.getTransaction().commit();
		return applicant;
		} catch (Exception e) {
			Applicants app = new Applicants();
			return app;		
		}
	}
	
	public List<Applicants> getAllApplicantsByArchive(){
		
		String sql = " SELECT * FROM recruitment.applicants where archive = 'false' ";
		return entityManager.createNativeQuery(sql,Applicants.class).getResultList();
		
	}
	
	public Applicants sendSummery(int id, String status) {
		Applicants a = new Applicants();
		if (status.equals("pass")) {
		System.out.println("try");
		String sql1 = "SELECT id , email FROM recruitment.hr ";
		Hr hr = (Hr) entityManager.createNativeQuery(sql1, Hr.class).getSingleResult();
		
		try {
			MailHelper.sendMail(hr.getEmail(), "Link To New Applicant:",
					"Press Me " + " " + "http://localhost/recruitment/main.html?name=neta&passsword=1#!/1");
		} catch (MessagingException e) {
			e.printStackTrace();
			return  (Applicants)entityManager.createNativeQuery(sql1,Applicants.class).getSingleResult();
		}
	
		
		


			System.out.println("sssxzaqeer");

			try {
				MailHelper.sendMail(hr.getEmail(), "Link To New Applicant:",
						"Press Me " + " " + "http://localhost/recruitment/main.html?name=neta&passsword=1#!/1");
				
				System.out.println("sssxzaqeer");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  (Applicants)entityManager.createNativeQuery(sql1,Applicants.class).getSingleResult();

			
		
			
			 


		}if (status.equals("Fails")) {
			
			String sql = "UPDATE applicants SET status = 'Fails' where id =" + id;
			Hr hr = (Hr) entityManager.createNativeQuery(sql, Hr.class).getSingleResult();
			
			
			try {
				MailHelper.sendMail(hr.getEmail(), "Link To New Applicant:",
						"Press Me " + " " + "http://localhost/recruitment/main.html?name=neta&passsword=1#!/1");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return  (Applicants)entityManager.createNativeQuery(sql,Applicants.class).getSingleResult();


		}
		if (status.equals("N/A")) {

			String sql2 = "UPDATE applicants SET status = 'N/A' where id =" + id;
			Hr hr = (Hr) entityManager.createNativeQuery(sql2, Hr.class).getSingleResult();
			try {
				MailHelper.sendMail(hr.getEmail(), "Link To New Applicant:",
						"Press Me " + " " + "http://localhost/recruitment/main.html?name=neta&passsword=1#!/1");
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return  (Applicants)entityManager.createNativeQuery(sql2,Applicants.class).getSingleResult();

		}
		return a;
		
		
	}



	
	}
