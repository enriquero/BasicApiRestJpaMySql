package rest.recursos;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import dao.impl.UserDao;
import jakarta.inject.Inject;
import model.User;

@Path("/user")
public class UserResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Inject
	private UserDao udao;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(User user) {
		if (valide(user)) { // podría validar si ya existe el usuario
			udao.create(user);
			return Response.status(Response.Status.CREATED).build();
		} else {
			return Response.status(Response.Status.CONFLICT).build();
		}
	}

	@GET
	// @Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {
		return "Hola...";
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update() {
		return null;
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response delete() {
		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> list() {
		return null;
	}

	private boolean valide(User user) {
		// TODO deberia validar algo
		return true;
	}
}
