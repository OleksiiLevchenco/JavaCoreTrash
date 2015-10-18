package task1.company;

import task1.company.bookkeeping.*;
import task1.company.calculator.FullDaySalaryCalculator;
import task1.company.calculator.PercentSalaryCalculator;
import task1.company.calculator.SalaryCalculator;
import task1.company.employees.Employee;
import task1.company.employees.impl.Bookkeeper;
import task1.company.employees.impl.Manager;
import task1.company.employees.impl.Programmer;

import java.util.*;

/**
 * @author Alexey Levchenko
 */
public class CompanyTest {


    public static void main(String[] args) {

        Employee programmer01 = new Programmer("Василий", 2000d, 160);
        Employee programmer02 = new Programmer("Анатолий", 2000d, 160);
        Employee manager1 = new Manager("Николай", 2000d, 160);
        Employee manager2 = new Manager("Сергей", 2000d, 160);
        Bookkeeper bookkeeper = new Bookkeeper("Гермес", 20000d, 160);
        List<Employee> employees = Arrays.asList(programmer01, programmer02, manager1, manager2, bookkeeper);


        HashMap<Class<? extends Employee>,SalaryCalculator> calc = new HashMap<>();
        calc.put(Programmer.class,new PercentSalaryCalculator());
        calc.put(Manager.class, new FullDaySalaryCalculator());
        calc.put(Bookkeeper.class, new FullDaySalaryCalculator());


        LinkedList<TreeMap<Employee,Integer>> employeeHoursCalendar = new LinkedList<>();
        TreeMap<Employee,Integer> monthlyWorkingHoursReport = new TreeMap<>();
        for (Employee employee : employees) {
            monthlyWorkingHoursReport.put(employee, 200);
        }
        employeeHoursCalendar.add(monthlyWorkingHoursReport);

        Bookkeeping bookkeeping = new Bookkeeping(
                calc,
                employeeHoursCalendar,
                new LinkedList<TreeMap<Employee, Double>>()
        );

        bookkeeper.setBookkeeping(bookkeeping);
        bookkeeper.setEmployeesList(employees);

        Company company = new Company(employees,bookkeeping);

        company.star();


    }


}
