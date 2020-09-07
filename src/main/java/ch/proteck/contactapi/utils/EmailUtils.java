package ch.proteck.contactapi.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtils {

    public static final Pattern REGEX_VALIDATION_EMAIL =
            Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

    /**
     * Check is the email is valide. If email is null, return false;
     *
     * @param email
     * @return
     */
    public static boolean validate(String email) {
        if (email == null) {
            return false;
        }
        Matcher matcher = REGEX_VALIDATION_EMAIL.matcher(email);

        return matcher.find();
    }

}
