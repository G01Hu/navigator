package xj.api.tx.manager;

import com.codingapi.txlcn.tm.config.EnableTransactionManagerServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: TxManagerApplication
 * @Description:
 * @Author: huqy
 * @Date: 2020-2-13 17:30
 */
@SpringBootApplication
@EnableTransactionManagerServer
public class TxManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TxManagerApplication.class, args);
    }
}
