package navigator.usercenterapi.service;

import navigator.usercenterapi.bean.UserBean;
import navigator.usercenterapi.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:huqy
 * @ClassName: LoginService
 * @Description:
 * @date: 2019/8/19
 */
@Service
public class LoginService {

    @Autowired
    private LoginMapper loginMapper;

    public UserBean test() {
        return loginMapper.test();
    }

    public UserBean getUser(UserBean userBean) {
        return loginMapper.getUser(userBean);
    }
}
