package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Applicantsskills;
import entity.Jobssklls;
import entity.Reply;
import managers.ManagerHelper;



@Path("/jobsskllsservice")
public class Jobsskllsservice {

	
	@GET
	@Path("get")
	public Jobssklls getjobskills(@QueryParam("id") int id) {
		return ManagerHelper.getJobsskllsmanager().get(id);

	}
	
	
	@GET
	@Path("getskillsbyjob")
	public List<Jobssklls> getskillsbyjob(@QueryParam("job") int job) {
		return ManagerHelper.getJobsskllsmanager().getskillsbyjob(job);

	}
	
	@GET
	@Path("deletejobskill")
	public Reply deletjobskill(@QueryParam("id") int id) {
		return ManagerHelper.getJobsskllsmanager().deletJobssklls(id);

	}
	
	
	@GET
	@Path("getalljobskils")
	public List<Jobssklls> getallappskils() {
		return ManagerHelper.getJobsskllsmanager().getalljobssklls();

	}
	
	
	@GET
	@Path("conectjobtoskill")
	public Jobssklls conectapptoskill(@QueryParam("job") int job,@QueryParam("skill") int skill) {
		return ManagerHelper.getJobsskllsmanager().conectjobtoskill(job, skill);

	}
	
}
