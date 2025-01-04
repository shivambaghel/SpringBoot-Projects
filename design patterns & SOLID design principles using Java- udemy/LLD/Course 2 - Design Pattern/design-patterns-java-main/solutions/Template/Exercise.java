package Template;

import java.util.Scanner;

public class Exercise {
    
    public void run() {
        
        Scanner sc = new Scanner(System.in);
        
        // Generate Sales Report
        ReportTemplate salesReport = new SalesReport(sc);
        System.out.println("Generating Sales Report:");
        salesReport.generateReport();
        
        // Generate Employee Report
        ReportTemplate employeeReport = new EmployeeReport(sc);
        System.out.println("Generating Employee Report:");
        employeeReport.generateReport();
        
        // Generate Inventory Report
        ReportTemplate inventoryReport = new InventoryReport(sc);
        System.out.println("Generating Inventory Report:");
        inventoryReport.generateReport();
    }
}