package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Applicants;
import entity.Applicantsskills;
import entity.Reply;
import managers.ManagerHelper;



@Path("/applicantsskillsservice")
public class applicantsskillsservice {

	
	@GET
	@Path("get")
	public Applicantsskills getApplicants(@QueryParam("id") int id) {
		return ManagerHelper.getapplicantsskillsmanger().get(id);

	}
	
	
	@GET
	@Path("getskillsbyapp")
	public List<Applicantsskills> getskillsbyapp(@QueryParam("applicant") int applicant) {
		return ManagerHelper.getapplicantsskillsmanger().getskillsbyapp(applicant);

	}
	
	@GET
	@Path("conectapptoskill")
	public Applicantsskills conectapptoskill(@QueryParam("applicant") int applicant,@QueryParam("skill") int skill) {
		return ManagerHelper.getapplicantsskillsmanger().conectapptoskill(applicant, skill);

	}
	
	@GET
	@Path("getallappskils")
	public List<Applicantsskills> getallappskils() {
		return ManagerHelper.getapplicantsskillsmanger().getallappskilss();

	}
	
	@GET
	@Path("deletappssklls")
	public Reply deletappssklls(@QueryParam("id") int id) {
		return ManagerHelper.getapplicantsskillsmanger().deletappssklls(id);

	}
	
	
	
	
}
