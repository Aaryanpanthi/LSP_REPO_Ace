package org.howard.edu.lspfinal.question2;

/**
 * Exception thrown when a task with the same name already exists.
 */
public class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}
