package self.learn.address.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import self.learn.address.dto.AddressParams;
import self.learn.address.model.AddressModel;
import self.learn.address.service.AddressService;

@RestController
@RequestMapping("/api/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/create")
	public ResponseEntity<String> createAddress(@RequestBody AddressModel address) {
		return this.addressService.createAddress(address);
	}
	
	@GetMapping("/getAddr/{id}")
	public ResponseEntity<AddressParams> getAddress(@PathVariable Long id){
		return this.addressService.getAddress(id);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<AddressParams>> getAllAddress(){
		return this.addressService.getAllAddresses();
	}
}
