package com.driveme.driveme.arq.db;

import com.driveme.driveme.arq.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface StudentRepository extends MongoRepository<Student, String> {
}
