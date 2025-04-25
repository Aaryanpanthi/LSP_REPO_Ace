package org.howard.edu.lspfinal.question2;

/**
 * The Task class represents a task with a name, priority, and status.
 * It provides methods to access and modify these attributes.
 */
public class Task {
    private String name;
    private int priority;
    private String status;

    /**
     * Constructs a Task object with the specified name, priority, and status.
     *
     * @param name the unique name of the task
     * @param priority the priority level of the task (lower number = higher priority)
     * @param status the current status of the task (e.g., "TODO", "IN_PROGRESS", "DONE")
     */
    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    /**
     * Returns the name of the task.
     *
     * @return the task's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the priority of the task.
     *
     * @return the task's priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * Returns the current status of the task.
     *
     * @return the task's status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Updates the status of the task.
     *
     * @param status the new status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Returns a string representation of the task, including its name, priority, and status.
     *
     * @return a formatted string representing the task
     */
    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}
