package org.example;
import java.sql.Date;
import org.example.model.entity.Customer;
import org.example.model.entity.Employee;
import org.example.model.entity.Office;
import org.example.model.entity.Order;
import org.example.repository.impl.CustomerRepository;
import org.example.repository.impl.EmployeeRepository;
import org.example.repository.impl.OfficeRepository;
import org.example.repository.impl.OrderRepository;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        EmployeeRepository employees = new EmployeeRepository();
        List<Employee> emps = employees.findAll();
        System.out.println("All employees\n");
        for (Employee e: emps) {
            System.out.println(e.toString());
        }
        OrderRepository orders = new OrderRepository();
        List<Order> ords = orders.findAll();
        System.out.println("\nAll orders\n");
        for (Order o: ords) {
            System.out.println(o.toString());
        }
        CustomerRepository customers = new CustomerRepository();
        List<Customer> custs = customers.findAll();
        System.out.println("\nAll customers\n");
        for (Customer c: custs) {
            System.out.println(c.toString());
        }
        OfficeRepository offices = new OfficeRepository();
        List<Office> offs = offices.findAll();
        System.out.println("\nAll offices\n");
        for (Office o: offs) {
            System.out.println(o.toString());
        }
        Integer id;
        System.out.println("\nQuerying employee by id");
        System.out.println("Enter the employee id of the employee that u want to find");
        try {
            id = read.nextInt();
            read.nextLine();
            try {
                Employee e = employees.findById(id);
                System.out.println(e.toString());
            }
            catch (NullPointerException e){
                System.out.println("No employee with this ID");
            }
        }
        catch (InputMismatchException e){
            read.nextLine();
            System.out.println("You should enter a number");
        }
        System.out.println("\nQuerying order by id");
        System.out.println("Enter the order id of the order that u want to find");
        try {
            id = read.nextInt();
            read.nextLine();
            try {
                Order o = orders.findById(id);
                System.out.println(o.toString());
            }
            catch (NullPointerException e){
                System.out.println("No order with this ID");
            }
        }
        catch (InputMismatchException e){
            read.nextLine();
            System.out.println("You should enter a number");
        }
        System.out.println("\nQuerying customer by id");
        System.out.println("Enter the customer id of the customer that u want to find");
        try {
            id = read.nextInt();
            read.nextLine();
            try {
                Customer c = customers.findById(id);
                System.out.println(c.toString());
            }
            catch (NullPointerException e){
                System.out.println("No customer with this ID");
            }
        }
        catch (InputMismatchException e){
            read.nextLine();
            System.out.println("You should enter a number");
        }
        System.out.println("\nQuerying office by id");
        System.out.println("Enter the office id of the office that u want to find");
        try {
            id = read.nextInt();
            read.nextLine();
            try {
                Office o = offices.findById(id);
                System.out.println(o.toString());
            }
            catch (NullPointerException e){
                System.out.println("No office with this ID");
            }
        }
        catch (InputMismatchException e){
            read.nextLine();
            System.out.println("You should enter a number");
        }
        System.out.println("\nAdding employee\n");
        Employee e1 = new Employee();
        e1.setId(2000);
        e1.setLastName("Dalipaj");
        e1.setFirstName("Rezar");
        e1.setExtension("x102");
        e1.setEmail("rezar@dalipaj.com");
        e1.setOfficeCode("5");
        e1.setReportsTo(1619);
        e1.setJobTitle("Engineer");
        Boolean rows = employees.save(e1);
        System.out.println("\nAdding office\n");
        Office off1 = new Office();
        off1.setId(12);
        off1.setCity("Lezhe");
        off1.setCountry("Albania");
        off1.setState("AL");
        off1.setTerritory("Kot");
        off1.setAddressLine1("Beselidhja");
        off1.setAddressLine2("Rr.Shtraus");
        off1.setPostalCode("4005");
        off1.setPhone("068888888");
        Boolean b = offices.save(off1);
        System.out.println("\nAdding customer\n");
        Customer c1 = new Customer();
        c1.setCustomerNumber(45);
        c1.setCustomerName("Kico");
        c1.setContactLastName("Ballolli");
        c1.setContactFirstName("Kico");
        c1.setPhone("0691234567");
        c1.setAddressLine1("Vilat Gjermane");
        c1.setAddressLine2("QS");
        c1.setCity("Tr");
        c1.setState("ALB");
        c1.setPostalCode("1001");
        c1.setCountry("Albania");
        c1.setSalesRepEmployeeNumber(2000);
        c1.setCreditLimit(5000.0);
        Boolean c = customers.save(c1);
        System.out.println("\nAdding order\n");
        Order o1 = new Order();
        o1.setOrderNumber(1100);
        String od= "12-06-2022";
        long millis=System.currentTimeMillis();
        java.sql.Date date=new java.sql.Date(millis);
        o1.setOrderDate(date);
        String rd = "19-06-2022";
        long millis1=System.currentTimeMillis();
        java.sql.Date date1=new java.sql.Date(millis1);
        o1.setRequiredDate(date1);
        String sd = "15-06-2022";
        long millis2=System.currentTimeMillis();
        java.sql.Date date2=new java.sql.Date(millis2);
        o1.setShippedDate(date2);
        o1.setStatus("Delivered");
        o1.setComments("Comment");
        o1.setCustomerNumber(103);
        Boolean ord = orders.save(o1);
        System.out.println("\nUpdating employee\n");
        Employee e2 = new Employee();
        System.out.println("Enter the employee id that u want to update");
        int idd = 0;
        try {
            idd = read.nextInt();
            read.nextLine();
        }
        catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Enter a number");
        }
        e2.setId(idd);
        e2.setLastName("Gjini");
        e2.setFirstName("Redi");
        e2.setExtension("x102");
        e2.setEmail("rezar@dalipaj.com");
        e2.setOfficeCode("5");
        e2.setReportsTo(2010);
        e2.setJobTitle("Engineer");
        Integer row = employees.update(e2);
        System.out.println("\nUpdating offices\n");
        Office off2 = new Office();
        System.out.println("Enter the office id that u want to update");
        idd = 0;
        try {
            idd = read.nextInt();
            read.nextLine();
        }
        catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Enter a number");
        }
        off2.setId(idd);
        off2.setCity("Shkoder");
        off2.setState("AL");
        off2.setCountry("Albania");
        off2.setAddressLine1("1");
        off2.setAddressLine2("2");
        off2.setPhone("0687654321");
        off2.setTerritory("T");
        off2.setPostalCode("2002");
        Integer office = offices.update(off2);
        System.out.println("\nUpdating customers\n");
        Customer c2 = new Customer();
        System.out.println("Enter the customer id that u want to update");
        idd = 0;
        try {
            idd = read.nextInt();
            read.nextLine();
        }
        catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Enter a number");
        }
        c2.setCustomerNumber(idd);
        c2.setCustomerName("Redi");
        c2.setContactLastName("Gjini");
        c2.setContactFirstName("Redi");
        c2.setPhone("0676900420");
        c2.setAddressLine1("Add1");
        c2.setAddressLine2("Add2");
        c2.setCity("Lezhe");
        c2.setState("AL");
        c2.setCountry("Albania");
        c2.setPostalCode("1001");
        c2.setSalesRepEmployeeNumber(2007);
        c2.setCreditLimit(65000.0);
        Integer cust = customers.update(c2);
        System.out.println("\nUpdating orders\n");
        Order o2 = new Order();
        System.out.println("Enter the order id that u want to update");
        idd = 0;
        try {
            idd = read.nextInt();
            read.nextLine();
        }
        catch (InputMismatchException e){
            read.nextLine();
            System.out.println("Enter a number");
        }
        o2.setOrderNumber(idd);
        long millis3=System.currentTimeMillis();
        java.sql.Date date3=new java.sql.Date(millis3);
        o2.setOrderDate(date3);
        long millis4=System.currentTimeMillis();
        java.sql.Date date4=new java.sql.Date(millis4);
        o2.setRequiredDate(date4);
        long millis5=System.currentTimeMillis();
        java.sql.Date date5=new java.sql.Date(millis5);
        o2.setShippedDate(date5);
        o2.setStatus("Shipped");
        o2.setComments("Comm");
        o2.setCustomerNumber(112);
        Integer ordd = orders.update(o2);
        emps = employees.findAll();
        offs = offices.findAll();
        custs = customers.findAll();
        ords = orders.findAll();
        System.out.println("\nAll employees\n");
        for (Employee e: emps) {
            System.out.println(e.toString());
        }
        System.out.println("\nAll offices\n");
        for (Office o: offs) {
            System.out.println(o.toString());
        }
        System.out.println("\nAll customers\n");
        for (Customer cc: custs) {
            System.out.println(cc.toString());
        }
        System.out.println("\nAll orders\n");
        for (Order o: ords) {
            System.out.println(o.toString());
        }
        System.out.println("\nJoined customers and orders:\n");
        Boolean join = customers.join();
    }
}
