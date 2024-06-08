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

import br.com.fiap.BO.ClienteBO;
import br.com.fiap.beans.Cliente;

@Path("/atendimento")
public class ClienteResource {
	
private ClienteBO clienteBO = new ClienteBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Cliente> selecionarRs () throws ClassNotFoundException, SQLException {
		return (ArrayList<Cliente>) clienteBO.selecionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Cliente cliente, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		clienteBO.inserirBo(cliente);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(cliente.getCpf());
		return Response.created(builder.build()) .build();
		
	}
	
	@PUT
	@Path("{/idFuncionario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarRs(Cliente cliente, @PathParam("cpf") String cpf) throws ClassNotFoundException, SQLException {
		clienteBO.atualizarBo(cliente);
		return Response.ok() .build();
	}
	
	public Response deletarRs(@PathParam("cpf") String cpf) throws ClassNotFoundException, SQLException {
		clienteBO.deletarBo(cpf);
		return Response.ok() .build();
	}


}
