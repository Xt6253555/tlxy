package NIO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class demo1 {
    public static void main(String[] args) {
        Map<Integer/*hotelId*/, Float /*maxscore*/> allScoreMap = new ConcurrentHashMap<>();
        allScoreMap.put(1, 10f);
        allScoreMap.put(2, 7f);
        allScoreMap.put(3, 8f);
//        allScoreMap.put(4, 9f);
//        allScoreMap.put(5, 10f);

        List<Integer> hotelListResult = new ArrayList<>();
        hotelListResult.add(1);
        hotelListResult.add(2);
        hotelListResult.add(3);
//        hotelListResult.add(3);
//        hotelListResult.add(4);

        List<Integer> distinctHotels = hotelListResult.stream().distinct().sorted((o1, o2) -> {
            return allScoreMap.get(o2).compareTo(allScoreMap.get(o1));
        }).collect(Collectors.toList());

        System.out.println(distinctHotels);
    }
}
