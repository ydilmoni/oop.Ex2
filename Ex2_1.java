package part1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Ex2_1 {

    /**
     * This class create several text files at the request of the user
     * Know how to count the total number of lines of the files in several ways
     * @author  Halel Itzhaki and Yehonatan Dilmoni
     * @version 1.0
     * @since   13.01.2023
     */

    /**
     * This method create one text file
     *  @param i- for the file's name. numOfLine- the num of the line in this file.
     * @return return the name of the file name
     */
    public static String createTextFile (int i, int numOfLine) {
        String fileName = "file_" + i + ".txt";
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName);
            for (int k = 0; k < numOfLine - 1; k++) {
                writer.append("hello world \n");
            }
            writer.append("hello world");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * This method create several text file using createTextFile
     * the method randomly (with seed) give to createTextFile the num of line
     *@param n- the num of files that the user want.
     *        seed- the seed that the user want.
     *        bound- the bound of the random nuber.
     * @return return Array with all the file's names
     */
    public static String[] createTextFiles(int n, int seed, int bound){
        Random random=new Random(seed);
        String[] fileNames = new String[n];
        for (int i =0; i<n; i++){
            int lines = random.nextInt(bound);
            fileNames[i] = createTextFile(i,lines+5000);

        }
        System.out.println("end of createTextFiles's funcsion");
        return fileNames;
    }


    /**
     * This method return the num of line from all the files in a Array's string
     *@param fileNames Array whte the nama of the files ew want to count there line
     * @return the total number of line
     */
    public static int getNumOfLines(String[] fileNames) {
        System.out.println("start to count the num of line");
        if (fileNames.length ==0){
            return 0;
        }

        int lineCounter = 0;
        for (String name:fileNames) {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(name));
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
        System.out.println("end to count the num of line");
        return lineCounter;
    }
    /**
     * This method return the num of line from all the files in a Array's string
     *@param fileNames Array whte the nama of the files ew want to count there line
     * @return the total number of line using thread
     */
    public static int getNumOfLinesThreads(String[] fileNames) {
        System.out.println("start to count the num of line with thread");
        int totalOfLine=0;
        for (int i = 0; i < fileNames.length ; i++) {
            MyThread myThread = new MyThread(fileNames[i]);
            myThread.run();
            try {
                myThread.join();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            totalOfLine += myThread.getLineCounter();
        }
        System.out.println("end to count the num of line with thread");
        return totalOfLine;
    }


    /**
     * This method return the num of line from all the files in a Array's string
     *@param fileNames Array whte the nama of the files ew want to count there line
     * @return the total number of line using threadPool
     */
    public static int getNumOfLinesThreadPool(String[] fileNames) throws Exception {
        System.out.println("start to count the num of line with threadPool");
        // Create a fixed-size thread pool with fileName.length threads
        int totalNumOfLines = 0;
        ExecutorService myThreadPool = Executors.newFixedThreadPool(fileNames.length);
        List<Future<Integer>> resultList = new ArrayList<>();

        for (int i = 0; i < fileNames.length; i++) {
            Future<Integer> result = myThreadPool.submit(new MyCallable(fileNames[i]));
            resultList.add(result);
        }

        for (Future<Integer> result :resultList) {
            totalNumOfLines += result.get().intValue();
        }

        // Shut down the thread pool
        myThreadPool.shutdown();
        System.out.println("end to count the num of line with thread pool");
        return totalNumOfLines;

    }



}
