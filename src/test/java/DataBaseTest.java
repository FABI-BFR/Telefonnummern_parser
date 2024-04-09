import data.PhoneNumber;
import org.junit.Test;
import persistence.Database;

import java.util.List;

import static org.junit.Assert.*;
public class DataBaseTest {

    /**
     * @verantwortlicher Fabian Unger
     * @ziel Test des Schreibens und Lesens der Datenbank-Klasse
     * @input Individuelle Telefonnummer
     * @output Telefonnummer aus Datenbank-Klasse einmal aus Liste und einmal über den Index
     * @überprüfung Gleichheit von input und beiden outpus
     */
    @Test
    public void writeReadDataBaseTest() {
        Database db = new Database();

        PhoneNumber expectedPhoneNumber = new PhoneNumber("+49 201 4511-33", "DE", "49", "201", "4511", "33");

        db.setPhoneNumber(0, expectedPhoneNumber);

        PhoneNumber testedPhoneNumberByIndex = db.getPhoneNumber(0);

        PhoneNumber testedPhoneNumberFromList = db.getAllNumbers().get(0);

        assertNotNull(testedPhoneNumberByIndex);
        assertNotNull(testedPhoneNumberFromList);
        assertEquals(expectedPhoneNumber.getOriginal(), testedPhoneNumberByIndex.getOriginal());
        assertEquals(expectedPhoneNumber.getOriginal(), testedPhoneNumberFromList.getOriginal());
    }

}
