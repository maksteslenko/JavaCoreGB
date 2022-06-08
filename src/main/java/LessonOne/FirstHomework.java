package LessonOne;

public class FirstHomework {
    public static void main(String[] args) {
        Player[] players = new Player[]{
                new Player("Лена", 35),
                new Player("Федя", 20),
                new Player("Даша", 40),
                new Player("Рома", 50),
        };
        Team team = new Team("Дружба", players);
        team.getTeamPlayers();

        Obstacle[] obstacles = new Obstacle[]{
                new Pool(8),
                new Track(16),
                new Wall(12),
        };
        Course course = new Course(obstacles);

        course.doIt(team);
        team.showResults();
    }
}
