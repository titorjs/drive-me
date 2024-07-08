package com.driveme.driveme.arq.controller;

import com.driveme.driveme.arq.model.Student;
import com.driveme.driveme.arq.service.MatchingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/driveme")
public class MatchingController {
    @Autowired
    private MatchingService ms;

    @PostMapping("/post")
    public String post(@RequestBody Student student){
        if(!student.validInfo())
            return "NO: Información inválida";

        ms.addToQueue(student);
        return "OK: Posteado correctamente";
    }
}