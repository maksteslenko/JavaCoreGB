package LessonThree;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"a", "b", "c", "d"};
        System.out.println(Arrays.toString(strings));
        changeArrayElements(strings, 0, 2);
        System.out.println(Arrays.toString(strings));

        Apple greenApple = new Apple("Зеленое");
        Apple redApple = new Apple("Красное");
        Apple yellowApple = new Apple("Желтое");
        Apple[] appleArray1 = {greenApple, redApple, yellowApple};
        ArrayList<Apple> apples1 = new ArrayList<>(Arrays.asList(appleArray1));
        Box<Apple> appleBox1 = new Box<>(apples1);

        Apple brownApple = new Apple("Коричневое");
        Apple blueApple = new Apple("Голубое");
        Apple[] appleArray2 = {brownApple, blueApple};
        ArrayList<Apple> apples2 = new ArrayList<>(Arrays.asList(appleArray2));
        Box<Apple> appleBox2 = new Box<>(apples2);

        Orange bigOrange = new Orange("Большой");
        Orange smallOrange = new Orange("Маленький");
        Orange[] orangesArray = {bigOrange, smallOrange};
        ArrayList<Orange> oranges = new ArrayList<>(Arrays.asList(orangesArray));
        Box<Orange> orangeBox1 = new Box<>(oranges);

        System.out.println(appleBox1.getWeight());
        System.out.println(orangeBox1.getWeight());

        System.out.println(appleBox1.compare(orangeBox1));

        System.out.println(appleBox1);
        System.out.println(appleBox2);

        appleBox1.moveAllFruitsTo(appleBox2);

        System.out.println(appleBox1);
        System.out.println(appleBox2);
    }

    public static <T>void changeArrayElements(T[] array, int firstIndex, int secondIndex) {
        T arrayElement = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = arrayElement;
    }
}
