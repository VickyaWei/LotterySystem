package cn.it.lottery;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author vickyaa
 * @date 12/19/23
 * @file LotteryApplication
 */

@SpringBootApplication
@Configurable
@EnableDubbo
@MapperScan("cn.it.lottery.infrastructure.dao")
public class LotteryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotteryApplication.class, args);
    }
}
