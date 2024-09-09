package user.side.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.side.dao.ProductDao;
import user.side.dto.Product;

@Service
public class ProductService {
	
	 @Autowired
	    private ProductDao productdao;
	    
	    public List<Product> getAllProducts() {
	        return productdao.findAll();
	    }
	    
	    public Product getProductById(int id) {
	        return productdao.findById(id);
	    }
	    
	    public void addProduct(Product product) {
	    	productdao.insertProduct(product);
	    }
	    
	    public void updateProduct(Product product) {
	    	productdao.updateProduct(product);
	    }
	    
	    public void deleteProduct(int id) {
	    	productdao.deleteProduct(id);
	    }

}
