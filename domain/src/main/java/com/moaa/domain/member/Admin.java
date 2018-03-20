package com.moaa.domain.member;

import com.moaa.domain.member.utils.Email;

import java.util.UUID;

public class Admin {

    private UUID id;
    private String firstName;
    private String lastName;
    private Email email;

    Admin(String firstName, String lastName, Email email) {
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
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

    public Email getEmail() {
        return email;
    }

    public static class AdminBuilder {
        private String firstName;
        private String lastName;
        private Email email;

        public static AdminBuilder builder(){
            return new AdminBuilder();
        }

        public AdminBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public AdminBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public AdminBuilder setEmail(Email email) {
            this.email = email;
            return this;
        }

        public Admin createAdmin() {
            return new Admin(firstName, lastName, email);
        }
    }
}
