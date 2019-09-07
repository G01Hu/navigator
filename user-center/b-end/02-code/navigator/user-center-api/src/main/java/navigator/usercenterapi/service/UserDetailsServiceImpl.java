package navigator.usercenterapi.service;

import navigator.usercenterapi.bean.UserBean;
import navigator.usercenterapi.bean.UserDetailsImpl;
import navigator.usercenterapi.mapper.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author:huqy
 * @ClassName: UserDetailsServiceImpl
 * @Description: 获取用户详情
 * @date: 2019/8/21
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private LoginMapper loginMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserBean userBean=new UserBean();
        userBean.setUserName(username);
        //获取用户
        UserBean user = loginMapper.getUser(userBean);
        //用户不存在返回null
        if (user==null){
            return null;
        }else {
            return  new UserDetailsImpl(user,null);
        }
    }
}
