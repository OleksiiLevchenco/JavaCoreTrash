package task5.xml;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.*;

/**
 * @author Alexey Levchenko
 */

@XmlRootElement(name = "Catalog")
public class TransformersCatalog{

    private List<Transformer> base = new ArrayList<>();


    public TransformersCatalog() {} //Required by JAXB

    public TransformersCatalog(List<Transformer> base) {

        this.base = base;
    }

    @XmlElement(name = "Transformer")
    public void setBase(List<Transformer> base) {
        this.base = base;
    }

    public List<Transformer> getBase() {
        return base;
    }


    @Override
    public String toString() {
        return "TransformersCatalog{" +
                ", base=" + base +
                '}';
    }
}
