package com.example;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> leftQueue = new ArrayBlockingQueue<String>(1);
        BlockingQueue<String> rightQueue = new ArrayBlockingQueue<String>(1);

        Leg rightLeg = new Leg("Right", leftQueue, rightQueue);
        Leg leftLeg = new Leg("Left", rightQueue, leftQueue);

        rightQueue.put("Go");

        rightLeg.fork();
        leftLeg.fork();

        rightLeg.join();
        leftLeg.join();

    }
}