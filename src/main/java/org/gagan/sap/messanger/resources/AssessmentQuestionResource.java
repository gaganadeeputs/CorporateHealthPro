package org.gagan.sap.messanger.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.gagan.sap.messanger.model.AssesmentQuestionDTO;
import org.gagan.sap.messanger.service.AsssessmentQuestionService;

@Path("/assessmentQuestions")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON })
public class AssessmentQuestionResource {
	final static Logger logger = Logger.getLogger(UserResource.class);
	AsssessmentQuestionService service = new AsssessmentQuestionService();

	@GET
	public List<AssesmentQuestionDTO> getAllQuestions(@PathParam("assessmentId") int assessmentId){
		return service.getAllQuestions(assessmentId);
	}

}
