package navigator.usercenterapi.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Component;

/**
 * @ClassName: BeanFactory
 * @Description:
 * @author:huqy
 * @date: 2019/8/27
 */
@Component
public class BeanFactory {

    /**
     * Redis数据源
     */
    @Autowired
    private RedisConnectionFactory redisConnection;

    /**
     * 设定TOken存储方式->Redis
     *
     * @return TOken存储方式
     */
    @Bean
    public TokenStore tokenStore() {
        return new RedisTokenStore(redisConnection);
    }
}
