package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import db.DB;

public class Program {

	public static void main(String[] args) {
		
			/*Connection conn = DB.getConnection();
			DB.closeConnection();*/
			Connection conn = null;
			Statement st = null;
			ResultSet rs = null;
			
			Scanner sc = new Scanner(System.in);
			String N = sc.toString();
	}
			//=====================================
			//=====================================
		/*finally {
			sc.close();
			DB.closeResultSet(rs);
			DB.closeStatement(st);
			DB.closeConnection();
		}	*/
		
	}