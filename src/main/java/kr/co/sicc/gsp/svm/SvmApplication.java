package kr.co.sicc.gsp.svm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class SvmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SvmApplication.class, args);
	}
}
