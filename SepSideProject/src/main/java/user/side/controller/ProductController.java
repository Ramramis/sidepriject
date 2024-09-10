package user.side.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import user.side.dto.UserDto;
import user.side.service.UserService;


@Controller
public class ProductController {
	
	 
//	 @Autowired
//	    private UserService userService;

	    @GetMapping("/home")
	    public String home(Model m) {
	    	
	        return "home";
	    }

	    // 회원가입 폼 보여주기
	    @GetMapping("/register")
	    public String showRegistrationForm(Model m) {
	        m.addAttribute("user", new UserDto());  // 빈 사용자 객체 전달
	        return "register";  // 회원가입 페이지로 이동
	    }
	    


	

}//class
