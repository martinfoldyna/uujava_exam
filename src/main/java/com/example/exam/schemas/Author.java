package com.example.exam.schemas;

import java.time.LocalDateTime;
import java.util.UUID;

public class Author {
    public UUID id;

    public String firstName;
    public String lastName;

    public Author(String firstName, String lastName) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
