package navigator.usercenterapi.controller;

import navigator.usercenterapi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:huqy
 * @ClassName: Login
 * @Description:
 * @date: 2019/8/19
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/")
    public String test(){
        return
    }

}
