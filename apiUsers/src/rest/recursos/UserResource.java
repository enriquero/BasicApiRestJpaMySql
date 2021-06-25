package rest.recursos;

import java.util.List;

import dao.interfaces.CrudDaoInt;
import jakarta.annotation.PostConstruct;

//import java.util.List;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Request;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import model.User;


@Path("/user")
public class UserResource {

	@Context
	UriInfo uriInfo;
	@Context
	Request request;

	@Inject
	private CrudDaoInt<User> udao; // userDAO

	@PostConstruct
	public void postContruct() {
		udao.setClazz(User.class);
	}

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
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") Long id) {
		// User u = new User("Enrique", "Roman", "ejemplo@ejemplo", 31);
		User u = udao.get(id);
		if (id != 0) {
			return Response.ok().entity(u).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("El id no puede ser 0").build();
		}
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, User user) {
		// TODO falla
		User aux = udao.get(id);
		if (aux != null) {
			udao.update(user);
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).entity("[]").build();
		}
	}

	@DELETE
	@Path("{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response delete(@PathParam("id") Long id) {
		User aux = udao.get(id);
		if (aux != null) {
			udao.delete(aux);
			return Response.noContent().build();
		} else {
			String mensaje = "No existe el usuario con ese id";
			return Response.status(Response.Status.NOT_FOUND).entity(mensaje).build();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response list() {
		List<User> ulist = (List<User>) udao.findAll();
		return Response.status(200).entity(ulist).build();
	}

	private boolean valide(User user) {
		// TODO deberia validar algo
		return true;
	}
}
