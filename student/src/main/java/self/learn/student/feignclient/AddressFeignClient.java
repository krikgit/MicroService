package self.learn.student.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import self.learn.student.dto.StudentAddress;

@FeignClient(value = "address-service"/* "address-feign-client", url = "${address.service.url}" */, path = "api/address/")
public interface AddressFeignClient {
	
	@GetMapping("/getAddr/{id}")
	public StudentAddress getAddress(@PathVariable Long id);

}
