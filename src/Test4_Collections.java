import java.util.*;
class SpecSortBeforeSeparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int aInt=0,bInt=0;
        try {
            aInt=Integer.parseInt(a.substring(0,a.indexOf(":")));
            bInt=Integer.parseInt(b.substring(0, b.indexOf(":")));
        } catch(Exception e) {
            System.out.println("Parsing error");
        }
        if(aInt>bInt)return 1;
        else return -1;

    }
}
class SpecSortAfterSeparator implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
        int aInt=0,bInt=0;
        try {
            aInt=Integer.parseInt(a.substring(a.indexOf(":")+1));
            bInt=Integer.parseInt(b.substring(b.indexOf(":")+1));
        } catch(Exception e) {
            System.out.println("Parsing error");
        }
        if(aInt>bInt)return 1;
        else return -1;

    }
}



class Test4_Collections {
    public static void main(String[] args) {
        List<String> myHashSet = new LinkedList<String>();
        myHashSet.add("3:23");
        myHashSet.add("100:3");
        myHashSet.add("100:3");
        myHashSet.add("1:2");
        myHashSet.add("22:4");
        Collections.sort(myHashSet,new SpecSortAfterSeparator());

        int[] arr = {4,55,65,46,55};
        Arrays.sort(arr);

        for(int i:arr){
            System.out.println(i);
        }



        Iterator<String> itr = myHashSet.iterator();

//        String[]arr;
//        arr=myHashSet.toArray(new String[myHashSet.size()]);
//        for(String s:arr){
//            System.out.println(s);
//        }

        while(itr.hasNext()){
            System.out.println(itr.next());
        }


    }
//
    }


