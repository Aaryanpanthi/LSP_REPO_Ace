
//stackoverflow.com/questions/7508498/how-to-create-a-subclass-in-eclipse

//https://stackoverflow.com/questions/17024020/how-can-i-create-a-subclass-of-an-abstract-class-automatically-in-eclipse-in-jav
//https://www.geeksforgeeks.org/template-method-design-pattern/ 


package org.howard.edu.lspfinal.question3;

public class Driver {
    public static void main(String[] args) {
        Report sales = new SalesReport();
        sales.generateReport();
        System.out.println();

        Report inventory = new InventoryReport();
        inventory.generateReport();
    }
}

