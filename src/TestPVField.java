
public class TestPVField {
    public static void main(String... args)throws InterruptedException{
        new Ex2().getVersion();
    }
}
    class Ex1{
        private String version ="0.1a";
        private void getVersion(){
            System.out.println(version);
        }
    }

    class Ex2 extends Ex1{
        private String version ="0.5b";
//        @Override
        public void getVersion(){
            System.out.println(version);
        }
    }

