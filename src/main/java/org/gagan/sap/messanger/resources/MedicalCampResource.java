package org.gagan.sap.messanger.resources;

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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.gagan.sap.messanger.model.MedicalCampDTO;
import org.gagan.sap.messanger.model.MedicalCampDetailCountByStatusDTO;
import org.gagan.sap.messanger.model.MedicalCampDetailDTO;
import org.gagan.sap.messanger.service.MedicalCampDetailService;
import org.gagan.sap.messanger.service.MedicalCampService;

@Path("/")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON })
public class MedicalCampResource {

	MedicalCampService service = new MedicalCampService();

	@GET
	@Path("{campId}")
	public Response getMedicalCamp(@PathParam("campId") int campId) {

		MedicalCampDTO medicalCampDTO = service.getMedicalCamp(campId);
		return Response.status(Status.CREATED).entity(medicalCampDTO).build();
	}

	@GET
	public List<MedicalCampDTO> getAllMedicalCampsForCompany(@PathParam("companyId") int companyId,
			@QueryParam("start") int start, @QueryParam("length") int length) {
		if (start > 0 && length > 0) {
			return service.getAllMedicalCampsPaginatedForCompany(companyId, start, length);
		}

		return service.getAllMedicalCampsForCompany(companyId);
	}
	
	@GET
	@Path("{campId}/countByStatus")
	public List<MedicalCampDetailCountByStatusDTO> getAllMedicalCampsForCompany(@PathParam("campId") int campId){
		return service.getMedicalCampConsolidatedReport(campId);
	}
	


	@POST
	public Response createMedicalCamp(@PathParam("companyId") int companyId, MedicalCampDTO medicalCampDTO) {

		MedicalCampDTO createdMedicalCampDTO = service.createMedicalCamp(companyId, medicalCampDTO);
		return Response.status(Status.CREATED).entity(createdMedicalCampDTO).build();
	}

	@PUT
	@Path("{campId}")
	public Response updateMedicalCamp(@PathParam("campId") int campId, MedicalCampDTO medicalCampDTO) {
		service.updateMedicalCamp(campId, medicalCampDTO);
		return Response.status(Status.OK).build();
	}

	@DELETE
	@Path("{campId}")
	public Response deleteMedicalCamp(@PathParam("campId") int medicalCampId) {

		service.deleteMedicalCamp(medicalCampId);
		return Response.status(Status.OK).build();
	}
	
	@Path("{medicalCampId}/medicalCampDetails")
	
	public MedicalCampDetailResource getMedicalCampDetailResource() {

	   return new MedicalCampDetailResource();
	}
	
	
	@GET
	@Path("{medicalCampId}/users/{userId}")
	public Response getMedicalCampDetailForUserId(@PathParam("medicalCampId") int medicalCampId,@PathParam("userId") int userId){
		MedicalCampDetailService service = new MedicalCampDetailService();
		MedicalCampDetailDTO medicalCampDetailDTO = service.getMedicalCampDetailForCampIdAndUserId(medicalCampId,userId);
		return Response.status(Status.OK).entity(medicalCampDetailDTO).build();
	}

		
	

}
