package part1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.Callable;

/**
 * This class represents Callable Task that count a num of line in a file
 * @author  Halel Itzhaki and Yehonatan Dilmoni
 * @version 1.0
 * @since   13.01.2023
 */
public class MyCallable implements Callable<Integer> {
    private String fileName;

    public MyCallable(String fileName) {
        this.fileName = fileName;
    }

    /**
     * This method count the num of line in the file
     * @return int that represent the num of the line in file
     */
    @Override
    public Integer call() throws Exception {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.readLine() != null) {
                count++;
            }
        }
        return count;
    }
}

