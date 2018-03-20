package com.moaa.domain.member.email;

import org.junit.Test;

public class integrationTest_Email {

    @Test
    public void testIfEmailAddressIsValidatedRight() {
        //GIVEN
        String validEmailAddress = "mredant@gmail.com";

        //TEST
        org.assertj.core.api.Assertions
                .assertThat(Email.of(validEmailAddress)
                        .getEmailAddress())
                .isEqualTo("mredant@gmail.com");
    }

    @Test
    public void testIfEmailAddressIsInValid_withASpecialCharacterInTheFirstPart() {
        //GIVEN
        String inValidEmailAddress1 = "%/@gmail.com";

        //TEST
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Email.of(inValidEmailAddress1))
                .withMessage("Not a valid emailaddress");
    }

    @Test
    public void testIfEmailAddressIsInValid_withMissingPart() {
        //GIVEN
        String inValidEmailAddress = "@gmail.com";

        //TEST
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Email.of(inValidEmailAddress))
                .withMessage("Not a valid emailaddress");
    }

    @Test
    public void testIfEmailAddressIsInValid_withMissingPartAndSpecialSigns() {
        //GIVEN
        String inValidEmailAddress = "@%";

        //TEST
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> Email.of(inValidEmailAddress))
                .withMessage("Not a valid emailaddress");
    }
}