package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;

//=============Busca por departamento===============
public class Busca {

	public static void main(String[] args) {

		/*Connection conn = DB.getConnection();
		DB.closeConnection();*/
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		Scanner sc = new Scanner(System.in);
		String N = sc.toString();
		//=====================================
		System.out.println("Digite sua busca dentro de DEPARTAMENTO: (DIGITE * PARA TODOS!)");
		System.out.print("O que procura: ");
		String buscaDepartamento = sc.nextLine();
				
		//=====================================
		
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			
			//rs = st.executeQuery("select * from departamento");			
			rs = st.executeQuery("select" + buscaDepartamento + " from departamento");
			
			while (rs.next()) {
				System.out.println(rs.getInt("Id") + "," + rs.getString("name"));
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			sc.close();
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}	
		
	}
}