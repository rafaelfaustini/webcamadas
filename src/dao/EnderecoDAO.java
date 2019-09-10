package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
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
		ps.setString(3, _objeto.getBairro()); // Ele seta o parâmetro do terceiro ?
		ps.setString(3, _objeto.getBairro());
		
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

}
