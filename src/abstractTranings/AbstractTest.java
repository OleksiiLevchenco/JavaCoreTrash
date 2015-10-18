package abstractTranings;

/**
 * @author Alexey Levchhenko
 */
public  class AbstractTest {


    private Integer integer;

    public AbstractTest(Integer integer) {
        this.integer = integer;
    }

    public void method(){
        System.out.println(integer);
    }

    public void specMethod(){}

}
