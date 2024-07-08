package com.driveme.driveme.arq.db;

import com.driveme.driveme.arq.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StudentRepository extends MongoRepository<Student, String> {
    List<Student> findByRoleAndLocation(String role, String location);
}
