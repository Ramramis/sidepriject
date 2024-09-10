package user.side.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import user.side.dto.UserDto;
import user.side.service.UserService;


@Controller
public class ProductController {
	
	 
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
	    


	

}//class
