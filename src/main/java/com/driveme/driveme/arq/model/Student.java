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
    private String number;
    private String location; // "north", "center", "south"

    public boolean validInfo() {
        // Verificar que name, role, number y location no sean nulos ni vacíos
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (role == null || role.trim().isEmpty()) {
            return false;
        }
        if (number == null || number.trim().isEmpty()) {
            return false;
        }
        if (location == null || location.trim().isEmpty()) {
            return false;
        }

        // Verificar que role sea "driver" o "passenger"
        if (!role.equals("driver") && !role.equals("passenger")) {
            return false;
        }

        // Verificar que location sea "north", "center" o "south"
        if (!location.equals("north") && !location.equals("center") && !location.equals("south")) {
            return false;
        }

        // Todas las validaciones pasaron
        return true;
    }
}