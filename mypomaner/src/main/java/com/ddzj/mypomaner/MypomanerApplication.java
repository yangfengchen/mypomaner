package com.ddzj.mypomaner;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ddzj.mypomaner.mapper")
public class MypomanerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MypomanerApplication.class, args);
		///actuator/shutdown
	}

}
