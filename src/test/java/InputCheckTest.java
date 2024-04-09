import controller.InputCheck;
import org.junit.Test;
import static org.junit.Assert.*;

public class InputCheckTest {

    @Test
    public void inputCheckValidNumber() {
        InputCheck inputCheck = new InputCheck();
        String validPhoneNumber = "+49 0201 43433";

        boolean result = inputCheck.isValidPhoneNumber(validPhoneNumber);

        assertTrue(result);
    }

    @Test
    public void inputCheckInvalidNumber() {
        InputCheck inputCheck = new InputCheck();
        String invalidPhoneNumber = "invalid";

        boolean result = inputCheck.isValidPhoneNumber(invalidPhoneNumber);

        assertFalse(result);
    }
}