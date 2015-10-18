package task1.company.employees.impl;

import task1.company.employees.AbstractEmployee;

/**
 * @author Alexey Levchhenko
 */
public class Programmer extends AbstractEmployee {

    public Programmer(String name, Double rate, int monthlyNormHours) {
        super(name, rate, monthlyNormHours);
    }

    @Override
    public void doWork() {
        System.out.println("Programmer: "+getName()+ " : click - click");
    }
}
