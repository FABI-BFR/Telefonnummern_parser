package persistence;

import data.PhoneNumber;

/**
 * The WriteService interface defines methods for writing operations.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */
public interface WriteService {

    void setPhoneNumber(int id, PhoneNumber number);
}
