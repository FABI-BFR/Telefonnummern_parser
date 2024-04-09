import data.PhoneNumber;
import data_handling.Formatter;
import org.junit.Test;
import static org.junit.Assert.*;
public class FormatterTest {

    /**
     * @verantwortlicher Fabian Unger
     * @ziel Test der Funktionalität der Klasse Formatter
     * @input Individuelle Telefonnummer
     * @output Telefonnummer in Formatierung der Eingabe
     * @überprüfung Gleichheit von input und output
     */
    @Test
    public void formatterTestCorrectOutput() {
        String expectedOriginalNumber = "+49 823 [749-278] 979";

        PhoneNumber phoneNumber = new PhoneNumber(expectedOriginalNumber, "", "", "", "", "");
        Formatter formatter = new Formatter();
        String testOriginalNumber = formatter.getOriginalFormat(phoneNumber);

        assertEquals(expectedOriginalNumber, testOriginalNumber);
    }

}
