import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String... args)throws InterruptedException{
        String s = "10.5";
//        int i = Integer.parseInt(s);
        BigDecimal b = new BigDecimal(s);
        System.out.println(b);
    }
}
