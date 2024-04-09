package persistence;

import data.PhoneNumber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Database implements ReadService, WriteService {

    private Map<Integer, PhoneNumber> list = new HashMap();

    @Override
    public PhoneNumber getPhoneNumber(int id) {
        return this.list.get(id);
    }

    @Override
    public void setPhoneNumber(int id, PhoneNumber number) {
        this.list.put(id, number);
    }

    @Override
    public List<PhoneNumber> getAllNumbers() {
        List<PhoneNumber> numbers = new ArrayList<>();
        for (PhoneNumber number : list.values()) {
            numbers.add(number);
        }
        return numbers;
    }

}
