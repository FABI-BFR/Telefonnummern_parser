import controller.InputCheck;
import org.junit.Test;
import static org.junit.Assert.*;

public class InputCheckTest {

    /**
     * @verantwortlicher Fabian Eilber
     * @ziel Test der Funktionalität der InputCheck Klasse
     * @input Individuelle Telefonnummer
     * @output Validierung ob Telefonnummer korrekt ist in Form eines boolean
     * @überprüfung Gleichheit von output und erwartetem Ergebnis
     */
    @Test
    public void inputCheckValidNumber() {
        InputCheck inputCheck = new InputCheck();
        String validPhoneNumber = "+49 0201 43433";

        boolean result = inputCheck.isValidPhoneNumber(validPhoneNumber);

        assertTrue(result);
    }

    /**
     * @verantwortlicher Fabian Eilber
     * @ziel Test der Funktionalität der InputCheck Klasse
     * @input Falsche bzw. keine Telefonnummer
     * @output Validierung ob Telefonnummer korrekt ist in Form eines boolean
     * @überprüfung Gleichheit von output und erwartetem Ergebnis
     */
    @Test
    public void inputCheckInvalidNumber() {
        InputCheck inputCheck = new InputCheck();
        String invalidPhoneNumber = "invalid";

        boolean result = inputCheck.isValidPhoneNumber(invalidPhoneNumber);

        assertFalse(result);
    }
}
