package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;
import db.DbException;

public class Alteracao {
	/*TODA ALTERA��O TEM QUE SER:
	 * ATOMICA - ou acontece TUDo ou n�o acontece em NADA
	 * CONSISTENTE - 
	 * ISOLADA
	 * DURAVEL
*/
	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		try {
			conn = DB.getConnection();
	
			conn.setAutoCommit(false);

			st = conn.createStatement();
			
			//Alterar s�larios de vendedores por departamaneto
			int rows1 = st.executeUpdate("UPDATE vendedor SET BaseSalary = 1000 WHERE DepartmentId = 1");

			//Simula��o de erro falso no meio do caminho:
			/*int x = 1;
			if (x < 2) {
				throw new SQLException("Fake error");
			}*/
			
			int rows2 = st.executeUpdate("UPDATE vendedor SET BaseSalary = 999 WHERE DepartmentId = 2");
			
			conn.commit();
			
			System.out.println("Opera��o 1, altradas = " + rows1);
			System.out.println("Opera��o 2, altradas = " + rows2);
		}
		catch (SQLException e) {
			try {
				conn.rollback();
				throw new DbException("A transa��o precisou retornar ao estado original! Causado por: " + e.getMessage());
			} 
			catch (SQLException e1) {
				throw new DbException("Erro ao tentar rollback! Causado por: " + e1.getMessage());
			}
		} 
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}