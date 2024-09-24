package user.side.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import user.side.dao.ProductDao;
import user.side.dto.ProductDto;

@Service
public class ProductService {
	
	@Autowired
    private ProductDao productDao;

		
	//제품목록
	 public List<ProductDto> getAllProducts() {
	        return productDao.getAllProducts();
	    }

	 //제품상세페이지
	    public ProductDto getProductById(Long productId) {
	        return productDao.getProductById(productId);
	    }

	    public void insertProduct(ProductDto product) {
	        productDao.insertProduct(product);  // 제품 등록
	    }

}
