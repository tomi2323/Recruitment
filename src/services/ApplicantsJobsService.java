package services;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import entity.ApplicantsJobs;
import entity.Reply;


@Path("/applicantsJobs")
public class ApplicantsJobsService {
	

		@GET
		@Path("get")
		public ApplicantsJobs get(@QueryParam("id") int id) {
			return managers.ManagerHelper.getApplicantsJobsManager().get(id);

		}

		@GET
		@Path("getAllApplicantsJobs")
		public List<ApplicantsJobs> getAllEmployeeProject() {
			return managers.ManagerHelper.getApplicantsJobsManager().getAllApplicantsJobs();

		}
		@GET
		@Path("createApplicantsJobs")
		public ApplicantsJobs createApplicantsJobs(
				@QueryParam("applicantsid") int applicantsid,@QueryParam("jobsid") int jobsid) {
			
			return managers.ManagerHelper.getApplicantsJobsManager().createApplicantsJobs(applicantsid, jobsid);
		}
		@GET
		@Path("updateApplicantsJobs")
		public Reply updatetEmployeeProject(@QueryParam("id") int id,
				@QueryParam("applicantsid") int applicantsid,@QueryParam("jobsid") int jobsid) {
			
			return managers.ManagerHelper.getApplicantsJobsManager().updateApplicantsJobs(id, applicantsid, jobsid);
		}

		@GET
		@Path("deleteApplicantsJobs")
		public Reply deleteEmployeeProject(@QueryParam("id") int id) {
			return managers.ManagerHelper.getApplicantsJobsManager().deleteApplicantsJobs(id);
	}
	}

