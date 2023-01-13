package part2;


import java.util.Comparator;
import java.util.concurrent.Callable;

import static part2.TaskType.*;
/**
 * This class represents Callable Task that are able to compare between is a Task type
 * @author  Halel Itzhaki and Yehonatan Dilmoni
 * @version 1.0
 * @since   13.01.2023
 */

public class Task<T> implements Comparable <Task<T>>,Callable <T>, Comparator<Task<T>> {

    private TaskType taskType;
    private Callable<T> myTask;

    //constractor
    public Task(Callable<T> task, TaskType type) {
        this.myTask = task;
        this.taskType = type;
    }

    //constractor
    public Comparator<Task> comparator() throws Exception {
        return (Comparator<Task>) this.myTask.call();
    }

    public Callable<T> getMyTask() {
        return myTask;
    }

    //Factory constractor
    public static Task createTask(Callable callable, TaskType type) {
        return new Task(callable,type);
    }
    //Factory constractor
    public static Task createTask(Callable callable) {
        return new Task(callable, OTHER);
    }

    public TaskType getTaskType() {
        return taskType;
    }
    public int getTaskTypeValue() {
        return taskType.getPriorityValue();
    }

    @Override
    public int compareTo(Task o) {
        return this.getTaskTypeValue()-o.getTaskTypeValue();
    }

    @Override
    public T call() throws Exception {
        return this.myTask.call();
    }

    @Override
    public int compare(Task<T> o1, Task<T> o2) {
        return o1.compareTo( o2 );
    }
}
