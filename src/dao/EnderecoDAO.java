package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Endereco;


public class EnderecoDAO implements EnderecoInDAO {
	
	private Connection conexao;

	public EnderecoDAO(Connection _conn) {
		this.conexao = _conn;
	}

	@Override
	public void Inserir(Endereco _objeto) throws SQLException {
		String SQL = "insert into endereco (logradouro, numero, bairro, cidade, estado) values (?, ?, ?, ?, ?s)"; // Os ? são parâmetros para o sql
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getLogradouro()); // Ele seta o parâmetro do primeiro ?
		ps.setInt(2, _objeto.getNumero()); // Ele seta o parâmetro do segundo ?
		ps.setString(3, _objeto.getCidade()); // Ele seta o parâmetro do terceiro ?
		ps.setString(4, _objeto.getBairro());
		ps.setString(4, _objeto.getEstado());
		
		ps.execute(); // Executa a query

	}

	@Override
	public List<Endereco> listarTodos() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Atualizar(Endereco _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Endereco buscarPorId(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Endereco> listarEnderecosPorPessoa(int _idPessoa) throws SQLException {
		ResultSet rs = null;
		List<Endereco> enderecos = new ArrayList<Endereco>();
		String SQL = "SELECT id, logradouro, numero, bairro, cidade, estado from endereco where pessoa_id = ?";
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		ps.setInt(1, _idPessoa); 
		
		rs = ps.executeQuery();
		
		while (rs.next()) {
			int id = rs.getInt(1);
			String logradouro = rs.getString(2);
			int numero = rs.getInt(3);
			String bairro = rs.getString(4);
			String cidade = rs.getString(5);
			String estado = rs.getString(6);
			
			Endereco end = new Endereco(id, logradouro, numero, bairro, cidade, estado);
			
			enderecos.add(end);
		}
		
		return enderecos;
	}

}
