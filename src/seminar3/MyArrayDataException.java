package seminar3;

import java.util.List;

public class MyArrayDataException extends RuntimeException{
    public MyArrayDataException(List<Point2D> points) {
        super(String.format("В ячейках %s не числа", points));
    }

    public MyArrayDataException(int i, int j) {
        super(String.format("В ячейке [%s][%s] не число!", i, j));
    }
}
