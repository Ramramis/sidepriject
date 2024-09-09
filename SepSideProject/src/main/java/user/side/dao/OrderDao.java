package user.side.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import user.side.dto.Order;

@Mapper
public interface OrderDao {
	
	// 모든 주문 목록 가져오기
    @Select("SELECT * FROM orders")
    List<Order> findAll();

    // 주문 ID로 특정 주문 가져오기
    @Select("SELECT * FROM orders WHERE id = #{id}")
    Order findById(int id);

    // 새 주문 추가
    @Insert("INSERT INTO orders (customer_name, customer_email, product_id, quantity, total_price) VALUES (#{customerName}, #{customerEmail}, #{productId}, #{quantity}, #{totalPrice})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertOrder(Order order);

    // 특정 주문 삭제
    @Delete("DELETE FROM orders WHERE id = #{id}")
    void deleteOrder(int id);

}
