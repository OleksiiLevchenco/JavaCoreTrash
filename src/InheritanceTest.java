/**
 * @author Alexey Levchhenko
 */
public class InheritanceTest {
    public static void main(String[] args) {
        A1 b = new B1();
       b.method();
    }

}

class A1 {

    void doAnyth(int i, Object...args) {
        System.out.println(i);
        for (Object arg : args) {
            System.out.println(arg);
        }
    }

    protected void method() {
        System.out.println("A1.method");
    }
    protected void method2() {
        System.out.println("A1.method");
        doAnyth(1,2,new B1(),56);
    }
}

class B1 extends A1 {

    public void method() {
        System.out.println("B1.method");
        method2();
        byte b = 8;

    }


}