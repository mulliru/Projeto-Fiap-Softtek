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

import br.com.fiap.BO.CepBO;
import br.com.fiap.beans.Cep;

@Path("/cep")
public class CepResource {
	
private CepBO cepBO = new CepBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cep> selecionarRs () throws ClassNotFoundException, SQLException {
		return (ArrayList<Cep>) cepBO.selecionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Cep cep, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		cepBO.inserirBo(cep);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(cep.getPais());
		return Response.created(builder.build()) .build();
		
	}
	
	@PUT
	@Path("{/Cep}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarRs(Cep cep, @PathParam("Cep") String Cep) throws ClassNotFoundException, SQLException {
		cepBO.atualizarBo(cep);
		return Response.ok() .build();
	}
	
	public Response deletarRs(@PathParam("Cep") String Cep) throws ClassNotFoundException, SQLException {
		cepBO.deletarBo(Cep);
		return Response.ok() .build();
	}


}
