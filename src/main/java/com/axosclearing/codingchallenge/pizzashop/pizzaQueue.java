package com.axosclearing.codingchallenge.pizzashop;

public class pizzaQueue {
    public static class Node {
        private String pizza;
        private Node next;
        private Node (String pizza){
            this.pizza = pizza;
        }

    }
    private static Node head;
    private static Node tail;

    public static boolean hasPizza() {
        return head != null;
    }

    public static void addToQueue(String nextPizza){
        Node node = new Node(nextPizza);
        if(tail != null){
            tail.next = node;
        }else{
            tail = node;
        }
    }

    public static void addToQueueFirst(String firstPizza){
        Node node = new Node(firstPizza);
        if(head == null){
            head = node;
        }
    }

    public static String popFromQueue() {
        String oldPizza = head.pizza;
        if(tail != null){
            head = tail;
            if(tail.next != null){
                tail = tail.next;
            }else{
                tail = null;
            }
        }else{
            head = null;
        }
        return oldPizza;
    }

}
