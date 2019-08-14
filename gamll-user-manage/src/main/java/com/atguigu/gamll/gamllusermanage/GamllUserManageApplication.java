package com.atguigu.gamll.gamllusermanage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.gamll.gamllusermanage.mapper")
public class GamllUserManageApplication {

	public static void main(String[] args) {
		SpringApplication.run(GamllUserManageApplication.class, args);
	}

}
