package LessonOne;

public class Team {
    private String teamName;
    private Player[] players;

    public Team(String teamName, Player[] players) {
        this.teamName = teamName;
        this.players = players;
    }

    public void getTeamPlayers() {
        System.out.println("В команду \"" + teamName + "\" входят:");
        for (Player element : players) {
            System.out.println(element.getName());
        }
        System.out.println();
    }

    public void showResults() {
        System.out.println("Результаты:");
        for (Player player : players) {
            if (!player.isOut()) {
                System.out.println(player.getName() + " выполнил(а) все препятствия!!!");
            }
        }
    }

    public void tryPassObstacle(Obstacle obstacle) {
        for (Player player : players) {
            if (player.isEnoughStaminaForObstacle(obstacle) && !player.isOut()) {
                obstacle.pass(player);
            } else {
                obstacle.fail(player);
            }
        }
    }
}
