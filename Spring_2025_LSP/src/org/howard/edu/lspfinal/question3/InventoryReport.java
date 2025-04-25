package org.howard.edu.lspfinal.question3;

/**
 * InventoryReport is a concrete implementation of the abstract Report class.
 * It defines the specific behavior for generating an inventory report by
 * implementing the loadData, formatData, and printReport methods.
 */
public class InventoryReport extends Report {

    /**
     * Loads data specific to inventory. This method is part of the report generation workflow.
     */
    @Override
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    /**
     * Formats the loaded inventory data. This method is part of the report generation workflow.
     */
    @Override
    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    /**
     * Prints the final inventory report. This method is part of the report generation workflow.
     */
    @Override
    protected void printReport() {
        System.out.println("Printing inventory report.");
    }
}
