package JAXB_Exemple;

/**
 * @author Alexey Levchhenko
 */
public class Worker {
    private String name ;
    private String profession;
    private Double salary;

    public Worker(String name, String profession, Double salary) {
        this.name = name;
        this.profession = profession;
        this.salary = salary;

    }

    public  Worker(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", salary=" + salary +
                '}';
    }
}
