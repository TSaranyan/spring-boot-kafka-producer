package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(KafkaConfig.class);
		context.registerShutdownHook();
		ProducerImpl frontDesk = context.getBean(ProducerImpl.class);
		frontDesk.sendMail("344");
	}

}
