package user.side.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import user.side.dto.Product;

@Mapper
public interface ProductDao {
	
	 // 모든 제품 목록 가져오기
    @Select("SELECT * FROM products")
    List<Product> findAll();

    // 특정 제품 ID로 제품 가져오기
    @Select("SELECT * FROM products WHERE id = #{id}")
    Product findById(int id);

    // 새 제품 추가
    @Insert("INSERT INTO products (name, description, price, image_url) VALUES (#{name}, #{description}, #{price}, #{imageUrl})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertProduct(Product product);

    // 특정 제품 업데이트
    @Update("UPDATE products SET name=#{name}, description=#{description}, price=#{price}, image_url=#{imageUrl} WHERE id=#{id}")
    void updateProduct(Product product);

    // 특정 제품 삭제
    @Delete("DELETE FROM products WHERE id = #{id}")
    void deleteProduct(int id);

}
