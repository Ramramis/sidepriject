package user.side.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import user.side.dto.Product;
import user.side.service.ProductService;

@Controller
public class ProductController {
	
	 @Autowired
	    private ProductService productService;
	    
	    @GetMapping("/products")
	    public String getProducts(Model model) {
	        List<Product> products = productService.getAllProducts();
	        model.addAttribute("products", products);
	        return "products"; // JSP 파일명 (products.jsp)
	    }
	    
	    @GetMapping("/product/{id}")
	    public String getProductById(@PathVariable int id, Model model) {
	        Product product = productService.getProductById(id);
	        model.addAttribute("product", product);
	        return "product-detail"; // JSP 파일명 (product-detail.jsp)
	    }

}
