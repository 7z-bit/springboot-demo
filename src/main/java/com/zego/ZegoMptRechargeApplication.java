package com.zego;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class ZegoMptRechargeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZegoMptRechargeApplication.class, args);
    }

}
