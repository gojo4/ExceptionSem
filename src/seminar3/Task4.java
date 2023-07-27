package seminar3;

import java.util.ArrayList;
import java.util.List;

/**
 * Напишите метод, на вход которого подаётся двумерный строковый массив размером 3х3.
 * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * <p>
 * 1. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе массива преобразование не удалось
 * (например, в ячейке лежит символ или текст вместо числа), должно быть брошено исключение MyArrayDataException
 * с детализацией, в какой именно ячейке лежат неверные данные.
 * <p>
 * 2. В методе main() вызвать полученный метод, обработать возможные исключения
 * MyArraySizeException и MyArrayDataException и вывести результат расчета
 * (сумму элементов, при условии, что подали на вход корректный массив).
 */
public class Task4 {
    static String[][] arr = new String[][]{
            {"1", "b", "1.5"},
            {"1", "1.5", "1.5"},
            {"1", "1.5", "a"}
    };

    public static void main(String[] args) {
//        System.out.println(sum2d(arr));
        System.out.println(sum2dPoints(arr));
    }

    public static double sum2d(String[][] arr) {
        if (isNotSquareArray(arr)) {
            throw new MyArraySizeException();
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (isNotDigit(arr[i][j])) {
                    throw new MyArrayDataException(i, j);
                }
                sum += Double.parseDouble(arr[i][j]);
            }
        }
        return sum;
    }

    public static double sum2dPoints(String[][] arr) {
        List<Point2D> list = new ArrayList<>();
        if (isNotSquareArray(arr)) {
            throw new MyArraySizeException();
        }
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (isNotDigit(arr[i][j])) {
                    list.add(new Point2D(i, j));
                } else {
                    sum += Double.parseDouble(arr[i][j]);
                }
            }
        }
        if (!list.isEmpty()){
            throw new MyArrayDataException(list);
        }
        return sum;
    }

    private static boolean isNotDigit(String str) {
        try {
            Double.parseDouble(str);
            return false;
        } catch (NumberFormatException e) {
            return true;
        }
    }

    private static boolean isNotSquareArray(String[][] arr) {
        if (arr.length != 3) {
            return true;
        }
        for (String[] strings : arr) {
            if (strings.length != arr.length) {
                return true;
            }
        }
        return false;
    }
}