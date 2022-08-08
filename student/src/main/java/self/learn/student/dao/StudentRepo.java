package self.learn.student.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import self.learn.student.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {

}
