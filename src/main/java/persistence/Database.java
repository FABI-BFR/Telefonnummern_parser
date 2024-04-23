package persistence;

import data.PhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Database class represents the storage.
 * <p>
 * @version 1.0
 * @author Fabian Unger
 */

public class Database implements ReadService, WriteService {

    private Map<Integer, PhoneNumber> list = new HashMap();

    /**
     * Returns the phonenumber for a certain id
     *
     * @param id phonenumberid
     * @return phonenumber
     */
    @Override
    public PhoneNumber getPhoneNumber(int id) {
        return this.list.get(id);
    }

    /**
     * Sets a phonenumber for a specific id
     *
     * @param id phonenumberid
     * @param number phonenumber
     */
    @Override
    public void setPhoneNumber(int id, PhoneNumber number) {
        this.list.put(id, number);
    }

    /**
     * Returns all phonenumber
     *
     * @return List of phonenumbers
     */
    @Override
    public List<PhoneNumber> getAllNumbers() {
        List<PhoneNumber> numbers = new ArrayList<>();
        for (PhoneNumber number : list.values()) {
            numbers.add(number);
        }
        return numbers;
    }

}
