package services;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Applicants;
import managers.ManagerHelper;



@Path("/applicants")
public class ApplicantsService {

	
	@GET
	@Path("get")
	public Applicants getApplicants(@QueryParam("id") int id) {
		return managers.ManagerHelper.getapplicantsManager().get(id);

	}
	
	@GET
	@Path("getall")
	public List<Applicants> getApplicants() {
		return ManagerHelper.getapplicantsManager().getall();

	}
	
	@GET
	@Path("getacv")
	public Applicants getacv(@QueryParam("firstname") String firstname,
			@QueryParam("lastname") String lastname,@QueryParam("email")
	String email,@QueryParam("phone") String phone,@QueryParam("yearsofexperience")String
	yearsofexperience,@QueryParam("archive")String archive,@QueryParam("app")int id,@QueryParam("cv")String cv,@QueryParam("locked")String locked,@QueryParam("status")String status,@QueryParam("NA")String NA) {
		return ManagerHelper.getapplicantsManager().getacv(cv, id, firstname,  email,lastname, phone, yearsofexperience, archive, locked, status, NA);

	}
	
	@GET
	@Path("updateapplicant")
	public Applicants updateapplicant(@QueryParam("firstname") String firstname,
			@QueryParam("lastname") String lastname,@QueryParam("email")
	String email,@QueryParam("phone") String phone,@QueryParam("yearsofexperience")String
	yearsofexperience,@QueryParam("archive")String archive,@QueryParam("id")int id,@QueryParam("job")String job,@QueryParam("cv")String cv,@QueryParam("locked")String locked,@QueryParam("status")String status,@QueryParam("NA")String NA) {
		return ManagerHelper.getapplicantsManager().updateapplicant(firstname, lastname, email, phone, yearsofexperience, archive, id,job,cv,locked,status,NA);

	}
	
	@GET
	@Path("createapplicant")
	public Applicants createapplicant(@QueryParam("firstname") String firstname,
			@QueryParam("lastname") String lastname,@QueryParam("email")
	String email,@QueryParam("phone") String phone,@QueryParam("yearsofexperience")String
	yearsofexperience,@QueryParam("archive")String archive,@QueryParam("job")String job,@QueryParam("locked")String locked,@QueryParam("cv")String cv,@QueryParam("status")String status,@QueryParam("NA")String NA) {
		return ManagerHelper.getapplicantsManager().createapplicant(firstname, lastname, email, phone, yearsofexperience, archive,job,locked,status,NA);

	}
	@GET
	@Path("getApllicantByArchive")
	
	public List <Applicants> getApllicantByArchive(){
		return (List<Applicants>) ManagerHelper.getapplicantsManager().getAllApplicantsByArchive();
		
	}
	
	@GET
	@Path("getallarchivetrue")
	
	public List <Applicants> getallarchivetrue(){
		return (List<Applicants>) ManagerHelper.getapplicantsManager().getallarchivetrue();
		
	}
	@GET
	@Path("sendSummery")

	public Applicants sendSummery(@QueryParam("id")int  id,@QueryParam("status") String status) throws MessagingException {
		System.out.println("in service");
		return ManagerHelper.getapplicantsManager().sendSummery(id,status);
		

	}    
	
	
}
