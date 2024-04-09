import data.PhoneNumber;
import data_handling.Parser;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {

    @Test
    public void parseStringToPhoneNumberValid() {
        Parser parser = new Parser();
        String input = "+49 201 4511-33";

        PhoneNumber phoneNumber = parser.parseStringToPhoneNumberEx(input);

        assertNotNull(phoneNumber);
        assertEquals("+49 201 4511-33", phoneNumber.getOriginal());
        assertEquals("DE", phoneNumber.getCountryShort());
        assertEquals("49", phoneNumber.getCountryCode());
        assertEquals("201", phoneNumber.getAreaCode()); // Assuming no area code in this case
        assertEquals("4511", phoneNumber.getNumberCode());
        assertEquals("33", phoneNumber.getExtensionCode()); // Assuming no extension in this case
    }
}
