package pgdp.adventuin;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public final class AdventuinParty {
    public static Map<HatType, List<Adventuin>> groupByHatType(List<Adventuin> entirelist){
        return entirelist.stream().collect(Collectors.groupingBy(Adventuin::getHatType));

//        Map<HatType,List<Adventuin>> result = new HashMap<>();
//        for(int i =0; i < entirelist.size(); i++){
//            if(result.containsKey(entirelist.get(i).getHatType())){
//                result.get(entirelist.get(i).getHatType()).add(entirelist.get(i));
//            }
//            else{
//                List<Adventuin> newlist = new ArrayList<>();
//                newlist.add(entirelist.get(i));
//                result.put(entirelist.get(i).getHatType(), newlist);
//            }
//        }
//        return result;
    }
    public static void printLocalizedChristmasGreetings(List<Adventuin> entirelist){
        if(!entirelist.isEmpty()) {
            List<Adventuin> sorted = entirelist.stream().sorted(Comparator.comparing(Adventuin::getHeight)).collect(Collectors.toList());
            sorted.forEach(element -> System.out.println(element.getLanguage().getLocalizedChristmasGreeting(element.getName())));
        }
    }

    public static Map<HatType, List<Adventuin>> getAdventuinsWithLongestNamesByHatType(List<Adventuin> entirelist){
        Map<HatType, List<Adventuin>> newhash = new HashMap<>();
        if(!entirelist.isEmpty()){
            groupByHatType(entirelist).forEach((key1, value) -> {
                int a = value.stream().max(Comparator.comparing(element -> element.getName().length())).get().getName().length();
                newhash.put(key1, value.stream().filter(element -> element.getName().length() == a).collect(Collectors.toList()));
            });
        }
        return newhash;
    }

    public static Map<Integer, Double> getAverageColorBrightnessByHeight(List<Adventuin> entirelist){
        if(!entirelist.isEmpty()) {
            List<Adventuin> modifiedlist = entirelist.stream()
                    .map(element -> new Adventuin(element.getName(), (int) (Math.round((double) element.getHeight()/10) * 10), element.getColor(),element.getHatType(),element.getLanguage()))
                    .collect(Collectors.toList());
            Map<Integer,List<Adventuin>> helper = modifiedlist.stream().collect(Collectors.groupingBy(Adventuin::getHeight));
            Map<Integer,Double> result = new HashMap<>();
                    helper.forEach((key, value) -> {
                        double a = 0;
                        for (Adventuin adventuin : value) {
                            a += (adventuin.getColor().toRgbColor8Bit().getRed() * 0.2126 + adventuin.getColor().toRgbColor8Bit().getGreen() * 0.7152
                                    + adventuin.getColor().toRgbColor8Bit().getBlue() * 0.0722) / 255;
                        }
                        a= a/value.size();
                        result.put(key, a);
                    });
                   return result;
        }
        return new HashMap<>();
    }

    public static Map<HatType,Double> getDiffOfAvgHeightDiffsToPredecessorByHatType(List<Adventuin> entirelist){
        Map<HatType , List<Adventuin>> grouped = groupByHatType(entirelist);
        Map<HatType,Double> result = new HashMap<>();
        grouped.forEach((key,value) -> { double poscount =0; double negcount =0; int postimes =0; int negtimes =0;
            for(Adventuin adventuin: value){
                if(value.indexOf(adventuin) != value.size()-1){
                    if(adventuin.getHeight() > value.get(value.indexOf(adventuin)+1).getHeight()){
                        poscount += adventuin.getHeight() - value.get(value.indexOf(adventuin)+1).getHeight();
                        postimes++;
                    }
                    if(adventuin.getHeight() < value.get(value.indexOf(adventuin)+1).getHeight()) {negcount += adventuin.getHeight() - value.get(value.indexOf(adventuin)+1).getHeight(); negtimes++;}
                }
                else{
                    if(adventuin.getHeight() > value.get(0).getHeight()){
                        poscount += adventuin.getHeight() - value.get(0).getHeight();
                        postimes++;
                    }
                    if(adventuin.getHeight() < value.get(0).getHeight()) {negcount += adventuin.getHeight() - value.get(0).getHeight(); negtimes++;}
                }
            }
            if(postimes !=0 && negtimes !=0) result.put(key, poscount/postimes - negcount/negtimes);
            if(negtimes ==0 && postimes ==0) result.put(key, 0.0);
        });
        return result;
    }
}
