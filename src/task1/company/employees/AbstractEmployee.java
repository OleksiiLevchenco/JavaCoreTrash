package task1.company.employees;

/**
 * @author Alexey Levchenko
 */

public abstract class AbstractEmployee implements Employee {
    private String name;
    private Double rate;
    private int monthlyNormHours;

    public AbstractEmployee(String name, Double rate, int monthlyNormHours) {
        this.name = name;
        this.rate = rate;
        this.monthlyNormHours = monthlyNormHours;
    }


    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Double getRate() {
        return rate;
    }

    @Override
    public void setRate(Double salary) {
        this.rate = salary;
    }

    @Override
    public void setNormaHours(int hours) {
        this.monthlyNormHours = hours;
    }

    @Override
    public int getNormaHours() {
        return this.monthlyNormHours;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AbstractEmployee)) return false;
        AbstractEmployee that = (AbstractEmployee) o;
        return name.equals(that.name);
    }

    @Override
    public int compareTo(Object o) {
        String thisName = this.name;
        Employee that = (Employee)o;
        String thatName =that.getName();
        return thisName.compareTo(thatName);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return  this.getClass()+
                "{" +
                " name='" + name + '\'' +
                ", rate=" + rate +
                ", monthlyNormHours=" + monthlyNormHours +
                " }";
    }


}
