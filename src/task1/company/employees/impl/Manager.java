package task1.company.employees.impl;

import task1.company.employees.AbstractEmployee;

/**
 * @author Alexey Levchhenko
 */
public class Manager extends AbstractEmployee {

    public Manager(String name, Double rate, int monthlyNormHours) {
        super(name, rate, monthlyNormHours);
    }

    @Override
    public void doWork() {
        System.out.println("Manager: "+getName()+ " : you can buy rubber duck with discount of 50 percent");
    }
}
