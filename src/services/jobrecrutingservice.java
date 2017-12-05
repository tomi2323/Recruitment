package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.ApplicantsJobs;
import entity.Jobrecruting;
import entity.Reply;
import managers.ManagerHelper;

@Path("/jobrecruting")
public class jobrecrutingservice {

	@GET
	@Path("get")
	public Jobrecruting get(@QueryParam("id") int id) {
		return managers.ManagerHelper.getJobrecruting().get(id);

	}

	@GET
	@Path("getalljobmanger")
	public List<Jobrecruting> getJobrecruting() {
		return managers.ManagerHelper.getJobrecruting().getalljobmanger();

	}
	
	@GET
	@Path("getjobbymanger")
	public List<Jobrecruting> getJobymangaer(@QueryParam("job") int job) {
		return managers.ManagerHelper.getJobrecruting().getjobbymanager(job);

	}
	@GET
	@Path("conectjobtomanger")
	public Jobrecruting createApplicantsJobs(
			@QueryParam("job") int job,@QueryParam("manger") int manger) {
		
		return managers.ManagerHelper.getJobrecruting().conectjobtomanger(job, manger);
	}
	
	@GET
	@Path("deletejobsmanager")
	public Reply deletjobskill(@QueryParam("id") int id) {
		return ManagerHelper.getJobrecruting().deletJobsmaneger(id);

	}
	
	
}
