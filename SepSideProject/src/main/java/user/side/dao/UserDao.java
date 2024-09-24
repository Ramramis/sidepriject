package user.side.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import user.side.dto.UserDto;

@Mapper
public interface UserDao {

    @Insert("INSERT INTO users (userid, email, password, name, address, phone) VALUES (#{userid}, #{email}, #{password}, #{name}, #{address}, #{phone})")
    void insertUser(UserDto user);
    
    
    // userid로 유저 조회
    @Select("select * from users where userid = #{userid}")
    UserDto findByUserid(String userid);
}