package com.egoonet.lighting.assembly_jxepc_server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(scanBasePackages = "com.egoonet.lighting.assembly_jxepc_server") //1
@MapperScan(basePackages = "com.egoonet.lighting.assembly_jxepc_server.dao") //2
public class AssemblyJxepcServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssemblyJxepcServerApplication.class, args);
	}
}
