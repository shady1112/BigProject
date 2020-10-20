package org.example;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MyNacosApplication implements CommandLineRunner
{
    /**
     * 日志
     */
    private Logger logger = (Logger) LoggerFactory.getLogger(this.getClass());

    /**
     * 功能描述  启动项
     * @param args args
     * @author cailu
     * @date 2020/3/27 0:31
     */
    public static void main(String[] args) {
        SpringApplication.run(MyNacosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("== depend-nacos-project 服务启动成功！==");
    }
}
