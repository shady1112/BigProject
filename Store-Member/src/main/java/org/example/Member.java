package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * Hello world!
 *
 * @author Shady
 */

@EnableDiscoveryClient
@SpringBootApplication
public class Member {
    public static void main(String[] args) {
        SpringApplication.run(Member.class, args);
    }
}
