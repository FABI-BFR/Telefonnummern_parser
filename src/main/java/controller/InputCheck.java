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

    /**
     * Validates the given phonenumber
     *
     * @param input phone number as string
     * @return boolean (true or false) depending on the validation.
     */
    public boolean isValidPhoneNumber(String input) {

        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        try {
            Phonenumber.PhoneNumber parsedNumber = phoneNumberUtil.parse(input, null);
            return phoneNumberUtil.isValidNumber(parsedNumber);
        } catch (NumberParseException e) {
            return false;
        }
    }
}
