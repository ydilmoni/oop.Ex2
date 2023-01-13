package part1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class represents Thread that count a num of line in a file
 * @author  Halel Itzhaki and Yehonatan Dilmoni
 * @version 1.0
 * @since   13.01.2023
 */
public class MyThread extends Thread{
    private int lineCounter=0;

    MyThread (String name){
        super(name);
        lineCounter = 0;
    }

    public int getLineCounter() {
        return lineCounter;
    }
    /**
     * This method count the num of line in the file
     * @return int that represent the num of the line in file
     */
    public void run(){
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(this.getName()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (true){
            try {
                if (!(reader.readLine()!=null)) break;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            lineCounter++;
        }

    }
}
