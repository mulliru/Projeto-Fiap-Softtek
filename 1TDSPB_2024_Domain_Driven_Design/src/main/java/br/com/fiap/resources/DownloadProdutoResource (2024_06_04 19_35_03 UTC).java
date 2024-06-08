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

import br.com.fiap.BO.DownloadProdutoBO;
import br.com.fiap.beans.DownloadProduto;

@Path("/DownloadProduto")
public class DownloadProdutoResource {
	
private DownloadProdutoBO downloadProdutoBO = new DownloadProdutoBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<DownloadProduto> selecionarRs () throws ClassNotFoundException, SQLException {
		return (ArrayList<DownloadProduto>) downloadProdutoBO.selecionarBo();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response inserirRs(DownloadProduto downloadProduto, @Context UriInfo uriInfo ) throws ClassNotFoundException, SQLException {
		downloadProdutoBO.inserirBo(downloadProduto);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(downloadProduto.getIdProduto());
		return Response.created(builder.build()) .build();
		
	}
	
	@PUT
	@Path("{/idProduto}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarRs(DownloadProduto downloadProduto, @PathParam("idProduto")String idProduto) throws ClassNotFoundException, SQLException {
		downloadProdutoBO.atualizarBo(downloadProduto);
		return Response.ok() .build();
	}
	
	public Response deletarRs(@PathParam("idProduto") String idProduto ) throws ClassNotFoundException, SQLException {
		downloadProdutoBO.deletarBo(idProduto);
		return Response.ok() .build();
	}


}
