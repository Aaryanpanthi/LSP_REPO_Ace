package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Manages a collection of tasks with operations to add, retrieve, update, and group by status.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the manager.
     * @param name the name of the task
     * @param priority the priority of the task
     * @param status the initial status
     * @throws DuplicateTaskException if the task already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     * @param name the name of the task
     * @return the task
     * @throws TaskNotFoundException if the task doesn't exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    /**
     * Updates the status of an existing task.
     * @param name the name of the task
     * @param status the new status
     * @throws TaskNotFoundException if the task doesn't exist
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their status.
     */
    public void printTasksGroupedByStatus() {
        System.out.println("Tasks grouped by status:");
        Map<String, List<Task>> grouped = new HashMap<>();

        for (Task task : tasks.values()) {
            grouped.computeIfAbsent(task.getStatus(), k -> new ArrayList<>()).add(task);
        }

        for (String status : Arrays.asList("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            List<Task> list = grouped.getOrDefault(status, new ArrayList<>());
            for (Task task : list) {
                System.out.println("  " + task);
            }
        }
    }
}
