package com.moaa.domain.member.email;

public class Email {

    private String emailAddress;


    private Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public static Email of(String emailAddress) throws IllegalArgumentException {
        if (!EmailValidation.validate(emailAddress)) {
            throw new IllegalArgumentException("Not a valid emailaddress");
        } else {
            return new Email(emailAddress);
        }
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    @Override
    public String toString() {
        return emailAddress;
    }
}
