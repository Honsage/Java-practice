package ru.honsage.practice;

public class Main {
    private static final Object lock;
    private static boolean isPing;

    public static void main(String[] args) {
        Thread pingThread = new Thread(new PingTask());
        Thread pongThread = new Thread(new PongTask());

        pingThread.start();
        pongThread.start();

        try {
            pingThread.join();
            pongThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    static class PingTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (!isPing) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    System.out.println("Ping");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    isPing = false;
                    lock.notifyAll();
                }
            }
        }
    }

    static class PongTask implements Runnable {
        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    while (isPing) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }

                    System.out.println("Pong");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    isPing = true;
                    lock.notifyAll();
                }
            }
        }
    }

    static {
        lock = new Object();
        isPing = true;
    }

}