package br.com.fiap.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Cliente;

import br.com.fiap.conexoes.ConexaoFactory;

public class ClienteDAO {
	
	public Connection minhaConexao;
	
	public ClienteDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
		
		public String inserir(Cliente cliente) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Insert into T_Cliente values (?, ?, ?)");
			
					stmt.setString(1, cliente.getName());
					stmt.setString(2, cliente.getCpf());
					stmt.setString(3, cliente.getRg());
					stmt.setString(4, cliente.getEmail());
					stmt.setInt(5, cliente.getCelular());
					stmt.execute();
					stmt.close();
		
		return "Atendimento cadastrado com sucesso";
  
	}
		
		// Delete
		public String deletar(String cpf) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					("Delete from T_Cliente where CPF = ?");
				stmt.setString(1, cpf);
				stmt.execute();
				stmt.close();		
			return "Deletado com Sucesso!";
		}
	// UpDate 
		public String atualizar(Cliente cliente) throws SQLException {
			PreparedStatement stmt = minhaConexao.prepareStatement
					(" Update T_Cliente set NAME = ?, CPF = ?, "
							+ "  RG = ?, EMAIL = ?, CELULAR = ? where CPF = ?");
					stmt.setString(1, cliente.getName());
					stmt.setString(2, cliente.getCpf());
					stmt.setString(3, cliente.getRg());
					stmt.setString(4, cliente.getEmail());
					stmt.setInt(5, cliente.getCelular());
					stmt.executeUpdate();
					stmt.close();	
			return "Atualizado com Sucesso!";
		}
		// Select 
		public List<Cliente> selecionar() throws SQLException{
			List<Cliente> listaCliente = new ArrayList<Cliente>();
			PreparedStatement stmt = minhaConexao.prepareStatement
					("SELECT * FROM T_Cliente");
			
				ResultSet rs = stmt.executeQuery();
				
				while(rs.next()) {
					Cliente cliente = new Cliente();
					cliente.setName(rs.getString(1));;
					cliente.setCpf(rs.getString(2));
					cliente.setRg(rs.getString(3));
					cliente.setEmail(rs.getString(3));
					cliente.setCelular(rs.getInt(3));
					listaCliente.add(cliente);
				}		
			return listaCliente;		
		}
}
