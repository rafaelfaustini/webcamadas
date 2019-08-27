package dao;

import java.sql.SQLException;
import java.util.List;

import model.Pessoa;

public interface PessoaInDAO { // Interface de PessoaDAO
	void Inserir(Pessoa objeto) throws SQLException;
	
	List<Pessoa> listarTodos() throws SQLException;
	
	Boolean Excluir(int _id) throws SQLException;
	
	Boolean Atualizar(Pessoa _objeto) throws SQLException;
	
	Pessoa buscarPorId(int _id) throws SQLException;
}
