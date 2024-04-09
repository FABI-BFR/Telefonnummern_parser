package controller;

/**
 * InputCheck prüft die Eingabe auf Korrektheit
 *
 * @author fe
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
