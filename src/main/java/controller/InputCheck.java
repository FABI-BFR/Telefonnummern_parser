package controller;

/**
 * The InputCheck class is checking the input before it is further processed.
 *
 * @author Fabian Eilber
 * @version 1.0
 */
public class InputCheck {

    public boolean isValidPhoneNumber(String input) {
        if (input == null || input.isEmpty()) {
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
        }
    }
}
