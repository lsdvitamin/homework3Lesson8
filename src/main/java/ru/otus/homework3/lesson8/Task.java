package ru.otus.homework3.lesson8;

/**
 * @author Sergei on 28.09.2024 19:30.
 * @project homework3Lesson8
 */
public class Task implements Comparable<Task> {
    Integer id;
    String name;

    @Override
    public int compareTo(Task task) {
        if ((task.status.equals(Task.Status.OPEN) && (this.status.equals(Task.Status.WORKING) || this.status.equals(Task.Status.CLOSED))) ||
                (task.status.equals(Task.Status.WORKING) && (this.status.equals(Task.Status.CLOSED)))) {
            return 1;
        }
        return -1;
    }

    public enum Status {
        OPEN("Открыта"),
        WORKING("В работе"),
        CLOSED("Закрыта");

        final private String value;

        private Status(String s) {
            value = s;
        }
    }

    Status status;

    public Task(Integer id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = Status.valueOf(status);
    }
}