package ru.otus.homework3.lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Sergei on 28.09.2024 19:26.
 * @project Default (Template) Project
 */
public class Main {
    public static void main(String[] args) {

        Task task1 = new Task(1, "Eating", Task.Status.CLOSED.toString());
        Task task2 = new Task(2, "Init", Task.Status.OPEN.toString());
        Task task3 = new Task(3, "Run", Task.Status.WORKING.toString());
        Task task4 = new Task(4, "Hiking", Task.Status.CLOSED.toString());
        Task task5 = new Task(5, "Jogging", Task.Status.CLOSED.toString());

        List<Task> tasks = new ArrayList<>();
        tasks.add(task1);
        tasks.add(task2);
        tasks.add(task3);
        tasks.add(task4);
        tasks.add(task5);

        List<Task> tasksWorking = tasks.stream()
                .filter(task -> task.status.equals(Task.Status.WORKING)).toList();

        Integer cntClosed = Math.toIntExact(tasks.stream()
                .filter(task -> task.status.equals(Task.Status.CLOSED)).count());

        Boolean exists2AndNotExists99 =
                tasks.stream().noneMatch(task -> task.id == 99) &&
                        tasks.stream().anyMatch(task -> task.id == 2);


        List<Task> tasksSorted = tasks.stream()
                .sorted((t1, t2) -> t1.status.compareTo(t2.status)).
                collect(Collectors.toList());

        System.out.println();
    }
}
