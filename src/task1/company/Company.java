package task1.company;

import task1.company.bookkeeping.Bookkeeping;
import task1.company.employees.AbstractEmployee;
import task1.company.employees.Employee;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexey Levchhenko
 */
public class Company {

    public Company(List<Employee> employees, Bookkeeping bookkeeping) {
        this.employees = employees;
        this.bookkeeping = bookkeeping;
    }

    List<Employee> employees;

    Bookkeeping bookkeeping;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void star() {
        for (Employee employee : employees) {
            employee.doWork();
        }
    }
}
