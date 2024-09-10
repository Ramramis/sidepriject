package user.side.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import user.side.dao.UserDao;
import user.side.dto.UserDto;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    

    // 회원가입 처리
    public void insertUser(UserDto user) {
        userDao.insertUser(user);  // DB에 유저 저장
    }



    

 
}
