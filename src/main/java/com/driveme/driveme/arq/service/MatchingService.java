package com.driveme.driveme.arq.service;

import com.driveme.driveme.arq.db.MatchRepository;
import com.driveme.driveme.arq.model.Match;
import com.driveme.driveme.arq.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.driveme.driveme.arq.db.StudentRepository;

import java.util.Date;
import java.util.List;

@Service
public class MatchingService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private MatchRepository mr;

    public void addToQueue(Student student) {
        studentRepository.save(student);
        match(student);
    }

    public void match(Student student) {
        List<Student> matches = studentRepository.findByRoleAndLocation(
                student.getRole().equals("driver") ? "passenger" : "driver",
                student.getLocation()
        );

        if (!matches.isEmpty()) {
            Student match = matches.get(0);
            studentRepository.delete(student);
            studentRepository.delete(match);

            Match m = new Match();

            m.setCreatedAt(new Date());
            m.setDriverId(student.getRole().equals("driver") ?  student.getId(): match.getId());
            m.setPassengerId(!student.getRole().equals("driver") ?  student.getId(): match.getId());

            mr.save(m);
            // Enviar notificación de emparejamiento a Kafka
            kafkaTemplate.send("match_topic", m.toString());
        }
    }
}
