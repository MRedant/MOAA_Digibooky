package com.moaa.api.member;

import java.util.UUID;

public class LibrarianDTO {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;

    public static LibrarianDTO librarianDTO(){
        return new LibrarianDTO();
    }

    public LibrarianDTO withFirstname(String firstName){
        this.firstName = firstName;
        return this;
    }

    public LibrarianDTO withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
