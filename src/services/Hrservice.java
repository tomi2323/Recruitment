package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Hr;

import managers.ManagerHelper;

@Path("/Hrservice")
public class Hrservice {

	@GET
	@Path("hr")
	public Hr getuser(@QueryParam("id") int id) {

		return ManagerHelper.getHrManager().get(id);
	}

	
}
