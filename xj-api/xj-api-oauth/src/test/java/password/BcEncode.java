package password;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @ClassName: BcEncode
 * @Description:
 * @Author: huqy
 * @Date:  2019/10/31
 */
public class BcEncode {

    public static void main(String[] args) {
        String password="password";
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        System.out.println("BCryptPasswordEncoder:"+encode);

        System.out.println(new BCryptPasswordEncoder().encode("mes_client"));
    }
}
