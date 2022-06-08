package LessonOne;

public class Player {
    private final String name;
    private int stamina;
    private boolean isTired;

    public Player(String name, int stamina) {
        this.name = name;
        this.stamina = stamina;
    }

    public String getName() {
        return name;
    }

    public void spendEnergy(int requiredEnergy) {
        stamina -= requiredEnergy;
    }

    public boolean isEnoughStaminaForObstacle(Obstacle obstacle) {
        return stamina >= obstacle.getRequiredEnergy();
    }

    public void tired() {
        isTired = true;
    }

    public boolean isOut() {
        return isTired;
    }
}
