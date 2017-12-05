package services;

import javax.mail.MessagingException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.Reply;
import entity.Users;
import managers.ManagerHelper;

@Path("/userservice")
public class Userservice {

	
	@GET
	@Path("user")
	public Users getuser(@QueryParam("id") int id) {
		
		return ManagerHelper.getusermanager().get(id);
	}
	@GET
	@Path("deleteUser")
	public Reply deleteUser(@QueryParam("id")int id){
		return ManagerHelper.getusermanager().deleteUser(id);
	}
	@GET
	@Path("getUserByUsernameAndPass")
	public Users getUserByUsernameAndPass (@QueryParam("username") String username, @QueryParam("password") String password) {
		if (username.equals(username)&&password.equals(password)) {
			return ManagerHelper.getusermanager().getUserByUsernameAndPass(username, password);	
	}else{
		return null;	
	}
		
	}
	@GET
	@Path("sendLink")
	
	public Reply sendLink(@QueryParam("id") int id) throws MessagingException {
		System.out.println("in service");
		return  ManagerHelper.getusermanager().sendLink(id);
		
	}

	}

