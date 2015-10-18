package task1.company.employees.impl;

import task1.company.bookkeeping.Bookkeeping;
import task1.company.calculator.SalaryCalculator;
import task1.company.employees.AbstractEmployee;
import task1.company.employees.Employee;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * @author Alexey Levchhenko
 */
public class Bookkeeper extends AbstractEmployee {
    public Bookkeeper(String name, Double rate, int monthlyNormHours) {
        super(name, rate, monthlyNormHours);

    }

    private List<Employee> employeesList;
    private Map<Class<? extends Employee>,SalaryCalculator> salaryCalc;
    private LinkedList<TreeMap<Employee,Integer>> hoursCalendar;
    private LinkedList<TreeMap<Employee,Double>> salaryCalendar;
    private Bookkeeping bookkeeping;


    public void setEmployeesList(List<Employee> employeesList) {
        this.employeesList = employeesList;
    }

    public void setSalaryCalc(Map<Class<? extends Employee>, SalaryCalculator> salaryCalc) {
        this.salaryCalc = salaryCalc;
    }

    public void setHoursCalendar(LinkedList<TreeMap<Employee,Integer>> hoursCalendar) {
        this.hoursCalendar = hoursCalendar;
    }

    public void setSalaryCalendar(LinkedList<TreeMap<Employee, Double>> salaryCalendar) {
        this.salaryCalendar = salaryCalendar;
    }

    public void setBookkeeping(Bookkeeping bookkeeping) {

        this.bookkeeping = bookkeeping;
        this.salaryCalc = bookkeeping.getEmployeeCalculatorMap();
        this.hoursCalendar = bookkeeping.getEmployeeHoursCalendar();
        this.salaryCalendar = bookkeeping.getEmployeeSalaryCalendar();
    }

    @Override
    public void doWork() {
        calculateSalary();
        System.out.println("Bookkeeper: "+getName()+ " :I’ve already calculate salary:");
        printMonthSalaryReport();
    }

    public void calculateSalary(){

        TreeMap<Employee,Integer> currentMonthHoursReport = hoursCalendar.get(hoursCalendar.size()-1);
        TreeMap<Employee,Double> monthSalaryReport = new TreeMap<Employee, Double>();


        for(Employee employee : employeesList){

            SalaryCalculator calc = salaryCalc.get(employee.getClass());
            int normHours = employee.getNormaHours();
            int currentMonthWorkedHours = currentMonthHoursReport.get(employee);
            double rate = employee.getRate();
            double salary = calc.calculateSalary(
                    normHours,
                    currentMonthWorkedHours,
                    rate
                    );

            monthSalaryReport.put(employee, salary);
        }
        salaryCalendar.add(monthSalaryReport);
    }

    private void printMonthSalaryReport(){
        Map<Employee,Double> monthSalaryReport = salaryCalendar.get(salaryCalendar.size()-1);
        for(Map.Entry<Employee,Double> entry: monthSalaryReport.entrySet()){
            System.out.println(entry.getKey()+"  "+entry.getValue());
        }
    }
}


