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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.gagan.sap.messanger.database.util.FileUtil;
import org.gagan.sap.messanger.model.MedicalCampDetailDTO;
import org.gagan.sap.messanger.service.MedicalCampDetailService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/medicalCampDetails")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON })
public class MedicalCampDetailResource {

	MedicalCampDetailService service = new MedicalCampDetailService();

	@GET
	@Path("/{medicalCampDetailId}")
	public Response getMedicalCamp(@PathParam("medicalCampDetailId") int medicalCampDetailId) {

		MedicalCampDetailDTO medicalCampDetailDTO = service.getMedicalCampDeatil(medicalCampDetailId);
		return Response.status(Status.OK).entity(medicalCampDetailDTO).build();
	}
	

	
	@GET
	public List<MedicalCampDetailDTO> getAllMedicalCampDetailsForCampID(@PathParam("medicalCampId") int medicalCampId,
			@QueryParam("start") int start, @QueryParam("length") int length) {
		if (start > 0 && length > 0) {
			return service.getAllMedicalCampDetailsPaginated(medicalCampId, start, length);
		}

		return service.getAllMedicalCampDetails(medicalCampId);
	}
	
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("/{medicalCampDetailId}/logo")
	public Response uploadCompaniesLogo(@PathParam("medicalCampDetailId") int campDetailId,
			@FormDataParam("ecgImage") InputStream uploadedInputStream,
			@FormDataParam("ecgImage") FormDataContentDisposition fileDetail) {
		String ecgImageLocation = "/Users/i324562/Desktop/ecg/" + campDetailId + "."
				+ FileUtil.getFileExtension(fileDetail.getFileName());
		FileUtil.saveImage(campDetailId, uploadedInputStream, fileDetail, ecgImageLocation);
		return Response.status(Status.CREATED).build();
	}


	@POST
	public Response createMedicalCamp(@PathParam("medicalCampId") int medicalCampId, MedicalCampDetailDTO campDetailDTO) {

		MedicalCampDetailDTO createdMedicalCampDetailDTO = service.createMedicalCampDetail(medicalCampId, campDetailDTO);
		return Response.status(Status.CREATED).entity(createdMedicalCampDetailDTO).build();
	}

	@PUT
	@Path("/{medicalCampDetailId}")
	public Response updateMedicalCamp(@PathParam("medicalCampDetailId") int medicalCampDetailId, MedicalCampDetailDTO campDetailDTO) {
		service.updateMedicalCampDetail(medicalCampDetailId, campDetailDTO);
		return Response.status(Status.OK).build();
	}

	@DELETE
	@Path("/{medicalCampDetailId}")
	public Response deleteMedicalCamp(@PathParam("medicalCampDetailId") int medicalCampDetailId) {

		service.deleteMedicalCampDetail(medicalCampDetailId);
		return Response.status(Status.OK).build();
	}



}
