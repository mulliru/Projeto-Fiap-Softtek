package br.com.fiap.resources;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.BO.LoginBO;
import br.com.fiap.beans.Login;

@Path("/login")
public class LoginResource {
	
private LoginBO loginBO = new LoginBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Login> selecionarRs () throws ClassNotFoundException, SQLException {
		return (ArrayList<Login>) loginBO.selecionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Login login, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		loginBO.inserirBo(login);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(login.getEmail());
		return Response.created(builder.build()) .build();
		
	}
	
	@PUT
	@Path("{/email}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarRs(Login login, @PathParam("Email") String Email) throws ClassNotFoundException, SQLException {
		loginBO.atualizarBo(login);
		return Response.ok() .build();
	}
	
	public Response deletarRs(@PathParam("Email") String Email) throws ClassNotFoundException, SQLException {
		loginBO.deletarBo(Email);
		return Response.ok() .build();
	}


}
