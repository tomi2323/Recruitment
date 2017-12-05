package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Applicants;
import entity.Recrutingmanager;
import managers.ManagerHelper;

@Path("/recrutservice")
public class Recrutingmanagerservice {

	
	
	
	@GET
	@Path("get")
	public Recrutingmanager get(@QueryParam("id") int id) {
		return managers.ManagerHelper.getRecrutingmanager().get(id);

	}
	
	@GET
	@Path("getall")
	public List<Recrutingmanager> getApplicants() {
		return managers.ManagerHelper.getRecrutingmanager().getall();

	}	
	
	
	
}
