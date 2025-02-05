import java.util.Scanner;

class Employee {
    String name, id;
    double hourlyRate, hoursWorked, taxRate;
    static Employee[] employees = new Employee[100];
    static int employeeCount = 0;

    Employee(String id, String name, double hourlyRate, double hoursWorked, double taxRate) {
        this.id = id;
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
        this.taxRate = taxRate;
    }

    double calculateGrossSalary() {
        return hourlyRate * hoursWorked;
    }

    double calculateTax() {
        return calculateGrossSalary() * (taxRate / 100);
    }

    double calculateNetSalary() {
        return calculateGrossSalary() - calculateTax();
    }

    void displayPayslip() {
        System.out.println("\n======= Payslip =======");
        System.out.println("Employee ID   : " + id);
        System.out.println("Employee Name : " + name);
        System.out.println("Hourly Rate   : Rs=" + hourlyRate);
        System.out.println("Hours Worked  : " + hoursWorked);
        System.out.println("Gross Salary  : Rs=" + calculateGrossSalary());
        System.out.println("Tax Deducted  : Rs=" + calculateTax());
        System.out.println("Net Salary    : Rs=" + calculateNetSalary());
        System.out.println("===========================");
    }
}

public class PayrollSystem {
    static Scanner sc = new Scanner(System.in);

    static void insertEmployee() {
        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Hourly Rate: ");
        double hourlyRate = sc.nextDouble();
        System.out.print("Enter Hours Worked: ");
        double hoursWorked = sc.nextDouble();
        System.out.print("Enter Tax Percentage: ");
        double taxRate = sc.nextDouble();
        sc.nextLine();

        Employee.employees[Employee.employeeCount++] = new Employee(id, name, hourlyRate, hoursWorked, taxRate);
        System.out.println("Employee added successfully!\n");
    }

    static void displayEmployees() {
        if (Employee.employeeCount == 0) {
            System.out.println("No employees found!\n");
            return;
        }
        for (int i = 0; i < Employee.employeeCount; i++) {
            Employee.employees[i].displayPayslip();
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nPayroll System");
            System.out.println("1. Insert Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch (choice) {
                case 1:
                    insertEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    System.out.println("Exiting...\n");
                    return;
                default:
                    System.out.println("Invalid choice, try again!\n");
            }
        }
    }
}