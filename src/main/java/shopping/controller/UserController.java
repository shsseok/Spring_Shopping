package shopping.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



import shopping.request.UserRegisterRequest;
import shopping.service.UserService;

@Controller
@RequestMapping(path = "/users")
public class UserController {
    
    @Autowired
	private UserService userService;

/*    @GetMapping("/loginform")
    public String loginform(){
        return "members/loginform";
    }

    @RequestMapping("/loginerror")
    public String loginerror(@RequestParam("login_error")String loginError){
        return "members/loginerror";
    }*/
    @PostMapping(consumes="application/json; charset=utf8")
    public ResponseEntity<String> userSave(@RequestBody UserRegisterRequest userRegisterRequest )
    {
    	userService.addUser(userRegisterRequest);
    	String message="회원가입 성공";
    	return ResponseEntity.ok(message);
    }
    
}
