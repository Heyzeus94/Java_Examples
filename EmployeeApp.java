public class EmployeeApp {
    public static void main(String[] args){
        Employee employee1 = new Employee("Susan Meyers", 47899, "Accounting", "VP", 89000);
        Employee employee2 = new Employee("Mark Jones", 39119, "IT", "Programmer", 67000);
        Employee employee3 = new Employee("Joy Rogers", 81774, "Manufacturing", "Engineer", 66000);
        Employee employee4 = new Employee("John Doe", 55555, "Sales", "Representative", -35000); // Bad data
        Employee employee5 = new Employee("James Blue", 44444, "IT", "CTO", 123000); //Bad data
        // Employee 4 and 5 have invalid salaries since they are not within the range od 0 and 90000

        // Display the data
        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);
        System.out.println(employee5);
    }
}
