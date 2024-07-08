package com.driveme.driveme.arq.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Getter
@Setter
@Document(collection = "match")
public class Match {
    @Id
    private String id;
    private String driverId;
    private String passengerId;

    @Field("created_at")
    private Date createdAt;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Match{id='").append(id).append('\'');
        sb.append(", driverId='").append(driverId).append('\'');
        sb.append(", passengerId='").append(passengerId).append('\'');
        sb.append(", createdAt=").append(createdAt);
        sb.append('}');
        return sb.toString();
    }
}
