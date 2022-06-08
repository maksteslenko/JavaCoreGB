package LessonThree;

public class Apple extends Fruit{
    final float WEIGHT = 1f;
    String color;

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                '}';
    }

    public Apple(String color) {
        this.color = color;
    }

    public float getWEIGHT() {
        return WEIGHT;
    }
}
