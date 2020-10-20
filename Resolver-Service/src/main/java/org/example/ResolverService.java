package org.example;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Shady
 */

@SpringBootApplication
@MapperScan("org.example.mapper")
@NacosPropertySource(dataId = "Resolver-Common.yaml",autoRefreshed = true,groupId = "DEV_GROUP")
public class ResolverService {
    public static void main(String[] args) {
        SpringApplication.run(ResolverService.class, args);
    }
}
