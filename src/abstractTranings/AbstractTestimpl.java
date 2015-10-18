package abstractTranings;

/**
 * @author Alexey Levchhenko
 */
public class AbstractTestimpl extends AbstractTest {

    private final Integer integer;

    public AbstractTestimpl(Integer integer) {
        super(integer);
        this.integer = integer;
    }

    public void specMethod() {
        System.out.println(integer/2);
    }

    public static void main(String[] args) {
        AbstractTestimpl test = new AbstractTestimpl(23);

        test.method();
        test.specMethod();

    }

}
