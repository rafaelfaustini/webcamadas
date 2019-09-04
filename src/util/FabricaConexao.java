package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

	private Connection conexao;
	
	public Connection fazerConexao() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			this.conexao = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/webcamadas",
					"root",
					""
					);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.conexao;
	}
	
	public void fecharConexao() {
		
		try {
			
			this.conexao.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}