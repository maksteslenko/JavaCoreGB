package LessonFive;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] header = {"год выпуска", "пробег тыс км", "цена тыс руб"};
        Integer[][] data = {
                {2002, 250, 780},
                {2016, 12, 3450},
                {2022, 1, 12000}};

        AppData carsData = new AppData(header, data);
        save(carsData, "carsInfo.csv");

        AppData newCarsData = new AppData();
        newCarsData = read("carsInfo.csv");
        save(newCarsData, "newCarsInfo.csv");
    }

    public static void save(AppData data, String fileName) {
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            for (int i = 0; i < data.getHeader().length; i++) {
                out.write(data.getHeader()[i].getBytes(StandardCharsets.UTF_8));
                if (i + 1 != data.getHeader().length) {
                    out.write(";".getBytes(StandardCharsets.UTF_8));
                } else {
                    out.write("\n".getBytes(StandardCharsets.UTF_8));
                }
            }
            for (int i = 0; i < data.getData().length; i++) {
                for (int j = 0; j < data.getData()[i].length; j++) {
                    out.write(data.getData()[i][j].toString().getBytes(StandardCharsets.UTF_8));
                    if (j + 1 != data.getData()[i].length) {
                        out.write(";".getBytes(StandardCharsets.UTF_8));
                    } else {
                        out.write("\n".getBytes(StandardCharsets.UTF_8));
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static AppData read(String fileName) {
        AppData appData = new AppData();
        try (BufferedReader buff = new BufferedReader(new FileReader(fileName))) {
            String[] params = buff.readLine().split(";");
            appData.setHeader(params);

            String line;
            ArrayList<ArrayList<Integer>> tempInt = new ArrayList<>();
            while ((line = buff.readLine()) != null) {
                ArrayList<Integer> tempList = new ArrayList<>();
                String[] dataInLine = line.split(";");
                for (String element : dataInLine) {
                    tempList.add(Integer.parseInt(element));
                }
                tempInt.add(tempList);
            }

            Integer[][] intArray = new Integer[tempInt.size()][tempInt.get(0).size()];
            for (int i = 0; i < tempInt.size(); i++) {
                tempInt.get(i).toArray(intArray[i]);
            }
            appData.setData(intArray);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return appData;
    }
}
