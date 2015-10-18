package task5.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;

/**
 * @author Alexey Levchenko
 */
@XmlType(propOrder = {"id", "inputVoltage", "outputVoltage", "outputCurrent", "mass", "price"})
public class Transformer {

    private int id;
    private int inputVoltage;
    private int outputVoltage;
    private int outputCurrent;
    private float mass;
    private BigDecimal price;

    public Transformer() {}

    public Transformer(int id, int inputVoltage, int outputVoltage,
                               int outputCurrent, float mass, BigDecimal price) {
        this.id = id;
        this.inputVoltage = inputVoltage;
        this.outputVoltage = outputVoltage;
        this.outputCurrent = outputCurrent;
        this.mass = mass;
        this.price = price;
    }

    public int getId() {
        return id;
    }

//    @XmlAttribute(name = "id")
    public void setId(int id) {
        this.id = id;
    }

    public int getInputVoltage() {
        return inputVoltage;
    }

    public void setInputVoltage(int inputVoltage) {
        this.inputVoltage = inputVoltage;
    }

    public int getOutputVoltage() {
        return outputVoltage;
    }

    public void setOutputVoltage(int outputVoltage) {
        this.outputVoltage = outputVoltage;
    }

    public int getOutputCurrent() {
        return outputCurrent;
    }

    public void setOutputCurrent(int outputCurrent) {
        this.outputCurrent = outputCurrent;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transformer{" +
                "id=" + id +
                ", inputVoltage=" + inputVoltage +
                ", outputVoltage=" + outputVoltage +
                ", outputCurrent=" + outputCurrent +
                ", mass=" + mass +
                ", price=" + price +'}'+
                "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transformer)) return false;

        Transformer that = (Transformer) o;

        if (id != that.id) return false;
        if (inputVoltage != that.inputVoltage) return false;
        if (Float.compare(that.mass, mass) != 0) return false;
        if (outputCurrent != that.outputCurrent) return false;
        if (outputVoltage != that.outputVoltage) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

}
