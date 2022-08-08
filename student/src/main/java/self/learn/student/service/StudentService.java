package self.learn.student.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import self.learn.student.dao.StudentRepo;
import self.learn.student.dto.StudentAddress;
import self.learn.student.dto.StudentParams;
import self.learn.student.entity.Student;
import self.learn.student.feignclient.AddressFeignClient;
import self.learn.student.model.StudentDetails;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepo repo;
	
	/*@Autowired
	private WebClient webClient; */
	
	@Autowired
	private AddressFeignClient addressClient;

	public ResponseEntity<String> saveStudentData(StudentDetails std) {
		// TODO Auto-generated method stub
		Student student = Student.builder().name(std.getName()).email(std.getEmail()).addressId(std.getAddressId()).build();
		try{
			this.repo.save(student);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body("Error!!");
		}
		return ResponseEntity.status(HttpStatus.CREATED).body("Saved!!");
	}

	public ResponseEntity<StudentParams> getStudentDetails(long id) {
		// TODO Auto-generated method stub
		StudentParams std = null;
		Optional<Student> student = this.repo.findById(id);
		if(student.isPresent()) {
			//StudentAddress address = getAddressById(student.get().getAddressId());
			
			StudentAddress address = addressClient.getAddress(student.get().getAddressId());
			
			std = StudentParams.builder()
					.id(student.get().getId())
					.name(student.get().getName())
					.email(student.get().getEmail())
					.address(address).build();
		}
		return ResponseEntity.ok(std);
	}
	
	//instead of rest template using webclient
	//disabling this as webclient will not be in use
	/*public StudentAddress getAddressById(long id) {
		Mono<StudentAddress> address = this.webClient.get().uri("/getAddr/"+id).retrieve().bodyToMono(StudentAddress.class);
		return  address.block();
	}
	*/
	

}
