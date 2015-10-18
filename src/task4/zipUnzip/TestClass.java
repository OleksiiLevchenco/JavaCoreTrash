package task4.zipUnzip;

import java.io.Serializable;

/**
 * @author Alexey Levchenko
 */
public class TestClass implements Serializable {
    private String S;
    private int i;
    private double d;

    public TestClass(String s, int i, double d) {
        S = s;
        this.i = i;
        this.d = d;
    }

    public String getS() {
        return S;
    }

    public void setS(String s) {
        S = s;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "S='" + S + '\'' +
                ", i=" + i +
                ", d=" + d +
                '}';
    }
}
