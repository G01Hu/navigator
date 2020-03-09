package xj.api.oauth.service;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: UserDetailServiceImpl
 * @Description:
 * @Author:  huqy
 * @Date:  2020/1/14
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private JdbcTemplate jdbcTemplate;

    private static final String LOAD_USER_BY_NAME="SELECT ACCOUNT , PASSWORD, ENABLED, ACCOUNTNONEXPIRED, CREDENTIALSNONEXPIRED, ACCOUNTNONLOCKED FROM SYS_USER where ACCOUNT=?";

    private static final String  LOAD_AUTHORITY_BY_NAME= " SELECT LISTAGG(ROLE_NAME, ',') WITHIN GROUP (ORDER BY SYS_USER.ID) " +
                " FROM SYS_USER" +
                " JOIN SYS_USER_ROLE ON SYS_USER.ID = SYS_USER_ROLE.USER_ID" +
                " JOIN SYS_ROLE ON SYS_ROLE.ID = SYS_USER_ROLE.ROLE_ID " +
                " where ACCOUNT = ?";

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        //根据账号查找用户
        List<GrantedAuthority> grantedAuthorities = jdbcTemplate.queryForObject(LOAD_AUTHORITY_BY_NAME, new String[]{userName}, (rs, rowNum) -> {
            String authoritys = rs.getString(1);
            if (StringUtils.isNotBlank(authoritys)){
                return AuthorityUtils.commaSeparatedStringToAuthorityList(authoritys);
            }else{
                return AuthorityUtils.NO_AUTHORITIES;
            }
        });
        //根据用户名查找用户
        UserDetails userDetails = jdbcTemplate.queryForObject(LOAD_USER_BY_NAME, new String[]{userName}, (RowMapper<UserDetails>) (rs, rowNum) -> {
            String username = rs.getString(1);
            String password = rs.getString(2);
            boolean enabled = rs.getBoolean(3);
            boolean accountNonExpired = rs.getBoolean(4);
            boolean credentialsNonExpired = rs.getBoolean(5);
            boolean accountNonLocked = rs.getBoolean(6);
            return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked,
                   grantedAuthorities);
        });
        return userDetails;
    }
}
