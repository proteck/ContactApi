package ch.proteck.contactapi.utils;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EmailUtilsTest {

    private final List<String> validEmail = Arrays.asList(
            "maxime@proteck.ch",
            "salut@coucou.swiss",
            "salut@coucou.hello.ch"
    );

    private final List<String> invalidEmail = Arrays.asList(
            "",
            "maxime#proteck.ch",
            "sdkflj calu.ch",
            null
    );

    @Test
    void checkValidEmail() {
        for(String email : validEmail) {
            assertTrue(EmailUtils.validate(email));
        }
    }

    @Test
    void checkInvalidEmail() {
        for(String email : invalidEmail) {
            assertFalse(EmailUtils.validate(email));
        }
    }
}