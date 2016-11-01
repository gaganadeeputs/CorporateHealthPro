package org.gagan.sap.messanger.resources;

import java.io.InputStream;
import java.net.URI;
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
import org.gagan.sap.messanger.model.UserDTO;
import org.gagan.sap.messanger.service.UserService;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

@Path("/users")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(value = { MediaType.APPLICATION_JSON, MediaType.TEXT_XML })
public class UserResource {

	final static Logger logger = Logger.getLogger(UserResource.class);
	UserService service = new UserService();

	@GET
	@Path("/{userType}")
	public List<UserDTO> getAllUsers(@QueryParam("startIndex") int startIndex, @QueryParam("length") int length,
			@PathParam("userType") String userType, @QueryParam("firstName") String firstName,
			@QueryParam("LastName") String lastName, @QueryParam("mobileNo") String mobileNo,
			@QueryParam("emailId") String emailId) {

		if (!StringUtil.isNullOrEmptyorBlankString(firstName) || !StringUtil.isNullOrEmptyorBlankString(lastName)
				|| !StringUtil.isNullOrEmptyorBlankString(mobileNo)
				|| !StringUtil.isNullOrEmptyorBlankString(emailId)) {
			return service.getMatchingUsers(firstName, lastName, mobileNo, emailId);

		}

		if (startIndex > 0 && length > 0) {
			return service.getAllUsersPaginated(startIndex, length, userType);
		}
		return service.getAllUsers(userType);
	}

	@GET
	@Path("/{userType}/{userId}")
	public UserDTO getUser(@PathParam("userId") int userId, @PathParam("userType") String userType) {
		UserDTO dto = service.getUser(userId, userType);
		return dto;

	}

	@POST
	@Path("/{userType}")
	public Response addUser(@PathParam("userType") String userType, UserDTO user, @Context UriInfo uriInfo) {
		user.setUserType(userType);
		service.addUser(user);
		URI uri = uriInfo.getAbsolutePathBuilder().path(String.valueOf(user.getUserId())).build();
		return Response.created(uri).status(Status.CREATED).entity(user).build();

	}

	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Path("{userId}/logos")
	public Response uploadUserLogo(@PathParam("userId") int userId,
			@FormDataParam("userLogo") InputStream uploadedInputStream,
			@FormDataParam("userLogo") FormDataContentDisposition fileDetail,
			@FormDataParam("userSignature") InputStream uploadedInputStream1,
			@FormDataParam("userSignature") FormDataContentDisposition fileDetail1) {

		
		String userLogoLocation = "/Users/i324562/Desktop/userLogo/" + userId + "."
				+ FileUtil.getFileExtension(fileDetail.getFileName());
		String userSignatureLocation = "/Users/i324562/Desktop/userSignature/" + userId + "."
				+ FileUtil.getFileExtension(fileDetail.getFileName());

		FileUtil.saveImage(userId, uploadedInputStream, fileDetail, userLogoLocation);
		FileUtil.saveImage(userId, uploadedInputStream1, fileDetail1, userSignatureLocation);
		service.setLocationsForUserId(userId,userLogoLocation,userSignatureLocation);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Path("/{userType}/{userId}")
	public Response updateUser(@PathParam("userType") String userType, @PathParam("userId") int userId, UserDTO user) {
		user.setUserId(userId);
		user.setUserType(userType);
		service.updateUser(user);
		return Response.status(Status.OK).build();

	}

	@DELETE
	@Path("/{userType}/{userId}")
	public Response deleteMessage(@PathParam("userId") int userId, @PathParam("userType") String userType) {
		service.deleteUser(userId, userType);
		return Response.status(Status.OK).build();
	}

}
