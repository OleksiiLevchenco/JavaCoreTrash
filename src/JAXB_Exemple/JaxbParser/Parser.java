package JAXB_Exemple.JaxbParser;

import javax.xml.bind.JAXBException;
import java.io.File;

/**
 * @author Alexey Levchenko
 */
public interface Parser {
    Object getObject(File file , Class c) throws JAXBException;
    void saveObject(File file , Object object) throws JAXBException;
}
