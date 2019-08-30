package com.axosclearing.codingchallenge.pizzashop;

import java.util.ArrayList;


public class bakingThread implements Runnable {
    public static String bakedPizza;
    public static Thread bake;
    public static String bakingPizza;

    public static void setOrderName(ArrayList<String> order){
        bakedPizza = String.join(" and ", order) + " pizza";
        bakingPizza = "Placing an order for " + bakedPizza.toLowerCase();
    }

    public void run(){

        }
        public static void start(){
            bake = new Thread(new bakingThread());
            bake.start();
            bakeTimer.startTimer();

        }

        public static void restart(){
        bake = new Thread(new bakingThread());
        bake.start();
        bakeTimer.startTimer();
        }
    }

