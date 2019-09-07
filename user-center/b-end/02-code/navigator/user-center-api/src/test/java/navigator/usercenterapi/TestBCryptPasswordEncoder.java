package navigator.usercenterapi;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: TestBCryptPasswordEncoder
 * @Description:
 * @author:huqy
 * @date: 2019/9/5
 */
public class TestBCryptPasswordEncoder {

    @Test
    public void encode(){
        String rawPassword="123123";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        String encode = bCryptPasswordEncoder.encode(rawPassword);
        System.out.println(encode);
    }
}
