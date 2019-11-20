package co.gc.Lab24.dao;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import co.gc.Lab24.model.Product;




@Repository
public class ProductDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private List<Product> list = new ArrayList<>();
	
	public int addUser(String FirstName, String LastName) {
		String addUserQuery = "insert into Users(FirstName, LastName) values(?,?)";
		return jdbcTemplate.update(addUserQuery, FirstName, LastName);
	}
	
	public List<Product> findAllProducts() {
		return jdbcTemplate.query("select * from Products", new BeanPropertyRowMapper<Product>(Product.class));
	}
	

	public int addProduct(String name, String description, int quantity, double price) {
		String addQuery = "insert into Products(name, description, quantity, price) values(?,?,?,?)"; 
		return jdbcTemplate.update(addQuery, name, description, quantity, price);
	}
	
	//this method will be used to allow a user to search by name
	public List<Product> searchByName(String name) {
		List<Product> nameList = new ArrayList<>();
		for (Product p : list) {
			if(p.getName().equalsIgnoreCase(name)) {
				nameList.add(p);
			}
		}
		return nameList;
	}

	//create a method that will retrieve all the items in our list of products
		public List<Product> getAllItems() {
			return jdbcTemplate.query("select * from Products", new BeanPropertyRowMapper<Product>(Product.class));
		}
}
