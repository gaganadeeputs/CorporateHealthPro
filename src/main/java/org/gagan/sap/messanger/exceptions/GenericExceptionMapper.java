package org.gagan.sap.messanger.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.gagan.sap.messanger.model.ErrorMessage;
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable exception) {
		ErrorMessage errorMessage=new ErrorMessage(500, exception.getMessage(), "corporateHealthPro.com");
		return Response.status(Status.INTERNAL_SERVER_ERROR)
				        .entity(errorMessage)
				        .build();
	}

}
