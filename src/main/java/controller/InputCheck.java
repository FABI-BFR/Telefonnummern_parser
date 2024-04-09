package controller;

import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

/**
 * The InputCheck class is checking the input before it is further processed.
 *
 * @author Fabian Eilber
 * @version 1.0
 */
public class InputCheck {

    public boolean isValidPhoneNumber(String input) {

        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(input, null);
            return phoneNumberUtil.isValidNumber(parsedNumber);
        } catch (NumberParseException e) {
            return false;
        }

        /*if (input == null || input.isEmpty()) {
            return false;
        }

        String regex = "^\\+?[0-9\\-\\s()\\[\\]\\/]*$";

        if (input.length() < 20 && input.length() > 10) {
            if (input.matches(regex)) {
                return true;
            }
            return false;
        } else {
            return false;
        }*/
    }
}
