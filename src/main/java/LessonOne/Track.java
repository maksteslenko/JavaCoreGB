package LessonOne;

public class Track implements Obstacle{
    private int requiredEnergy;
    final String NAME = "Забег";

    public Track(int requiredEnergy) {
        this.requiredEnergy = requiredEnergy;
    }

    @Override
    public void pass(Player player) {
        player.spendEnergy(requiredEnergy);
        System.out.println(player.getName() + " проходит препятствие \"" + NAME + "\"!");
    }

    @Override
    public void fail(Player player) {
        player.tired();
        System.out.println(player.getName() + " не может пройти препятствие \"" + NAME + "\" ...");
    }

    @Override
    public int getRequiredEnergy() {
        return requiredEnergy;
    }
}
