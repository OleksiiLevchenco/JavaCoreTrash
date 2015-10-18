package task1.company.calculator;

/**
 * @author Alexey Levchhenko
 */
public class PercentSalaryCalculator implements SalaryCalculator {
    @Override
    public double calculateSalary(int normaHours, int actualHours, double rate) {
        return (float)actualHours/normaHours * rate;
    }
}
