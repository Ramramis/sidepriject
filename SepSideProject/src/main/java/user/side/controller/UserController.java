package user.side.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import user.side.dto.UserDto;
import user.side.service.UserService;


@Controller
public class UserController {
	
	 
	 @Autowired
	    private UserService userService;

	    @GetMapping("/home")
	    public String home(Model m) {
	        return "home";
	    }

	    // 회원가입 폼을 보여주는 GET 요청
	    @GetMapping("/register")
	    public String showRegistrationForm(Model m) {
	        m.addAttribute("user", new UserDto());  // 빈 사용자 객체 전달
	        return "register";
	    }

	    // 회원가입 폼 제출 처리 POST 요청
	    @PostMapping("/register")
	    public String registerUser(@ModelAttribute("user") UserDto user, Model model) {
	        // 사용자 저장 처리
	        userService.insertUser(user);
	        return "redirect:/home";  // 회원가입 성공 후 홈 페이지로 리다이렉트
	    }
	    
	    //로그인 폼을 보여주는 GetMapping
	    @GetMapping("/login")
	    public String showLoginForm(Model m) {
	    	
	    	return "login";
	    }
	    
	    
	    //로그인 처리 PostMapping
	    @PostMapping("/login")
	    	public String loginUser(@RequestParam("userid")String userid,
	    										@RequestParam("password")String password,Model m) {
	    		
	    		if(userService.login(userid, password)) {	
	    			return "redirect:/home"; // 로그인 성공시 home으로
	    		
	    		}else {
	    			m.addAttribute("error","아이디 또는 비밀번호가 일치하지 않습니다.");
	    			return "login";
	    		}
	    	}
	    	
	    	
	    
	    
	    


	

}//class
