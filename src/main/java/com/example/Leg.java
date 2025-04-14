package com.example;

    //Способ 1
//public class Leg implements Runnable {
//    private final String name;
//    private final Object lock;
//
//    public Leg(String name, Object lock) {
//        this.name = name;
//        this.lock = lock;
//    }
//
//    @Override
//    public void run() {
//        while (true){
//            synchronized (lock) {
//                lock.notify();
//                System.out.println(name);
//                try {
//                    lock.wait();
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        }
//    }
//}

    //Способ 2

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

public class Leg extends RecursiveTask {

    final String[] legs;

    public Leg(String[] legs) {
        this.legs = legs;
    }

    @Override
    protected String compute() {
            if(legs.length == 1) {
                return legs[0];
            }
            else {
                while (true) {
                    Leg left = new Leg(Arrays.copyOfRange(legs, 0, 1));
                    Leg right = new Leg(Arrays.copyOfRange(legs, 1, legs.length));

                    left.fork();
                    System.out.println(right.compute());
                    System.out.println(left.join());
                }
            }
    }
}