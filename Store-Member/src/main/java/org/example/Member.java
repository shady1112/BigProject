package org.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.CrossOrigin;

/**
 * @author Shady
 */

@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("org.example.mapper")
public class Member {
    public static void main(String[] args) {
        SpringApplication.run(Member.class, args);
    }
}
