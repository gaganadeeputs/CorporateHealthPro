package org.gagan.sap.messanger.resources;

import java.io.InputStream;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.gagan.sap.messanger.database.util.FileUtil;
import org.gagan.sap.messanger.database.util.StringUtil;
import org.gagan.sap.messanger.model.CompanyDTO;
import org.gagan.sap.messanger.model.UserDTO;
import org.gagan.sap.messanger.service.CompanyService;
import org.gagan.sap.messanger.service.UserService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/companies")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON})
public class CompanyResource {

	final static Logger logger = Logger.getLogger(UserResource.class);
	CompanyService service = new CompanyService();

	@GET
	public List<CompanyDTO> getALlCompanies(@QueryParam("startIndex") int startIndex,
			@QueryParam("length") int length,@QueryParam("companyName") String companyName) {
		if(!StringUtil.isNullOrEmptyorBlankString(companyName))
		{
			return  service.getAllCompaniesWithMatchingName(companyName);
		}
		if (startIndex > 0 && length > 0) {
			return service.getCompaniesPaginated(startIndex, length);
		}
		return service.getALlCompanies();
	}

	@GET
	@Path("{companyId}")
	public CompanyDTO getCompany(@PathParam("companyId") int companyId) {
		return service.getCompany(companyId);

	}
	
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("{companyId}/logos")
	public Response uploadCompaniesLogo(@PathParam("companyId") int companyId,
			@FormDataParam("companyLogo") InputStream uploadedInputStream1,
			@FormDataParam("companyLogo") FormDataContentDisposition fileDetail1,
			@FormDataParam("hrlogo") InputStream uploadedInputStream2,
			@FormDataParam("hrlogo") FormDataContentDisposition fileDetail2,
			@FormDataParam("hrSignature") InputStream uploadedInputStream3,
			@FormDataParam("hrSignature") FormDataContentDisposition fileDetail3) {

		String companyLogoLocation = "/Users/i324562/Desktop/companieslogo/" + companyId + "."
				+ FileUtil.getFileExtension(fileDetail1.getFileName());
		String hrLogoLocation = "/Users/i324562/Desktop/hrlogo/" + companyId + "."
				+ FileUtil.getFileExtension(fileDetail2.getFileName());
		String hrSignatureLocation = "/Users/i324562/Desktop/hrSignature/" + companyId + "."
				+ FileUtil.getFileExtension(fileDetail1.getFileName());
		FileUtil.saveImage(companyId, uploadedInputStream1, fileDetail1, companyLogoLocation);
		FileUtil.saveImage(companyId, uploadedInputStream2, fileDetail2, hrLogoLocation);
		FileUtil.saveImage(companyId, uploadedInputStream3, fileDetail3, hrSignatureLocation);
		service.setImageLocationsForCompanyId(companyId,companyLogoLocation,hrLogoLocation,hrSignatureLocation);
		return Response.status(Status.CREATED).build();
	}

	
	@PUT
	public Response updateCompany(CompanyDTO company,
			@Context UriInfo uriInfo,
			@PathParam("companyId") int companyId) {
		 service.updateCompany(companyId,company);
		return Response.status(Status.OK).build();

	}
	
	@POST
	public Response addCompany(CompanyDTO company) {
		CompanyDTO companyDTO = service.addCompany(company);
		return Response.status(Status.CREATED).entity(companyDTO).build();

	}

	@DELETE
	@Path("{companyId}")
	public Response deleteCompany(@PathParam("companyId") int companyId) {
		service.deleteCompany(companyId);
		return Response.status(Status.OK).build();
	}

	
	
	@Path("{companyId}/medicalCamps/")
	public MedicalCampResource getCompany() {
		return  new MedicalCampResource();

	}
	
	@GET
	@Path("{companyId}/users/")
	public List<UserDTO> getAllUsers(@PathParam("companyId") int companyId,
			@QueryParam("startIndex") int startIndex,
			@QueryParam("length") int length,
			@PathParam("userType") String userType) {
		UserService userService = new UserService();
		if (startIndex > 0 && length > 0) {
			return userService.getAllUsersPaginatedForCompany(companyId,startIndex,length);
		}
		return userService.getAllUsersForCompany(companyId);
	}
	
	
	
	

}
