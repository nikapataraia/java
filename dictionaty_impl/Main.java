import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
       SetDictionary<Integer,String > myset = new SetDictionary<>();
       ListDictionary<Integer,String> mylist = new ListDictionary<>();
       String tester = null;

       mylist.put(1,"a");
       mylist.put(2,tester);
       System.out.println(mylist.put(3,"c"));
       System.out.println(mylist.put(3,"d"));

       myset.put(1,"a");
       myset.put(2,tester);
       System.out.println(myset.put(3,"c"));
       System.out.println(myset.put(3,"d"));

       System.out.println("");
       System.out.println("--");System.out.println("--");System.out.println("--");System.out.println("--");
       System.out.println("");


       System.out.println(mylist.get(1).get());
//        System.out.println(mylist.get(2).get());
       System.out.println(mylist.get(3).get());
       System.out.println(myset.get(4).getOrDefault("default"));

       System.out.println(myset.get(1).get());
//        System.out.println(myset.get(2).get());
       System.out.println(myset.get(3).get());
       System.out.println(myset.get(4).getOrDefault("default"));

       System.out.println("");
       System.out.println("--");System.out.println("--");System.out.println("--");System.out.println("--");
       System.out.println("");


       System.out.println(mylist.get(4,"default"));
       System.out.println(myset.get(4,"default"));

       System.out.println("");
       System.out.println("--");System.out.println("--");System.out.println("--");System.out.println("--");
       System.out.println("");

       mylist.update(1,"z");
       myset.update(1,"z");
       System.out.println(mylist.get(1).get());
       System.out.println(myset.get(1).get());
       mylist.update(1,"a");
       mylist.update(1,"a");

       System.out.println("");
       System.out.println("--");System.out.println("--");System.out.println("--");System.out.println("--");
       System.out.println("");

       System.out.println(mylist.containsKey(2));
       System.out.println(myset.containsKey(2));
       mylist.clear(3);
    //    myset.clear(3);
       System.out.println(mylist.containsKey(3));
       System.out.println(myset.containsKey(3));
        
    }

}
