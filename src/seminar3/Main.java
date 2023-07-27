package seminar3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{0, 1, 2, null, 1, null};
        emptyArrExample(array, 2);
        try {
            notFoundFile("Taskgdsfgsds.txt");
        } catch (NonExistedFileException e) {
            System.out.println(e.getMessage());
        }catch (FileNotFoundException e){
            throw new RuntimeException();
        }
    }

    private static void emptyArrExample(Integer[] array, int index) {
        if (array[index] == null) {
            throw new EmptyIndexAppealException();
        }
        System.out.println(array[index]);
    }

    private static void notFoundFile(String path) throws FileNotFoundException, NonExistedFileException {
        File file = new File(path);
        if (!file.exists()) {
            throw new NonExistedFileException();
        }
        FileReader fileReader = new FileReader(path);
    }
}
