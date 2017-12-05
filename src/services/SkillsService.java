package services;

import java.util.List;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Skills;


@Path("/skills")
public class SkillsService {

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("get")
	public Skills getSkills(@QueryParam("id") int id) {
		return managers.ManagerHelper.getskillsManager().get(id);
	}

	@GET
	@Path("getByName")
	public List<Skills> getByName(@QueryParam("technology") String technology) {
		return managers.ManagerHelper.getskillsManager().getByName(technology);
	}
	
	@GET
	@Path("getall")
	public List<Skills> getall() {
		return managers.ManagerHelper.getskillsManager().getByall();
	}

}
