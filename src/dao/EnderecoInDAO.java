package dao;

import java.sql.SQLException;
import java.util.List;

import model.Endereco;


public interface EnderecoInDAO {

	void Inserir(Endereco objeto) throws SQLException;

	List<Endereco> listarTodos() throws SQLException;

	Boolean Excluir(int _id) throws SQLException;

	Boolean Atualizar(Endereco _objeto) throws SQLException;

	Endereco buscarPorId(int _id) throws SQLException;
	
	List<Endereco> listarEnderecosPorPessoa(int _idPessoa) throws SQLException;
	
}
