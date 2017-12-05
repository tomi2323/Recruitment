package services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Jobs;
import entity.Reply;
import managers.ManagerHelper;


@Path("/jobs")
public class JobsService {

	@GET
	@Path("get")
	public Jobs getJobs(@QueryParam("id") int id) {
		return managers.ManagerHelper.getjobsManager().get(id);
	}

	@GET
	@Path("getByName")
	public List<Jobs> getByName(@QueryParam("job") String job) {
		return managers.ManagerHelper.getjobsManager().getByName(job);
	}
	
	@GET
	@Path("getall")
	public List<Jobs> getall() {
		return managers.ManagerHelper.getjobsManager().getall();
	}
	
	@GET
	@Path("createjob")
	public Jobs createjob(@QueryParam("description") String description,
			@QueryParam("yearsofexperience") String yearsofexperience,@QueryParam("position")
	String position,@QueryParam("archive") String archive,@QueryParam("name") String name) {
		return managers.ManagerHelper.getjobsManager().createjob(description, yearsofexperience, position, archive, name);
	}
	
	@GET
	@Path("updateJob")
	public Reply updateJob(@QueryParam("id")int id,@QueryParam("description") String description,
			@QueryParam("yearsofexperience") String yearsofexperience ,@QueryParam("position") String position,@QueryParam("name") String name){
				return ManagerHelper.getjobsManager().updateJob(id, description, yearsofexperience , position,name );

		 
	}


}