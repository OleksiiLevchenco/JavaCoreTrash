package task7.multithread;

/**
 * @author Alexey Levchhenko
 */
public class Food {
    private String name;
    private Float qtt;

    public Food(String name, Float qtt) {
        this.name = name;
        this.qtt = qtt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getQtt() {
        return qtt;
    }

    public void setQtt(Float qtt) {
        this.qtt = qtt;
    }

    @Override
    public String toString() {
        return "Food{" +
                "name='" + name + '\'' +
                ", qtt=" + qtt +
                '}';
    }
}
