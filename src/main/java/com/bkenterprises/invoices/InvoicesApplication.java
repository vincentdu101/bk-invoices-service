package com.bkenterprises.invoices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.context.annotation.PropertySource;

// exclude the class to avoid aws instance issues during mvn verify
@SpringBootApplication(exclude = ContextStackAutoConfiguration.class)
public class InvoicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(InvoicesApplication.class, args);
	}

}
