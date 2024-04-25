package com.example.servermanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
@MapperScan("com.example.servermanagement.Mapper")
public class ServerManagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServerManagementApplication.class, args);
    }

}
