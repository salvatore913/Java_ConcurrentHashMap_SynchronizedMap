import java.util.List;
import java.util.Map;
import java.util.Random;

public class Maps {
    private static final long SIZE = 20;
    private static final int LOW_BOUND = 0;
    private static final int HIGH_BOUND = 2000;
    private static final List<Integer> random = new Random().ints(SIZE, LOW_BOUND, HIGH_BOUND)
            .boxed().toList();
    public static Map<Integer, Integer> map;

    public void writeTime() {
        long start = System.nanoTime();
        for (int i = 0; i < random.size(); i++) {
            map.put(i, random.get(i));
        }
        long stop = System.nanoTime();
        System.out.printf("Время записи мапы %s\n в %s составляет %d\n",
                map, Thread.currentThread().getName(), (stop - start));
    }

    public void readTime() {
        long start = System.nanoTime();
        for (int i = 0; i < map.size(); i++) {
            map.get(i);
        }
        long stop = System.nanoTime();
        System.out.printf("Время чтения мапы %s\n в %s составляет %d\n",
                map, Thread.currentThread().getName(), (stop - start));
    }
}