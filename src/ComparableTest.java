import java.util.*;

public class ComparableTest {

    public static void main(String[] args) {
        List<A> aList = new ArrayList<>();
        aList.add(new A("12345","678"));
        aList.add(new A("22345678",""));
        aList.add(new A("3234","5678"));
        aList.add(new A("42345678",null));
        aList.add(new A("523456","78"));
        aList.add(new A("6234567","8"));
        aList.add(new A(null,"8"));
        aList.add(new A(null,null));

        Collections.sort(aList);

        for (A a : aList) {
            System.out.println(a);
        }
    }
}


class A implements Comparable {
    private String x;
    private String y;

    public A(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            return 1;
        }
        if (((A) o).getX() == null) {
            return 1;
        }
        if (this.x == null) {
            return 1;
        }

        String thatX = ((A) o).getX();
        return this.x.compareTo(thatX);
    }

    public static Comparator<A> xLengthComparator = new Comparator<A>() {
        @Override
        public int compare(A o1, A o2) {
            if (o1 == null || o2 == null) {
                return 0;
            }
            if (o1.getX() == null || o2.getX() == null) {
                return 0;
            }
            return o1.getX().length() - o2.getX().length();
        }
    };

    @Override
    public String toString() {
        return "A{" +
                "x='" + x + '\'' +
                ", y='" + y + '\'' +
                '}';
    }
}

class YLengthComparator implements Comparator<A> {
    @Override
    public int compare(A o1, A o2) {
        if (o1 == null || o2 == null) {
            return 0;
        }
        if (o1.getY() == null || o2.getY() == null) {
            return 0;
        }
        return o1.getY().length() - o2.getY().length();
    }
}



