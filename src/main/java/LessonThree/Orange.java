package LessonThree;

public class Orange extends Fruit{
    final float WEIGHT = 2f;
    String size;

    @Override
    public String toString() {
        return "Orange{" +
                "size='" + size + '\'' +
                '}';
    }

    public Orange(String size) {
        this.size = size;
    }

    public float getWEIGHT() {
        return WEIGHT;
    }
}
