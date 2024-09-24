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

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // 회원가입 처리
    public void insertUser(UserDto user) {
        // 비밀번호 암호화
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDao.insertUser(user);
    }
  
    //로그인 처리
    public boolean login(String userid, String password) {
    	UserDto user = userDao.findByUserid(userid);
    	if(user != null && passwordEncoder.matches(password, user.getPassword())) {
    		//비밀번호가 일치하면 로그인 성공
    		return true;
    	}
    		//로그인실패
    		return false;
    }
}