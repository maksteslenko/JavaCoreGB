package LessonFour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, String> phonebook;

    public PhoneBook() {
        this.phonebook = new HashMap<>();
    }

    public void add(String phoneNumber, String surname) {
        phonebook.put(phoneNumber, surname.toLowerCase(Locale.ROOT));
    }

    public ArrayList<String> get(String surname) {
        ArrayList<String> numbers = new ArrayList<>();
        for (Map.Entry<String, String> element : phonebook.entrySet()) {
            if (element.getValue().equals(surname.toLowerCase(Locale.ROOT))) {
                numbers.add(element.getKey());
            }
        }
        return numbers;
    }
}
