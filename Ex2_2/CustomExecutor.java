package part2;
/**
 * This class represents objects that are able to insert a task from Callable type into a queue
 *
 *
 * @author  Halel Itzhaki and Yehonatan Dilmoni
 * @version 1.0
 * @since   13.01.2023
 */

import java.util.Comparator;
import java.util.concurrent.*;


public class CustomExecutor {


    ThreadPoolExecutor myThreadPool;
    private static int numOfCores = Runtime.getRuntime().availableProcessors();
    static int corePoolSize = numOfCores/2;
    static int maxPoolSize = numOfCores-1;
    PriorityBlockingQueue myPriorityBlockingQueue;
    Integer theCurrentMaxInMyPriorityBlockingQueue;


    public CustomExecutor() throws Exception {
        myThreadPool = new ThreadPoolExecutor(corePoolSize,
                maxPoolSize,
                300,
                TimeUnit.MILLISECONDS,
                myPriorityBlockingQueue = new PriorityBlockingQueue<>(maxPoolSize));
        theCurrentMaxInMyPriorityBlockingQueue = 11;
    }

    /**
     * This method submit a Task to the queue, and update the current priority in to theCurrentMaxInMyPriorityBlockingQueue
     * @param task<T>, taskType - the callable task that we create and its priority
     * @return CustomFutureTask that represents the get from the call method
     */

    private CustomFutureTask mySubmit(Task task,TaskType taskType)  {
        if (task == null||taskType==null) {
            throw new NullPointerException();
        }
        myThreadPool.submit(task.getMyTask());
        theCurrentMaxInMyPriorityBlockingQueue = (Integer) myPriorityBlockingQueue.peek();
        CustomFutureTask futureTask = new CustomFutureTask( task.getMyTask(),taskType );
        try {
            futureTask.get(300, TimeUnit.MILLISECONDS);
            return futureTask;
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        } catch (ExecutionException e) {
            throw new RuntimeException( e );
        } catch (TimeoutException e) {
            throw new RuntimeException( e );
        }

    }

    /**
     * the regular submit that use mySubmit
     * @param task<T>, - the callable task that we create and its priority is OTHER
     * @return CustomFutureTask that represents the get from the call method
     */
    public CustomFutureTask submit(Task task){
        if (task == null){
            throw new NullPointerException();
        }
        return mySubmit( task, TaskType.OTHER );
    }

    /**
     * This method submit a Task to the queue, and update the current priority in to theCurrentMaxInMyPriorityBlockingQueue using mySucmit
     * @param task<T>, taskType - the callable task that we create and its priority
     * @return CustomFutureTask that represents the get from the call method
     */
    public CustomFutureTask submit(Task task,TaskType taskType){
        if (task == null || taskType ==null){
            throw new NullPointerException();
        }
        return mySubmit( task, taskType );
    }

    /**
     * This method submit a Callable to the queue, and update the current priority in to theCurrentMaxInMyPriorityBlockingQueue
     * @param task<T>, taskType - the callable task that we create and its priority
     * @return CustomFutureTask that represents the get from the call method
     */
    public CustomFutureTask submit(Callable task,TaskType taskType){
        if (task == null || taskType ==null){
            throw new NullPointerException();
        }
            return mySubmit( Task.createTask( task,taskType ), taskType );
    }



    /**
     * This method return theCurrentMaxInMyPriorityBlockingQueue
     * @return theCurrentMaxInMyPriorityBlockingQueue
     */
    public String getCurrentMax() {
        return theCurrentMaxInMyPriorityBlockingQueue.toString();
    }
    /**
     * This method shutDown the thread pool bur let all the task that already there to be completed
     * @return void
     */

    public void gracefullyTerminate() {
        myThreadPool.shutdown();
    }
}
