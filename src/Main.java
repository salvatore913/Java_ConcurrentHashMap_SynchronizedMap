import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class Main {
    public static final int PAUSE = 100;

    public static void main(String[] args) throws InterruptedException {
        Maps maps = new Maps();
        Maps.map = new ConcurrentHashMap<>();
        new Thread(null, maps::writeTime, "ConcurrentHashMap").start();
        new Thread(null, maps::readTime, "ConcurrentHashMap").start();
        Thread.sleep(PAUSE);
        Maps.map = Collections.synchronizedMap(new HashMap<>());
        new Thread(null, maps::writeTime, "SynchronizedMap").start();
        new Thread(null, maps::readTime, "SynchronizedMap").start();

        //Рейтинг скорости выполнения задач:
        //1. Чтение элементов мары в ConcurrentHashMap;
        //2. Чтение элементов мары в SynchronizedMap;
        //3. Запись элементов мары в SynchronizedMap;
        //4. Запись элементов мары в ConcurrentHashMap;
        //При увеличении размера списка тенденция сохраняется.
    }
}