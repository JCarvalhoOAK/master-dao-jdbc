package model.dao;

import db.DB;
import model.dao.impl.DepartamentoDaoJDBC;
import model.dao.impl.VendedorDaoJDBC;

public class DaoFactory {

	public static VendedorDao createVendedorDao() {
		//return new VendedorDaoJDBC();
		return new VendedorDaoJDBC(DB.getConnection());
	}
	
	public static DepartamentoDao createDepartmentDao() {
		return new DepartamentoDaoJDBC(DB.getConnection());
	}
}