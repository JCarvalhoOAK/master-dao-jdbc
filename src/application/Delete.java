package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import db.DbIntegrityException;

public class Delete {
//Jamais esqueça do WHERE para não fazer merda!
	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		try {
			conn = DB.getConnection();
	
			st = conn.prepareStatement(
					//Apagar o departamento de código 5
					"DELETE FROM departamento "
					+ "WHERE "
					+ "Id = ?");

			st.setInt(1, 5);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Feito! Número de linhas afetadas: " + rowsAffected);
		}
		catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		} 
		finally {
			DB.closeStatement(st);
			DB.closeConnection();
		}
	}
}
