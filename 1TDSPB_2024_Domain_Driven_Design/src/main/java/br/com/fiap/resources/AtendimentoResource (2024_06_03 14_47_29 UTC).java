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

import br.com.fiap.BO.AtendimentoBO;
import br.com.fiap.beans.Atendimento;

@Path("/atendimento")
public class AtendimentoResource {
	
private AtendimentoBO atendimentoBO = new AtendimentoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Atendimento> selecionarRs () throws ClassNotFoundException, SQLException {
		return (ArrayList<Atendimento>) atendimentoBO.selecionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Atendimento atendimento, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		atendimentoBO.inserirBo(atendimento);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(atendimento.getIdFuncionario()));
		return Response.created(builder.build()) .build();
		
	}
	
	@PUT
	@Path("{/idAtendimento}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarRs(Atendimento atendimento, @PathParam("idAtendimento") int idAtendimento) throws ClassNotFoundException, SQLException {
		atendimentoBO.atualizarBo(atendimento);
		return Response.ok() .build();
	}
	
	public Response deletarRs(@PathParam("idAtendimento") int idAtendimento) throws ClassNotFoundException, SQLException {
		atendimentoBO.deletarBo(idAtendimento);
		return Response.ok() .build();
	}


}
