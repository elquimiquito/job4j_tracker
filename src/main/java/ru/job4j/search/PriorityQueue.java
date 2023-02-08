package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {

    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        var i = 0;
        for (var current : tasks) {
            if (task.getPriority() < current.getPriority()) {
                break;
            }
            i++;
        }
        tasks.add(i, task);
    }

    public Task take() {
        return this.tasks.poll();
    }
}