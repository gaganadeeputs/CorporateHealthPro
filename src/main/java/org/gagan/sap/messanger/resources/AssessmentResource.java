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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.gagan.sap.messanger.model.AssesmentDTO;
import org.gagan.sap.messanger.service.AssessmentService;

@Path("/assessments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON })
public class AssessmentResource {

	final static Logger logger = Logger.getLogger(UserResource.class);
	AssessmentService service = new AssessmentService();

	@GET
	public List<AssesmentDTO> getAllAssessments() {
		return service.getAllAssessments();
	}

	@GET
	@Path("/{assessmentId}")
	public AssesmentDTO getAssessment(@PathParam("assessmentId") int assessmentId) {
		AssesmentDTO dto = service.getAssessment(assessmentId);
		return dto;

	}

	@POST
	public Response addAssessment( AssesmentDTO assesmentDTO) {
		AssesmentDTO newAssessmentDTO	=service.addAssessment(assesmentDTO);
		return Response.status(Status.CREATED).entity(newAssessmentDTO).build();

	}


	@PUT
	@Path("/{assessmentId}")
	public Response updateUser(@PathParam("assessmentId") int assessmentId,AssesmentDTO assesmentDTO) {
		assesmentDTO.setId(assessmentId);
        service.updateAssessment(assesmentDTO);
		return Response.status(Status.OK).build();

	}

	@DELETE
	@Path("/{assessmentId}")
	public Response deleteMessage(@PathParam("/{assessmentId}") int assessmentId) {
		service.deleteAssessment(assessmentId);
		return Response.status(Status.OK).build();
	}

	@Path("/{assessmentId}/assessmentQuestions")
	public AssessmentQuestionResource sssessmentQuestionResource(@PathParam("assessmentId") int assessmentId) {
		return new AssessmentQuestionResource();
	}

}
