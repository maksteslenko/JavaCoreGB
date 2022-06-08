package LessonOne;

public interface Obstacle {
    void pass(Player player);
    void fail(Player player);
    int getRequiredEnergy();
}
