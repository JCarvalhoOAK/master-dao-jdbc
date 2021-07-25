package application;

//import java.util.Date;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
//import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		//Departamento obj = new Departamento(1, "Books");
		
		//Vendedor vendedor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.0 , obj );
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
		Vendedor vendedor = vendedorDao.findById(7);
		
		//System.out.println(obj);
		System.out.println(vendedor);
			}
}	