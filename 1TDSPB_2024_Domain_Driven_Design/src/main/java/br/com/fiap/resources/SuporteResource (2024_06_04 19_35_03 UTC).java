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

import br.com.fiap.BO.SuporteBO;
import br.com.fiap.beans.Suporte;

@Path("/atendimento")
public class SuporteResource {
	
private SuporteBO suporteBO = new SuporteBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Suporte> selecionarRs () throws ClassNotFoundException, SQLException {
		return (ArrayList<Suporte>) suporteBO.selecionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(Suporte suporte, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		suporteBO.inserirBo(suporte);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(suporte.getIdAtendimento()));
		return Response.created(builder.build()) .build();
		
	}
	
	@PUT
	@Path("{/idFuncionario}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarRs(Suporte suporte, @PathParam("idAtendimento") int idAtendimento) throws ClassNotFoundException, SQLException {
		suporteBO.atualizarBo(suporte);
		return Response.ok() .build();
	}
	
	public Response deletarRs(@PathParam("idAtendimento") int idAtendimento) throws ClassNotFoundException, SQLException {
		suporteBO.deletarBo(idAtendimento);
		return Response.ok() .build();
	}


}
