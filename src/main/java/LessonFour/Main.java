package LessonFour;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("apple");
        words.add("orange");
        words.add("banana");
        words.add("apple");
        words.add("banana");
        words.add("lemon");
        words.add("apple");
        words.add("pineapple");
        words.add("apricot");
        words.add("lemon");
        words.add("banana");
        words.add("pineapple");
        words.add("apple");
        System.out.println(words);

        ArrayList<String> uniqueWordsList = new ArrayList<>();
        for (String element : words) {
            if (!uniqueWordsList.contains(element)) {
                uniqueWordsList.add(element);
            }
        }
        System.out.println("Уникальные элементы листа:");
        System.out.println(uniqueWordsList);

        HashMap<String, Integer> wordsCountMap = new HashMap<>();
        for (String element : words) {
            if (wordsCountMap.containsKey(element)) {
                wordsCountMap.put(element, wordsCountMap.get(element) + 1);
            } else {
                wordsCountMap.put(element, 1);
            }
        }
        System.out.println("Сколько раз встречается каждое слово:");
        System.out.println(wordsCountMap);


        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("+79996665544", "Petrov");
        phoneBook.add("+74546627342", "Ivanov");
        phoneBook.add("89234375712", "Markova");
        phoneBook.add("+12345678901", "Nikitin");
        phoneBook.add("+36354575839", "Petrova");
        phoneBook.add("+79838991827", "PETROV");
        phoneBook.add("+463576756888", "Pavlova");

        System.out.println(phoneBook.get("Petrov"));
        System.out.println(phoneBook.get("Markova"));
    }
}
