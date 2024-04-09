package controller;
/**
 * InputCheck prüft die Eingabe auf Korrektheit
 * @author fe
 * @version 1.0
 */
public class InputCheck {

    public boolean isValidPhoneNumber(String input) {
        if(input == null || input.isEmpty()) {
            return false;
        }

        String cleanInput = input.replace(" ","");

        if(cleanInput.length()<20 && cleanInput.length()>10){
            return !cleanInput.matches(".*[a-zA-Z]*.");
        }
        return true;
    }
}
