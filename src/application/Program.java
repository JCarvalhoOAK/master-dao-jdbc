package application;

import java.util.List;

//import java.util.Date;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
//import model.entities.Departamento;
import model.entities.Vendedor;

public class Program {

	public static void main(String[] args) {
		
		//Departamento obj = new Departamento(1, "Books");
		
		//Vendedor vendedor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.0 , obj );
		
		
		System.out.println("=== TESTE 1: Vendedor findByid ===");
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		
		Vendedor vendedor = vendedorDao.findById(7);
		//System.out.println(obj);
		System.out.println(vendedor);
		
		System.out.println("\n=== TESTE 2: Vendedor findByDepartment ===");
		Departamento departamento = new Departamento(4, null);
		List<Vendedor> list = vendedorDao.findByDepartamento(departamento);
		for (Vendedor obj : list) {
			System.out.println(obj);
		}
		
			}
}	