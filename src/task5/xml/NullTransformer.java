package task5.xml;

import java.math.BigDecimal;

/**
 * @author Alexey Levchhenko
 */
public class NullTransformer extends Transformer {
    public NullTransformer() {
        setId(-1);
        setInputVoltage(0);
        setOutputVoltage(0);
        setOutputCurrent(0);
        setMass(0);
        setPrice(new BigDecimal(0));
    }
}
