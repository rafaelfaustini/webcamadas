package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDAO implements PessoaInDAO {
	
	private Connection conexao;
	
	public PessoaDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Pessoa _objeto) throws SQLException {
		String SQL = "insert into pessoa (nome, telefone, email) values (?, ?, ?)"; // Os ? são parâmetros para o sql
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome()); // Ele seta o parâmetro do primeiro ?
		ps.setString(2, _objeto.getTelefone()); // Ele seta o parâmetro do segundo ?
		ps.setString(3, _objeto.getEmail()); // Ele seta o parâmetro do terceiro ?
		
		
		ps.execute(); // Executa a query

	}

	@Override
	public List<Pessoa> listarTodos() throws SQLException {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, telefone, email from pessoa";
				
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery();
		
		while(rs.next()) { // Percorre pela tabela
			Pessoa p = new Pessoa();
			
			// Configurando os atributos da pessoa a ser adicionada a lista
			p.setId(rs.getInt(1));
			p.setNome(rs.getString(2));
			p.setTelefone(rs.getString(3));
			p.setEmail(rs.getString(4)); 
			// Get baseado no tipo da coluna (getInt, getString) e o inteiro é o número da coluna na query
			
			pessoas.add(p); // A pessoa é adicionada a lista de pessoas
		}
		
		return pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean Atualizar(Pessoa _objeto) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pessoa buscarPorId(int _id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
