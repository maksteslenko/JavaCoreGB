package LessonOne;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle[] obstacles) {
        this.obstacles = obstacles;
    }

    public void doIt(Team team) {
        System.out.println("Участники на полосе препятствий:");
        for (Obstacle element : obstacles) {
            team.tryPassObstacle(element);
            System.out.println();
        }
    }
}
