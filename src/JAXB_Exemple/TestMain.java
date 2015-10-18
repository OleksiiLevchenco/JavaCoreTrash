package JAXB_Exemple;

import JAXB_Exemple.JaxbParser.JaxbParser;
import JAXB_Exemple.JaxbParser.Parser;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * @author Alexey Levchenko
 */
public class TestMain {

    public static void main(String[] args) throws JAXBException {

        Department department = new Department();
        Parser parser = new JaxbParser();
        File file = new File("Department.xml");

        Worker worker1 = new Worker("Ivan","engineer",1000.00);
        Worker worker2 = new Worker("Petra","constructor",1500.00);
        Worker worker3 = new Worker("Masha","turner",1000.50);
        Worker worker4 = new Worker("Anatoly","miller",1000.00);

        department.addNewWorker(worker1,worker2,worker3,worker4);
        department.setDepartmentName("JCC");

//        parser.saveObject(file , department);

        Department d2 = (Department)parser.getObject(file , Department.class);

        System.out.println(d2);


    }


}
