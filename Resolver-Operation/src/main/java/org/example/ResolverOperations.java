package org.example;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@NacosPropertySource(dataId = "Resolver-Common.yaml",autoRefreshed = true,groupId = "DEV_GROUP")
public class ResolverOperations
{
    public static void main( String[] args ) {
        SpringApplication.run(ResolverOperations.class, args);
    }
}
