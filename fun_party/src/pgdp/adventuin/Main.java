package pgdp.adventuin;

import com.sun.jdi.Value;
import pgdp.color.RgbColor;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static class person{
        public String name;
        public int age;
        public HatType hat;
        public person(String name, int age , HatType hat){
            this.name =name;
            this.age = age;
            this.hat = hat;
        }
        public String  getname(){
            return name;
        }

        public HatType getHat() {
            return hat;
        }
    }
    public static void main(String[] args) {
//        Adventuin first = new Adventuin("jake", 10,new RgbColor(4,4,4,4),HatType.REINDEER,Language.ENGLISH);
//        Adventuin second = new Adventuin("josh", 10,new RgbColor(4,4,4,4),HatType.NO_HAT,Language.ENGLISH);
//        Adventuin third = new Adventuin("joshua", 10,new RgbColor(4,4,4,4),HatType.FISHY_HAT,Language.ENGLISH);
//        Adventuin forth = new Adventuin("junael", 10,new RgbColor(4,4,4,4),HatType.SANTA_CLAUS,Language.ENGLISH);
//        List<Adventuin> a = new ArrayList<>();
//        a.add(first);
//        a.add(second);
//        a.add(third);
//        a.add(forth);
//        AdventuinParty party = new AdventuinParty();
//        Map<HatType, List<Adventuin>> b = party.groupByHatType(a);
//        System.out.println(b.get(HatType.FISHY_HAT).remove(1).getName());
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(4);
//        a.add(10);
//        a.add(4);
//        a.add(8);
//        a.add(6);
//        List<Integer> sorted = a.stream().sorted().collect(Collectors.toList());
//        for(int i =0; i < sorted.size(); i++){
//            System.out.println(sorted.get(i));
//        }

//        Map<Integer, Double> hashm = new HashMap<>();
//        List<Integer> a = new ArrayList<>();
//        a.add(1);
//        a.add(95);
//        a.add(104);
//        a.add(105);
//        a.add(144);
//        Map<Integer, String> b = new HashMap<>();
//        b.put(1,"one");
//        b.put(2,"two");


//        List<person> a = new ArrayList<>();
//        a.add(new person("jake" , 10, HatType.FISHY_HAT));
//        a.add(new person("josh" , 10,HatType.FISHY_HAT));
//        a.add(new person("jale" , 10,HatType.REINDEER));
//        a.add(new person("gke" , 1, HatType.SANTA_CLAUS));
//        a.add(new person("gle" , 1,HatType.NO_HAT));
//        int c = a.stream().max(Comparator.comparing(person::getname)).get().getname().length();
//        List<person> k = a.stream().filter(element -> element.getname().length() == c).collect(Collectors.toList());
//        Map<HatType, List<person>> r = k.stream().collect(Collectors.groupingBy(person::getHat));
//        System.out.println(r.get(HatType.FISHY_HAT).get(1).name);

//        Adventuin a = new Adventuin("aaaaaaaa" , 100, new RgbColor(10,10,10,10),HatType.NO_HAT,Language.ENGLISH);
//        Adventuin b = new Adventuin("josh2aaa" , 100, new RgbColor(10,10,10,10),HatType.FISHY_HAT,Language.ENGLISH);
//        Adventuin c = new Adventuin("josh3bra" , 100, new RgbColor(10,10,10,10),HatType.NO_HAT,Language.ENGLISH);
//        Adventuin d = new Adventuin("josh4b" , 100, new RgbColor(10,10,10,10),HatType.FISHY_HAT,Language.ENGLISH);
//        Adventuin e = new Adventuin("josh5rr" , 100, new RgbColor(10,10,10,10),HatType.SANTA_CLAUS,Language.ENGLISH);
//        Adventuin k = new Adventuin("josh5" , 100, new RgbColor(10,10,10,10),HatType.SANTA_CLAUS,Language.ENGLISH);
//        List<Adventuin> mlist = new ArrayList<Adventuin>();
//        mlist.add(a);mlist.add(b);mlist.add(c);mlist.add(d);mlist.add(e);mlist.add(k);
//        Map<HatType, List<Adventuin>> testsubjects = AdventuinParty.getAdventuinsWithLongestNamesByHatType(mlist);
//        System.out.println(testsubjects);
//        testsubjects.forEach((key,value) -> {
//            System.out.println(value.get(0).getName());
//        });


//        List<Adventuin> pengu = new LinkedList<>();
//        pengu.add(new Adventuin("ADVENTUIX", 123, new RgbColor(3, 2, 7, 0), HatType.REINDEER, Language.ENGLISH));
//        pengu.add(new Adventuin("ADVENTUIX", 123, new RgbColor(3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
//        pengu.add(new Adventuin("AKAKI", 100, new RgbColor(3, 2, 7, 0), HatType.NO_HAT, Language.ENGLISH));
//        pengu.add(new Adventuin("PLAYER!", 100, new RgbColor(3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
//        pengu.add(new Adventuin("LUKA", 120, new RgbColor(3, 2, 7, 0), HatType.NO_HAT, Language.GERMAN));
//        pengu.add(new Adventuin("LUKA", 100, new RgbColor(3, 2, 7, 0), HatType.NO_HAT, Language.GERMAN));
//        pengu.add(new Adventuin("PLAYER!", 100, new RgbColor(3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
//        pengu.add(new Adventuin("PLAYER!", 110, new RgbColor(3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
//        pengu.add(new Adventuin("PLAYER!", 120, new RgbColor(3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
//        pengu.add(new Adventuin("NIKA", 100, new RgbColor(3, 2, 7, 0), HatType.REINDEER, Language.GERMAN));
//        pengu.add(new Adventuin("BONDO", 120, new RgbColor(3, 2, 7, 0), HatType.REINDEER, Language.GERMAN));
//        pengu.add(new Adventuin("ALICE", 23, new RgbColor(3, 2, 7, 0), HatType.SANTA_CLAUS, Language.GERMAN));
//        pengu.add(new Adventuin("BOB", 33, new RgbColor(3, 2, 7, 0), HatType.SANTA_CLAUS, Language.ENGLISH));
//        pengu.add(new Adventuin("UNNAME", 77, new RgbColor(3, 2, 7, 0), HatType.SANTA_CLAUS, Language.ENGLISH));
//        pengu.add(new Adventuin("JAMES", 87, new RgbColor(3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
//        pengu.add(new Adventuin("abcdefger", 87, new RgbColor(3, 2, 7, 0), HatType.FISHY_HAT, Language.ENGLISH));
//        pengu.add(new Adventuin("abcde", 87, new RgbColor(3, 2, 7, 0), HatType.REINDEER, Language.ENGLISH));
//        System.out.println(AdventuinParty.getAverageColorBrightnessByHeight(pengu));
        Scanner obj = new Scanner(System.in);
        final int $zero =0;
        int $s0,$s1,$v0;
        int $a0 = obj.nextInt();
        $s0 = $zero + 0;
        $s1 = $zero + 1;
        while ($a0 >= $s1){
            $s0 = $s0 + $s1;
            $s1 = $s1 + 2;
        }
        $v0 = $s0 + $zero;
        System.out.println($v0);
    }
}
