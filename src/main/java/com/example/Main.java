package com.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        //Способ 1

//        final Object lock = new Object();
//
//        Leg rightLeg = new Leg("right", lock);
//        Leg leftLeg = new Leg("left", lock);
//
//        Thread threadLeft = new Thread(leftLeg);
//        Thread threadRight = new Thread(rightLeg);
//
//        threadLeft.start();
//        threadRight.start();

        //Способ 2

        String[] legs = {"right", "left"};
        Leg robot = new Leg(legs);

        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(robot);
    }
}