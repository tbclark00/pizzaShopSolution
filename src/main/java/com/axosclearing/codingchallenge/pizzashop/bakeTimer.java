package com.axosclearing.codingchallenge.pizzashop;



import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bakeTimer {
    public static int seconds = 0;
    private static final int bakeTime = 30;
    private static String readyPizza;
    private static int delayTime = 1000;
    private static Timer timer;

    public static void startTimer() {
        timer = new Timer(delayTime, new timerHandler());
        timer.start();
    }

         public static class timerHandler implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(seconds == bakeTime) {
                    seconds = 0;
                    timer.stop();
                    if(pizzaQueue.hasPizza()) {
                        readyPizza = pizzaQueue.popFromQueue();
                        System.out.println("\n Your " + readyPizza.toLowerCase() + " is ready.");
                        //check to see if queue still has pizza after pop
                        if(pizzaQueue.hasPizza()){
                            System.out.println("Your next pizza is baking.");
                            pizza.restartBaking();
                        }
                    }
                }else{
                    System.out.println(seconds);
                    seconds++;
            }
        }
    }
}

