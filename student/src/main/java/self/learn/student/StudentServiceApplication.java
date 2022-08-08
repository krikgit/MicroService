package self.learn.student;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"self.learn.student"})
//@EnableJpaRepositories
//@EntityScan
@EnableFeignClients("self.learn.student.feignclient")
@EnableEurekaClient
public class StudentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentServiceApplication.class, args);
	}
	
	/*
	 * @Value("${address.service.url}") 
	 * private String addressServiceUrl;
	 */
	
	/*@Bean
	public WebClient webClient() {
		WebClient webClient =  WebClient.builder().baseUrl(addressServiceUrl).build();
		return webClient;
	}*/

}
