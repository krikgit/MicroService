package self.learn.student.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentParams {
	
	private long id;
	private String name;
	private String email;
	private StudentAddress address;

}
