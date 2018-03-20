package com.moaa.domain.member.memberInformation;

public class Email {

    private String emailAddress;

    private Email(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public static Email of(String emailAddress){
        return new Email(emailAddress);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

//    /**returns string representation of domain-name without the @**/
//    public String getSubDomain(){
//        return emailAddress.substring(emailAddress.indexOf("@")+1, emailAddress.lastIndexOf("."));
//    }

    @Override
    public String toString() {
        return emailAddress;
    }

}
