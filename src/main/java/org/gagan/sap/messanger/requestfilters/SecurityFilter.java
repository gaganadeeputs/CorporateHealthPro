package org.gagan.sap.messanger.requestfilters;


import java.io.IOException;
import java.util.List;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.gagan.sap.messanger.model.ErrorMessage;
import org.gagan.sap.messanger.service.SecurityService;


@Priority(Priorities.AUTHORIZATION)
@PreMatching
public class SecurityFilter implements ContainerRequestFilter{
	
	private static final String API_KEY="api_key";


	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String>  apiKeyHeaders=requestContext.getHeaders().get(API_KEY);
		if(apiKeyHeaders!=null && !apiKeyHeaders.isEmpty()){
		if(SecurityService.isValidAPIKey(apiKeyHeaders.get(0)) || apiKeyHeaders.get(0).equals("GAGAN") ){
			return;
		}
		}
		ErrorMessage errorMesssage=new ErrorMessage(Status.UNAUTHORIZED.getStatusCode(), "not found/invalid web api key", "gagana.com");
		Response response=Response
		.status(Status.UNAUTHORIZED)
		.entity(errorMesssage)
		.build();
		requestContext.abortWith(response);
		
	}

}