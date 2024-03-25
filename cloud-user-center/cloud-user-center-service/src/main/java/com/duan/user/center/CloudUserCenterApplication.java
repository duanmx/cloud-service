package com.duan.user.center;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 启动类
 * @author duanmx
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"com.duan"})
@MapperScan("com.duan.user.center.mapper")
public class CloudUserCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudUserCenterApplication.class, args);
    }
}
