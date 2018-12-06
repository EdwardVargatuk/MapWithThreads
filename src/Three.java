import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


//создает и запускает несколько потоков, которые производят запись в
//коллекцию типа Map;
//- создает и запускает несколько потоков, которые выполняют чтение
//данных из той же коллекции типа Map;


public class Three {
    private Map<Integer, Double> hashMap = new HashMap<>(16, (float) 0.75);
    private Map<Integer, Double> concurrentMap = new ConcurrentHashMap<>(16, (float) 0.75, 16);
    private boolean valueSet = false;
    private int num;
    private double dub;


    synchronized void putToHashMap() {
        while (valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("catch");
            }
        }
        hashMap.put(num, dub * num);
        num++;
        dub++;
        System.out.println(num + " " + dub);
        valueSet = true;
        notify();

    }

    synchronized void getFromHashMap() {

        while (!valueSet) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("catch");
            }
        }

        System.out.println(hashMap.values());
        valueSet = false;

        notify();
    }

//    synchronized void putToConcurrentMap() {
//        hashMap.put(1, 1.0);
//
//    }
}


//    @Override
//    public int hashCode() {
//        return Integer.hashCode(num);
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (o == this) {
//            return true;
//        } else if (o instanceof Three) {
//            return num == ((Three) o).num;
//        }
//        return false;
//    }