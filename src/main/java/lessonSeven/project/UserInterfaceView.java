package lessonSeven.project;

import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() throws IOException {
        Scanner scanner = new Scanner(System.in);

        String city;
        do {
            System.out.println("Введите название города на русском:");
            city = scanner.nextLine();
        } while (!controller.isCityValid(city));

        while (true) {
            System.out.println("Введите 1 для получения погоды на сегодня. " +
                    "Введите 5 для прогноза на 5 дней. Для выхода введите 0:");
            String command = scanner.nextLine();

            if (controller.isCommandValid(command)) {
                if (command.equals("0")) break;

                try {
                    controller.getWeather(command, city);
                } catch (IOException e) {
                    System.out.println("При получении погоды произошла ошибка. Повторите попытку позднее.");
                }
            } else {
                System.out.println("Введённой команды не существует. Попробуйте еще раз");
                continue;
            }
        }
    }
}
