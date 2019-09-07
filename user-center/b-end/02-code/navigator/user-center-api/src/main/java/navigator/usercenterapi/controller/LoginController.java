package navigator.usercenterapi.controller;

import navigator.usercenterapi.bean.UserBean;
import navigator.usercenterapi.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:huqy
 * @ClassName: Login
 * @Description:
 * @date: 2019/8/19
 */
@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public UserBean test(String username){
        UserBean userBean = new UserBean();
        userBean.setUserName(username);
        return loginService.getUser(userBean);
    }

}
