package airport;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        var airport = new Airport();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            threads.add(new Thread(new Aeroplane(airport, new Random().nextInt(1, 3), i)));
        }
        threads.forEach(Thread::start);
    }
}
