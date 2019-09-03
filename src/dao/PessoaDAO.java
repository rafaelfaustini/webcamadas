package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pessoa;

public class PessoaDAO implements PessoaInDAO { // Vai lidar com a parte de banco de dados referentes a pessoa
	
	private Connection conexao;
	
	public PessoaDAO(Connection _conn) {
		this.conexao = _conn;
	}
	
	@Override
	public void Inserir(Pessoa _objeto) throws SQLException {
		String SQL = "insert into pessoa (nome, tel, email) values (?, ?, ?)"; // Os ? s�o par�metros para o sql
		
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setString(1, _objeto.getNome()); // Ele seta o par�metro do primeiro ?
		ps.setString(2, _objeto.getTelefone()); // Ele seta o par�metro do segundo ?
		ps.setString(3, _objeto.getEmail()); // Ele seta o par�metro do terceiro ?
		
		
		ps.execute(); // Executa a query

	}

	@Override
	public List<Pessoa> listarTodos() throws SQLException {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		ResultSet rs = null;
		
		String SQL = "select id, nome, tel, email from pessoa";
				
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		rs = ps.executeQuery(); // Retorna um ResultSet com os resultados diferentemente do execute() que retorna apenas booleano
		
		while(rs.next()) { // Percorre a tabela enquanto tiverem registros
			// Caso tenham 5 pessoas cadastradas, esse while rodar� 5 vezes (No caso nessa query)
			Pessoa p = new Pessoa();
			
			// Configurando os atributos da pessoa a ser adicionada a lista
			p.setId(rs.getInt(1)); 
			p.setNome(rs.getString(2)); // rs.getString(2)-> vai retornar o nome da pessoa do banco de dados
			p.setTelefone(rs.getString(3));
			p.setEmail(rs.getString(4)); 
			// Get baseado no tipo da coluna (getInt, getString) e o inteiro � o n�mero da coluna na query
			
			pessoas.add(p); // A pessoa � adicionada a lista de pessoas
		}
		
		return pessoas;
	}

	@Override
	public Boolean Excluir(int _id) throws SQLException {
		boolean rs = false;
		
		String SQL = "delete from pessoa where id=?";

				
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id);
		
		rs = ps.execute(); // Caso a query seja executada com sucesso retornar� um valor booleano
		return rs; 
	}

	@Override
	public Boolean Atualizar(Pessoa _objeto) throws SQLException {
		
		boolean rs = false;
		
		String SQL = "update pessoa set nome=?, email=?, tel=? where id=?";
				
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		

		
		ps.setString(1, _objeto.getNome());
		ps.setString(2, _objeto.getEmail());
		ps.setString(3, _objeto.getTelefone());
		ps.setInt(4, _objeto.getId());
		
		rs = ps.execute(); // Caso a query seja executada com sucesso retornar� um valor booleano
		
		return rs;
	}

	@Override
	public Pessoa buscarPorId(int _id) throws SQLException {
		ResultSet rs = null;
		
		String SQL = "Select * from pessoa where id=?"; // Com base no id passado por par�metro ele vai encontrar a pessoa
				
		PreparedStatement ps = this.conexao.prepareStatement(SQL);
		
		ps.setInt(1, _id); // Faz a substitui��o do ? pelo id passado por par�metro
		// � utilizado o prepared statement ao inv�s da concatena��o dos par�metros por quest�o de seguran�a
		rs = ps.executeQuery();
		

		
		if(rs.next()) {
			Pessoa p = new Pessoa();
			
			p.setId(rs.getInt(1)); 
			p.setNome(rs.getString(2)); 
			p.setTelefone(rs.getString(3));
			p.setEmail(rs.getString(4)); 
	
			return p; // Ao encotrar a pessoa
		}
		
		return null;
	}

}
