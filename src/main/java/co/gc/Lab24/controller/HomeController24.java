package co.gc.Lab24.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.gc.Lab24.dao.ProductDao;
import co.gc.Lab24.model.Product;
import co.gc.Lab24.model.User;



@Controller
public class HomeController24 {
	
	@Autowired
	ProductDao dao;
	
	@RequestMapping("add-user")
	public ModelAndView addUser(User u) {
		dao.addUser(u.getFirstName(), u.getLastName());
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping("/")
	public ModelAndView home() {
		System.out.println(dao.findAllProducts()); // to test if working & will show in console
		return new ModelAndView("index", "productList", dao.findAllProducts()); // this will now push data to page
	}

	@RequestMapping("add-product")
	public ModelAndView addProduct(Product p) {
		dao.addProduct(p.getName(), p.getDescription(), p.getQuantity(), p.getPrice());
		return new ModelAndView("redirect:/");
		//redirecting to the home page, will go up and call all objects from method above so don't have to duplicate code
	}
	
	@PostMapping("search-name")
	public ModelAndView search2(@RequestParam(value = "name", required = false) String n) {
		ModelAndView mv = new ModelAndView("index", "productList", dao.searchByName(n));
		if (n != null && !n.isEmpty()) {
			mv.addObject("productName", n);
		} else {
			mv.addObject("productList", dao.getAllItems());
		}
		return mv;
	}

}
