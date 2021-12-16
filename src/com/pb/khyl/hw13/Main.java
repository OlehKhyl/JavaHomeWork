package com.pb.khyl.hw13;

import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static class Writer extends Thread {
        private final Object lock;
        private final Queue<Integer> queueBuffer;

        public Writer(Object lock, Queue<Integer> queueBuffer) {
            this.lock = lock;
            this.queueBuffer = queueBuffer;
        }

        @Override
        public void run() {
            int number = 0;
            for (int i = 0; i < 100; i++) {
                if (queueBuffer.size()<10) {
                    number += 1;
                    synchronized (lock) {
                        queueBuffer.add(number);
                        lock.notify();
                        if (queueBuffer.size() >= 10) {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }

    public static class Reader extends Thread {
        private final Object lock;
        private final Queue<Integer> queueBuffer;

        public Reader(Object lock, Queue<Integer> queueBuffer) {
            this.lock = lock;
            this.queueBuffer = queueBuffer;
        }

        @Override
        public void run() {
            int number = 0;
            int counter = 0;
            while (true) {
                if (!queueBuffer.isEmpty()) {
                synchronized (lock) {
                    number = queueBuffer.remove();
                    lock.notify();
                    if (queueBuffer.isEmpty()) {
                        try {
                            lock.wait(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                    System.out.print(number + ", ");
                    counter++;
                    if (counter % 10 == 0) {
                        System.out.println();
                    }

                }
            }
        }
    }

    public static void main(String[] args) {
        Object lock = new Object();
        Queue<Integer> queueBuffer = new LinkedList<>();
        Writer writer = new Writer(lock, queueBuffer);
        Reader reader = new Reader(lock, queueBuffer);
        writer.start();
        reader.start();
        while (true) {
            if (!writer.isAlive() && queueBuffer.isEmpty()) {
                System.exit(0);
            }
        }
    }
}
