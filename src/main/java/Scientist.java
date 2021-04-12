import java.util.HashMap;
import java.util.Map;

public class Scientist {
    public static Map<String, Details> initialize() {
        Map<String, Details> map = new HashMap<>();
        for (int i = 0; i < Details.SIZE; i++) {
            map.put(Details.VALUE[i].name(), Details.VALUE[i]);
        }
        return map;
    }

    public static void checkWinner(Map<String, Details> map1, Map<String, Details> map2) {
        int min1 = collculate(map1);
        int min2 = collculate(map2);
        if (min1>min2){
            System.out.println("победил первый");
        }else if (min1<min2){
            System.out.println("победил второй");
        }else {
            System.out.println("ничья");
        }
    }

    private static int collculate(Map<String, Details> map1) {
        int min = Integer.MAX_VALUE;
        for (Details m : map1.values()) {
            int count = m.getCount();
            if (min > count) {
                min = count;
            }
        }
        System.out.println(min);
        return min;
    }
}
