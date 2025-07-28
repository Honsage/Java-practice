import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        synchronizedUse();
//        semaphoreUse();
        fileReaderTest();
    }

    private static final Object state;
    private static Semaphore semaphore;
    private static int var;

    static {
        class State {
            private int s;

            @Override
            public String toString() {
                s += (new Random().nextBoolean()) ? 1 : -1;
                return String.valueOf(s);
            }
        }

        state = new State();
        semaphore = new Semaphore(1);
        var = 0;
    }

    public static void synchronizedUse() throws InterruptedException {
        Runnable task = () -> {
            synchronized (Main.state) {
                String threadName = Thread.currentThread().getName();
                IntStream.range(0, 30).forEach(_ ->
                        System.out.println(threadName + " s: " + state)
                );
            }
        };
        Thread th1 = new Thread(task);
        Thread th2 = new Thread(task);

        th1.start();
        th2.start();

        th1.join();
        th2.join();
    }

    public static void semaphoreUse() throws InterruptedException {
        Runnable incrementor = () -> {
            while (true) {
                if (semaphore.tryAcquire()) {
                    ++var;
                    semaphore.release();
                }
            }
        };
        Runnable checker = () -> {
            while (true) {
                if (semaphore.tryAcquire()) {
                    if (var % 100 == 17) System.out.println(var);
                    semaphore.release();
                }
            }
        };

        Thread th1 = new Thread(incrementor);
        Thread th2 = new Thread(checker);

        th1.start();
        th2.start();

        th1.join();
        th2.join();
    }

    public static void fileReaderTest() {
        ConcurrentFileReader fileReader = new ConcurrentFileReader(1 << 3);
        System.out.println(fileReader.read("src/file.txt"));
    }
}