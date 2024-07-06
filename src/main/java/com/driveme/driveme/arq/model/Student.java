package com.driveme.driveme.arq.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String name;
    private String role; // "driver" or "passenger"
    private String location; // "north", "center", "south"
}
