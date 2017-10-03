package com.packt.webstore.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.packt.webstore.domain.Product;
import com.packt.webstore.service.ProductService;

@Controller
@RequestMapping("market")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setAllowedFields("productId", "name", "unitPrice", "description",
				"manufacturer", "category", "unitsinStock", "condition",
				"productImage", "productGuide");
		
		DateFormat dateFormat = new SimpleDateFormat("MMM d, YYYY");
		CustomDateEditor customDateEditor = new CustomDateEditor(dateFormat, true);
		binder.registerCustomEditor(Date.class, customDateEditor);
	}
	
	@RequestMapping("/products")
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}
	
	@RequestMapping("/update/stock")
	public String updateStock(Model model) {
		productService.updateAllStocks();
		return "redirect:/market/products";
	}
	
	@RequestMapping("/products/{category}")
	public String getProductByCategory(Model model, @PathVariable("category") String category) {
		model.addAttribute("products", productService.getProductByCategory(category));
		return "products";
	}
	
	@RequestMapping("/products/filter/{params}")
	public String filterProducts(@MatrixVariable(pathVar="params") Map<String, List<String>> params,
			Model model) {
		model.addAttribute("products", productService.filterProducts(params));
		return "products";
	}
	
	@RequestMapping("/product")
	public String getById(@RequestParam("id") String id, Model model) {
		model.addAttribute("product", productService.getById(id));
		return "product";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	@RequestMapping(value = "/products/add", method = RequestMethod.POST)
	public String processAddProduct(@ModelAttribute("newProduct") Product product,
			BindingResult result, HttpServletRequest request) {
		if (result.hasErrors()) {
			throw new RuntimeException("error binding");
		}
		
		//product image
		MultipartFile productImage = product.getProductImage();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		if (productImage != null && !productImage.isEmpty()) {
			try {
				productImage.transferTo(new File(rootDirectory + "resources\\images\\" + product.getProductId() + ".png"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//product user guide (pdf)
		MultipartFile productUserGuide = product.getProductGuide();
		if (productUserGuide != null && !productUserGuide.isEmpty()) {
			try {
				productUserGuide.transferTo(new File(rootDirectory + "resources\\pdf\\" + product.getProductId() + ".pdf"));
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		productService.addProduct(product);
		return "redirect:/market/products";
	}
	
}
