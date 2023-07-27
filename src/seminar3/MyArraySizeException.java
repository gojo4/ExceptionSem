package seminar3;

public class MyArraySizeException extends RuntimeException{
    public MyArraySizeException() {
        super("Массив должен быть 3x3");
    }
}
