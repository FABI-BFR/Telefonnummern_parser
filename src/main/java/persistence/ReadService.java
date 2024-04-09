package persistence;

import data.PhoneNumber;

import java.util.List;

/**
 * The ReadService interface defines methods for reading operations.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */

public interface ReadService {

    PhoneNumber getPhoneNumber(int id);

    List<PhoneNumber> getAllNumbers();

}
