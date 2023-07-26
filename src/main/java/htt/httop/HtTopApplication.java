package htt.httop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class HtTopApplication {

	public static void main(String[] args) {
		SpringApplication.run(HtTopApplication.class, args);
		System.out.println("Program Started");
	}
}
