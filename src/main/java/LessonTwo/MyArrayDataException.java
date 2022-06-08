package LessonTwo;

public class MyArrayDataException extends NumberFormatException {
    int row;
    int column;

    public MyArrayDataException(int row, int column) {
        this.row = row;
        this.column = column;
    }

    @Override
    public String getMessage() {
        return "Невозможно преобразовать элемент с индексом [" + row + "][" + column + "]!";
    }
}
