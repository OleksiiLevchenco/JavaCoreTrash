package singleton;


/**
 * @author Alexey Levchhenko
 */
public class SingletonTest {
    public static void main(String[] args) {
        MySingleton t1 = MySingleton.getInstance();
        System.out.println(t1.getField());
        MySingleton t2 = MySingleton.getInstance();
        System.out.println(t2.getField());

    }
}
