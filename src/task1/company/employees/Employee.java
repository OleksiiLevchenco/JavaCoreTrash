package task1.company.employees;

/**
 * @author Alexey Levchhenko
 */
public interface Employee extends Comparable {

    String getName();

    void setName(String name);

    Double getRate();

    void setRate(Double salary);

    void setNormaHours(int hours);

    int getNormaHours();

    void doWork();


}
