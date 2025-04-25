
//for custom exception used assignment 6 as an example. 
// https://www.w3schools.com/java/java_hashmap.asp 


package org.howard.edu.lspfinal.question2;


import java.util.*;

/**
 * The TaskManager class provides functionality to manage a collection of Task objects.
 * It supports adding new tasks, retrieving tasks by name, updating task status,
 * and printing tasks grouped by their current status.
 *
 * <p>Custom exceptions such as {@link DuplicateTaskException} and {@link TaskNotFoundException}
 * are used to handle invalid operations like adding duplicate tasks or retrieving non-existent ones.</p>
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new task to the task manager.
     *
     * @param name the unique name of the task
     * @param priority the priority level of the task (lower number = higher priority)
     * @param status the initial status of the task (e.g., "TODO", "IN_PROGRESS", "DONE")
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Retrieves a task by its name.
     *
     * @param name the name of the task to retrieve
     * @return the Task object associated with the given name
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    /**
     * Updates the status of an existing task.
     *
     * @param name the name of the task to update
     * @param status the new status to assign to the task
     * @throws TaskNotFoundException if no task with the given name exists
     */
    public void updateStatus(String name, String status) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(status);
    }

    /**
     * Prints all tasks grouped by their current status ("TODO", "IN_PROGRESS", or "DONE").
     * If a status category has no tasks, it will still be printed with no items listed.
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
