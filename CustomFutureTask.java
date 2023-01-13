package part2;

import java.util.concurrent.*;
/**
 * This class represents objects that are able to get the return value from a Task type
 * @author  Halel Itzhaki and Yehonatan Dilmoni
 * @version 1.0
 * @since   13.01.2023
 */
public class CustomFutureTask<T> extends FutureTask<T> implements Comparable<CustomFutureTask> {

    TaskType taskPriority;

    public CustomFutureTask(Callable<T> callable) {
        super( callable );
        taskPriority = TaskType.OTHER;
    }
    public CustomFutureTask(Callable<T> callable, TaskType taskType) {
        super( callable );
        taskPriority = taskType;
    }



    /**
     * This method do the regular get of FutureTask
     * @return void
     */
    public T get() throws InterruptedException, ExecutionException {
        return super.get();
    }


    /**
     * This method compare between the priority of the task
     * @return int
     */
    @Override
    public int compareTo(CustomFutureTask o) {
        if (this.taskPriority.getPriorityValue() > o.taskPriority.getPriorityValue())
            return 1;
        else if (this.taskPriority.getPriorityValue() < o.taskPriority.getPriorityValue())
            return -1;
        return 0;
    }
}
