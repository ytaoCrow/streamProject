package com.example.springwebservice;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.SQLException;

@SpringBootApplication
public class SpringWebServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringWebServiceApplication.class, args);
	}

}
