import data.PhoneNumber;
import data_handling.Parser;
import org.junit.Test;
import static org.junit.Assert.*;

public class ParserTest {

    /**
     * @verantwortlicher Fabian Eilber
     * @ziel Test der Funktionalität der Funktion parseStringtoPhoneNumberEx in der Klasse Parser
     * @input Individuelle Telefonnummer
     * @output Telefonnummer in Einzelteile zerlegt
     * @überprüfung Gleichheit von input und erwartetem Ergebnis
     */
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


    /**
     * @verantwortlicher Fabian Eilber
     * @ziel Test der Funktionalität der Funktion parseStringtoPhoneNumberEx in der Klasse Parser
     * @input Falsche bzw. keine Telefonnummer
     * @output Telefonnummer in Einzelteile zerlegt
     * @überprüfung Gleichheit von input und erwartetem Ergebnis
     */
    @Test
    public void parseStringToPhoneNumberInvalid() {
        Parser parser = new Parser();
        String input = "54161651165561";

        PhoneNumber phoneNumber = parser.parseStringToPhoneNumberEx(input);

        assertNotNull(phoneNumber);
        assertEquals("54161651165561", phoneNumber.getOriginal());
        //assertEquals("", phoneNumber.getCountryShort());
        assertEquals("49", phoneNumber.getCountryCode());
        //assertEquals("", phoneNumber.getAreaCode());
        //assertEquals("", phoneNumber.getNumberCode());
        //assertEquals("", phoneNumber.getExtensionCode());
    }

    /**
     * @verantwortlicher Fabian Eilber
     * @ziel Test der Funktionalität der Funktion getExtension in der Klasse Parser
     * @input Individuelle Telefonnummer
     * @output Extension / Durchwahl
     * @überprüfung Gleichheit von input und erwartetem Ergebnis
     */
    @Test
    public void getExtensionTestValid() {
        Parser parser = new Parser();
        String input = "+49 201 4511-33";

        String extension = parser.getExtension(input);

        assertNotNull(extension);
        assertEquals("33", extension);
    }

    /**
     * @verantwortlicher Fabian Eilber
     * @ziel Test der Funktionalität der Funktion getExtension in der Klasse Parser
     * @input Individuelle Telefonnummer mit zu langer Durchwahl
     * @output Extension / Durchwahl
     * @überprüfung Gleichheit von input und erwartetem Ergebnis
     */
    @Test
    public void getExtensionTestInvalid() {
        Parser parser = new Parser();
        String input = "+49 201 4511-3333";

        String extension = parser.getExtension(input);

        assertEquals("", extension);
    }

}
