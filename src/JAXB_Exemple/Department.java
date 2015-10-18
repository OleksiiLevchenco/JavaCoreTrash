package JAXB_Exemple;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexey Levchhenko
 */

@XmlRootElement(name = "Department")
@XmlType(propOrder = {"departmentName", "workers"})

public class Department {
    private String departmentName;
    private List<Worker> workers = new LinkedList<Worker>();

    //todo: ask about constructor and XML
    public Department(String departmentName) {
        this.departmentName = departmentName;
    }

    public Department() {} //Required by JAXB

    @XmlElement
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    @XmlElement(name = "worker")
    @XmlElementWrapper
    public void setWorkers(List<Worker> workers) {
        this.workers = workers;
    }

    public List<Worker> getWorkers() {
        return workers;
    }


    public void addNewWorker(Worker... workers) {

        Collections.addAll(this.workers, workers);
    }

    public void printWorkersList() {
        for (Worker w : workers) {
            System.out.println(w);
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", workers=" + workers +
                '}';
    }
}
