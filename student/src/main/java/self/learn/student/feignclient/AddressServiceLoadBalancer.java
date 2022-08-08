package self.learn.student.feignclient;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;

import feign.Feign;


/**
 * @author Krishna Kamal
 * As the Ribbon for load balancing is depricated we are using Spring - cloud- Load balancer 
 */
@LoadBalancerClient(value = "address-service")
public class AddressServiceLoadBalancer {
	@Bean
	@LoadBalanced
	public Feign.Builder feignBuilder(){
		return Feign.builder();
	}

}
