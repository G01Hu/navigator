package xj.api.oauth.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName: AuthorizationServerConfig
 * @Description: 授权服务
 * @Author:  huqy
 * @Date:  2020/1/14
 */
@Configuration
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Resource
    private TokenStore tokenStore;

    @Resource
    private UserDetailsService userDetailsService;

    @Resource
    private ClientDetailsService clientDetails;

    @Resource
    private AuthenticationManager authenticationManager;

    public AuthorizationServerConfig() {
        super();
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients()
                .checkTokenAccess("permitAll()")
        ;
    }

    /**
     *  负责从存储仓库中读取数据
     * @param clients s
     * @throws Exception s
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails);

    }

    /**
     *  令牌存储方式 JDBC存储  设置令牌过期时间等属性使用
     *  DefaultTokenServices或者JdbcTokenStore进行定制
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore);
        defaultTokenServices.setClientDetailsService(clientDetails);
        // access token有效期2个小时
        defaultTokenServices.setAccessTokenValiditySeconds((int) TimeUnit.SECONDS.toSeconds(30));
        // refresh token有效期30天
        defaultTokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 30);
        // 支持使用refresh token刷新access token
        defaultTokenServices.setSupportRefreshToken(true);
        // 允许重复使用refresh token
        defaultTokenServices.setReuseRefreshToken(true);

        endpoints.tokenStore(tokenStore)
                .authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService)
                .tokenServices(defaultTokenServices)
                //该字段设置设置refresh token是否重复使用,true:reuse;false:no reuse
                .reuseRefreshTokens(true);
    }
}
