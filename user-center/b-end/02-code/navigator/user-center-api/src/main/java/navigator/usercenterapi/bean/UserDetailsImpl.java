package navigator.usercenterapi.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @author :huqy
 * @ClassName: UserDetailsImpl
 * @Description: 用户详情
 * @date: 2019/8/21
 */
public class UserDetailsImpl implements UserDetails {
    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8961659937372011137L;

    //用户信息
    private UserBean userBean;
    //权限
    private Collection<? extends GrantedAuthority> authorities;

    public UserDetailsImpl(UserBean userBean, Collection<? extends GrantedAuthority> authorities) {
        this.userBean = userBean;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return this.userBean.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userBean.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
