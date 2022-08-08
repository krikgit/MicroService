package self.learn.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import self.learn.student.dto.StudentParams;
import self.learn.student.model.StudentDetails;
import self.learn.student.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> saveStudentsDetails(@RequestBody StudentDetails std){
		return this.service.saveStudentData(std);
	}
	
	@GetMapping("/getStd/{id}")
	public ResponseEntity<StudentParams> getStudent(@PathVariable long id){
		return this.service.getStudentDetails(id);
	}

}
