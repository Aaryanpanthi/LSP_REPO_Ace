package org.howard.edu.lspfinal.question3;

/**
 * SalesReport is a concrete subclass of the abstract Report class.
 * It provides specific implementations for loading, formatting, and printing
 * a sales report. These methods are part of the template method pattern
 * defined in the Report base class.
 */
public class SalesReport extends Report {

    /**
     * Loads data related to sales. Called as part of the report generation workflow.
     */
    @Override
    protected void loadData() {
        System.out.println("Loading sales data...");
    }

    /**
     * Formats the loaded sales data. Called as part of the report generation workflow.
     */
    @Override
    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    /**
     * Prints the finalized sales report. Called as part of the report generation workflow.
     */
    @Override
    protected void printReport() {
        System.out.println("Printing sales report.");
    }
}
