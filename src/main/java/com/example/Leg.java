package com.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RecursiveAction;

public class Leg extends RecursiveAction {

    private final String name;
    private final BlockingQueue<String> inputQueue;
    private final BlockingQueue<String> outputQueue;

    public Leg(String name, BlockingQueue<String> inputQueue, BlockingQueue<String> outputQueue) {
        this.name = name;
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
    }

    @Override
    protected void compute() {
        while (true){
            try {
                inputQueue.take();
                System.out.println(name);
                outputQueue.put("Go");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
