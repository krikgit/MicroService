package self.learn.address.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import self.learn.address.dao.AddressRepo;
import self.learn.address.dto.AddressParams;
import self.learn.address.entity.Address;
import self.learn.address.model.AddressModel;

@Service
public class AddressService {
	

	@Autowired
	private AddressRepo addressRepo;

	public ResponseEntity<String> createAddress(AddressModel address) {
		// TODO Auto-generated method stub
		Address newAddress = Address.builder().street(address.getStreet()).city(address.getCity()).build();
		try {
			newAddress = this.addressRepo.save(newAddress);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getStackTrace()[0].getMethodName());
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error Ocuured! At:"
					+ e.getStackTrace()[0].getLineNumber() + " & the Reason being:" + e.getCause());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Saved Successfully!!");
	}

	public ResponseEntity<AddressParams> getAddress(Long id) {
		// TODO Auto-generated method stub

		Optional<Address> address = null;
		AddressParams addr = null;
		try {
			address = this.addressRepo.findById(id);
			if (address.isPresent()) {
				addr = AddressParams.builder().id(address.get().getId()).street(address.get().getStreet())
						.city(address.get().getCity()).build();
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.badRequest().body(null);
		}
		System.out.println("Address Service | Address returned!");
		return ResponseEntity.ok(addr);
		
	}

	public ResponseEntity<List<AddressParams>> getAllAddresses() {
		// TODO Auto-generated method stub
		List<Address> addressList = null;
		List<AddressParams> list = null;
		try {
			addressList = new ArrayList<Address>();
			addressList = this.addressRepo.findAll();
			if (!addressList.isEmpty()) {
				list = new ArrayList<AddressParams>();
				for (Address address : addressList) {
					AddressParams add = AddressParams.builder().id(address.getId()).street(address.getStreet())
							.city(address.getCity()).build();
					list.add(add);
				}
			} else {
				return ResponseEntity.notFound().build();
			}
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.internalServerError().build();
		}

		return ResponseEntity.ok(list);
	}

}
