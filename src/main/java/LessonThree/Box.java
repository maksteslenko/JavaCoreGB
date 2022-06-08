package LessonThree;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> fruits;

    public Box(ArrayList<T> fruits) {
       this.fruits = fruits;
    }

    public double getWeight() {
        return fruits.get(0).getWEIGHT() * fruits.size();
    }

    public boolean compare(Box<?> another) {
        return this.getWeight() == another.getWeight();
    }

    public void addFruit(T fruit) {
        this.fruits.add(fruit);
    }

    public void moveAllFruitsTo(Box<T> another) {
        System.out.println("Высыпаем содержимое коробки...");
        for (T fruit : fruits) {
            another.addFruit(fruit);
        }
        fruits.clear();
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruits=" + fruits +
                '}';
    }
}
