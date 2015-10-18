package singleton;

public class MySingleton {
    private static int counter;
    private static MySingleton instance;
    private Integer field;
    private MySingleton() {
        field = counter;
        counter++;
    }

    public static synchronized MySingleton getInstance(){
        if(null == instance) {
            instance = new MySingleton();
            return instance;
        }
        return instance;
    }

    public static MySingleton getInstance2(){
        if(null == instance) {
            synchronized (MySingleton.class) {
                if (instance == null) {
                    instance = new MySingleton();
                    return instance;
                }
            }
        }
        return instance;
    }

    public Integer getField() {
        return field;
    }


}
