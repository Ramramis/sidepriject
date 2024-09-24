package user.side.dao;


import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import user.side.dto.ProductDto;

@Mapper
public interface ProductDao {
	
	  @Select("SELECT * FROM products")
	    List<ProductDto> getAllProducts();

	    @Select("SELECT * FROM products WHERE id = #{id}")
	    ProductDto getProductById(Long id);

	    @Insert("INSERT INTO products (name, description, imageUrl, price , memo) VALUES (#{name}, #{description}, #{imageUrl}, #{price} ,#{memo})")
	    void insertProduct(ProductDto product);
}
