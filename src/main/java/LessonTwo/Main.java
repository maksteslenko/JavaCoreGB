package LessonTwo;

public class Main {
    public static void main(String[] args) {
        String[][] myArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "0", "1", "2"},
                {"3", "4", "5", "6"}
        };

        try {
            elementsSum(myArray);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void elementsSum(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            if ((array[i].length != 4) || (array.length != 4)) {
                throw new MyArraySizeException("Неверный размер массива!");
            }
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        System.out.println(sum);
    }
}
