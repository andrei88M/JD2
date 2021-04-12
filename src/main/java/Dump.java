import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dump {
    public static List<Details> getRandomDetails(int quantity) {
        return Stream.generate(Details::getRandomDetail).limit(quantity).collect(Collectors.toList());
    }

    public static void add(List<Details> dump, int from, int to) {
        List<Details> ld = Stream
                .generate(Details::getRandomDetail)
                .limit((int) (Math.random() * (to - from + 1) + from))
                .collect(Collectors.toList());
        synchronized (Dump.class) {
            dump.addAll(ld);
        }
    }

    public static void take(List<Details> dump, int from, int to, Map<String, Details> trophy) {
        int numb = (int) (Math.random() * (to + 1 - from) + from);
        for (int i = 0; i < numb; i++) {
            if (dump.isEmpty()) {
                break;
            }
            int rand = (int) (Math.random() * dump.size());
            synchronized (Dump.class) {
                Details detail = dump.get(rand);
                int count = trophy.get(detail.name()).getCount();
                count++;
                trophy.get(detail.name()).setCount(count);
                dump.remove(rand);
            }
        }
    }
}
