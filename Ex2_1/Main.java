package part1;

import static part1.Ex2_1.*;

public class Main {
    public static void main(String[] args) throws Exception {
        String[] arr = createTextFiles(500,85,90);


        double startTimeWithoutThread = System.nanoTime();
        int numOfLineWithoutThread = getNumOfLines(arr);
        double totalWithoutThread = (System.nanoTime()-startTimeWithoutThread)/1000000000;//give me the time in second
        System.out.println("total time with no thread : " +totalWithoutThread);


        double startTimeWithThread = System.nanoTime();
        int numOfLineWithThread = getNumOfLinesThreads(arr);
        double totalTimeWithThread = (System.nanoTime()-startTimeWithThread)/1000000000;//secound
        System.out.println("total time with thread : "+totalTimeWithThread );

        ///////////////////////////////////////////////////////////////////////////////////
        double startTimeWithThreadPool = System.nanoTime();
        int numOfLineWithThreadPool = getNumOfLinesThreadPool(arr);
        double totalTimeWithThreadPool = (System.nanoTime()-startTimeWithThread)/1000000000;//secound
        System.out.println("total time with threadPool : "+totalTimeWithThreadPool );

        ///////////////////////////////////////////////////////////////////////////////////




        if (numOfLineWithThread == numOfLineWithoutThread && numOfLineWithThread== numOfLineWithThreadPool){
            System.out.println("the total num of line is : "+numOfLineWithThread);
        }
        else {
            System.out.println("the sum in every method is not the same");
            System.out.println("the num of line without thread is : " + numOfLineWithoutThread);
            System.out.println("the num of line with thread is : " + numOfLineWithThread);
            System.out.println("the num of line with threadPool is : " + numOfLineWithThreadPool);

        }




    }
}