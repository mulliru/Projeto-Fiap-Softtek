package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.DownloadProduto;

import br.com.fiap.conexoes.ConexaoFactory;

public class DownloadProdutoDAO {
	
	public Connection minhaConexao;
	
	public DownloadProdutoDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
		
		public String inserir(DownloadProduto downloadProduto) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Insert into T_DownloadProduto values (?, ?, ?)");
			
					stmt.setString(1, downloadProduto.getIdProduto());
					stmt.setString(2, downloadProduto.getHrsAquisicao());
					stmt.setString(3, downloadProduto.getDiaAquisicao());
					stmt.execute();
					stmt.close();
		
		return "Atendimento cadastrado com sucesso";
  
	}
		
		// Delete
		public String deletar(String idProduto) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Delete from T_DownloadProduto where IDPRODUTO = ?");
				stmt.setString(1, idProduto);
				stmt.execute();
				stmt.close();		
			return "Deletado com Sucesso!";
		}
	// UpDate 
		public String atualizar(DownloadProduto downloadProduto) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					(" Update T_DownloadProduto set IDPRODUTO = ?, HRSAQUISICAO = ?, "
							+ "  DIAAQUISICAO = ? where CPF = ?");
					stmt.setString(1, downloadProduto.getIdProduto());
					stmt.setString(2, downloadProduto.getHrsAquisicao());
					stmt.setString(3, downloadProduto.getDiaAquisicao());
					stmt.executeUpdate();
					stmt.close();	
			return "Atualizado com Sucesso!";
		}
		// Select 
		public List<DownloadProduto> selecionar() throws SQLException{
			List<DownloadProduto> listaDownloadProduto = new ArrayList<DownloadProduto>();
			PreparedStatement stmt = minhaConexao.prepareStatement
					("SELECT * FROM T_DownloadProduto");
			
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					DownloadProduto downloadProduto = new DownloadProduto();
					downloadProduto.setIdProduto(rs.getString(1));;
					downloadProduto.setHrsAquisicao(rs.getString(2));
					downloadProduto.setDiaAquisicao(rs.getString(3));

					listaDownloadProduto.add(downloadProduto);
				}		
			return listaDownloadProduto;		
		}
}
