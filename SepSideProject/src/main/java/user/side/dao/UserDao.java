package user.side.dao;

import user.side.dto.UserDto;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
	
    // 새로운 유저를 데이터베이스에 추가하는 쿼리
    @Insert("INSERT INTO users (id , email, password,name,adress,phone) VALUES (#{id} , #{email}, #{password} , #{name) ,#{adress} , #{phone}")
    void insertUser(UserDto user);

    
}
