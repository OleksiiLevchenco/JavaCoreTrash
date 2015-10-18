package task5.xml;


import javax.xml.bind.JAXBException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.List;



/**
 * @author Alexey Levchenko
 */
public class CatalogTest {

    public static void main(String[] args) throws JAXBException {
        Manager manager = new Manager();

//        manager.add(new Transformer(1, 110, 110, 10, 3.5f, new BigDecimal("25.00")));
//        manager.add(new Transformer(2, 110, 48, 10, 4.5f, new BigDecimal("35.00")));
//        manager.add(new Transformer(3, 110, 36, 10, 5.5f, new BigDecimal("45.00")));
//        manager.add(new Transformer(4, 110, 24, 10, 6.5f, new BigDecimal("46.00")));
//        manager.add(new Transformer(5, 110, 12, 10, 7.5f, new BigDecimal("55.00")));
//
//        manager.add(new Transformer(6, 220, 110, 10, 3.5f, new BigDecimal("25.00")));
//        manager.add(new Transformer(7, 220, 36, 10, 4.5f, new BigDecimal("30.00")));
//        manager.add(new Transformer(8, 220, 24, 10, 5.5f, new BigDecimal("35.00")));
//        manager.add(new Transformer(9, 220, 12, 10, 6.5f, new BigDecimal("45.00")));
//
//        manager.add(new Transformer(10, 380, 220, 10, 3.5f, new BigDecimal("15.00")));
//        manager.add(new Transformer(11, 380, 110, 10, 4.5f, new BigDecimal("25.00")));
//        manager.add(new Transformer(12, 380, 38, 10, 5.0f, new BigDecimal("45.00")));
//        manager.add(new Transformer(13, 380, 24, 10, 5.5f, new BigDecimal("50.00")));
//        manager.add(new Transformer(14, 380, 12, 10, 6.5f, new BigDecimal("55.00")));

        manager.add(new Transformer(14, 380, 12, 10, 6.5f, new BigDecimal("55.00")));

        manager.replace(new Transformer(154000, 382, 222, 12, 3.5f, new BigDecimal("150.00")));

        manager.replace(new Transformer(10, 382, 222, 12, 3.5f, new BigDecimal("150.00")));

        manager.remove(8);




        List<Transformer> trByPrice = manager.findByPrice(new BigDecimal(25d, new MathContext(2, RoundingMode.FLOOR)));

        for (Transformer transformer : trByPrice) {
            System.out.println("Find by price \n" + transformer + "\n");
        }

        List<Transformer> trByOutputVoltage = manager.findByOutputVoltage(24);

        for (Transformer transformer : trByOutputVoltage) {
            System.out.println("Find by output voltage \n" +transformer + "\n");

        }

    }
}


