package com.practice.multithreading;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {

    Queue<Integer> buffer;
    int limit;
    public ProducerConsumer(int limit) {
        buffer = new LinkedList<>();
        this.limit = limit;
    }

    public synchronized void produce() throws InterruptedException {
        int value = 0;
        while(true) {
            if (buffer.size() == limit) {
                System.out.println("Buffer Full - "+ Thread.currentThread().getName() + " waiting");
                wait();
            } else {
                System.out.println( Thread.currentThread().getName() + " - producing : " + value);
                buffer.add(value ++);
                notifyAll();
                Thread.sleep(1000);
            }

        }
    }
    public synchronized void consume() throws InterruptedException {
        while(true) {
            if (buffer.size() == 0) {
                System.out.println("Buffer Empty - "+ Thread.currentThread().getName() + " waiting");
                wait();
            } else {
                System.out.println( Thread.currentThread().getName() + " - consuming : " + buffer.poll());
                notifyAll();
                Thread.sleep(1000);
            }

        }
    }

    public static void main(String args[]) throws InterruptedException {
        ProducerConsumer producerConsumer = new ProducerConsumer(5);
        Runnable producer = () -> {
            try {
                producerConsumer.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable consumer = () -> {
            try {
                producerConsumer.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Thread t1 = new Thread(producer, "P1");
        Thread t2 = new Thread(producer, "P2");
        Thread t3 = new Thread(consumer, "C1");
        Thread t4 = new Thread(consumer, "C2");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();

    }

}
