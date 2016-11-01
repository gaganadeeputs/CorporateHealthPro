package org.gagan.sap.messanger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.gagan.sap.messanger.service.CompanyService;
import org.gagan.sap.messanger.service.UserService;


@Path("/dashBoard")
@Consumes( MediaType.APPLICATION_JSON)
@Produces( value={MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON})
public class DashBoardResource {
	
	@GET
	@Path("/companies/count")
	public Long getCompaniesCount() {
		CompanyService service=new CompanyService();
		Long count = service.getCompaniesCount();
		return count;
	}
	

	@GET
	@Path("/users/count")
	public Long getUsersCount() {
		UserService service=new UserService();
		Long count  = service.getUsersCount();
		return count;
	}}
