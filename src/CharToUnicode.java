import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author Alexey Levchenko
 */



public class CharToUnicode  {
    public static void main(String[] args) {
        double d = 17456505.84d;
        Long integerPart = Math.round(d);
        BigDecimal bd = new BigDecimal(d);
        BigDecimal rbd = bd.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        String convert = Double.toString(d);
        DecimalFormat formatter = new DecimalFormat("###,###.##");
        String output = formatter.format(d);


        String a = "1 2 3 4.5";
        String b = output.replaceAll("\\u00a0", ".");
        char ch = 160;


        System.out.println(b);


        for(char c : output.toCharArray()) {
            System.out.println("\\u" + Integer.toHexString(c | 0x10000).substring(1));
        }
    }

}
