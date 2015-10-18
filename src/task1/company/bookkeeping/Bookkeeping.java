package task1.company.bookkeeping;

import task1.company.calculator.SalaryCalculator;
import task1.company.employees.Employee;


import java.util.*;

/**
 * @author Alexey Levchhenko
 */
public class Bookkeeping {

    public Bookkeeping(
            HashMap<Class<? extends Employee>, SalaryCalculator> employeeCalculatorMap,
            LinkedList<TreeMap<Employee, Integer>> employeeHoursCalendar,
            LinkedList<TreeMap<Employee, Double>> employeeSalaryCalendar
    ) {
        this.employeeCalculatorMap = employeeCalculatorMap;
        this.employeeHoursCalendar = employeeHoursCalendar;
        this.employeeSalaryCalendar = employeeSalaryCalendar;
    }

    private HashMap<Class<? extends Employee>,SalaryCalculator> employeeCalculatorMap =
            new HashMap<Class<? extends Employee>, SalaryCalculator>();

    private LinkedList<TreeMap<Employee,Integer>> employeeHoursCalendar = new LinkedList<TreeMap<Employee, Integer>>();

    private LinkedList<TreeMap<Employee,Double>> employeeSalaryCalendar = new LinkedList<TreeMap<Employee, Double>>();


    public Map<Class<? extends Employee>, SalaryCalculator> getEmployeeCalculatorMap() {
        return employeeCalculatorMap;
    }

    public void setEmployeeCalculatorMap(HashMap<Class<? extends Employee>, SalaryCalculator> employeeCalculatorMap) {
        this.employeeCalculatorMap = employeeCalculatorMap;
    }

    public LinkedList<TreeMap<Employee, Integer>> getEmployeeHoursCalendar() {
        return employeeHoursCalendar;
    }

    public void setEmployeeHoursCalendar(LinkedList<TreeMap<Employee, Integer>> employeeHoursCalendar) {
        this.employeeHoursCalendar = employeeHoursCalendar;
    }

    public LinkedList<TreeMap<Employee, Double>> getEmployeeSalaryCalendar() {
        return employeeSalaryCalendar;
    }

    public void setEmployeeSalaryCalendar(LinkedList<TreeMap<Employee, Double>> employeeSalaryCalendar) {
        this.employeeSalaryCalendar = employeeSalaryCalendar;
    }

}
