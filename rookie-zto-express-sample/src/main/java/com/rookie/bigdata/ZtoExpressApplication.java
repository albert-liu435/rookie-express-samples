package com.rookie.bigdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Class ZtoExpressApplication
 * @Description
 * @Author rookie
 * @Date 2024/6/18 18:20
 * @Version 1.0
 */
@SpringBootApplication
public class ZtoExpressApplication {

    public static final Logger logger = LoggerFactory.getLogger(ZtoExpressApplication.class);

    public static void main(String[] args) {
        logger.info("==========当前环境是");
        SpringApplication.run(ZtoExpressApplication.class, args);


    }
}
