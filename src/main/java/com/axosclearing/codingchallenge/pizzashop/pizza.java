package com.axosclearing.codingchallenge.pizzashop;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class pizza {
    public static ArrayList<String> ingredients = new ArrayList<>();
    private static Scanner order;
    private static Scanner topping = new Scanner (System.in);
    public static ArrayList<String> pizzaOrder = new ArrayList<>();
    public static int i = 0;
    public static String orderConfirmation;
    public static boolean orderFlag = false;

    public static void main() {

        ingredients = getIngredients();
        listIngredients(ingredients);
        orderPizza();
    }


    public static void orderPizza() {
        if(!orderFlag) {
            System.out.print("Would you like to order a pizza? (Enter yes or no) ");
        }else{
            System.out.println("Would you like to order another pizza? (Enter yes or no)");
        }
        order = new Scanner(System.in);
        if(order.hasNext()) {
           orderConfirmation = order.next();
        }
        if (orderConfirmed(orderConfirmation)) {
            orderFlag = true;
            getToppings();
        }
        else{
            System.out.println("Please answer yes or no. \n");
            orderPizza();
        }
    }

    public static void getToppings() {
        System.out.print("Please enter a topping: ");
        while (topping.hasNextLine()) {
            String ingredientChosen = topping.nextLine();

            if (ingredient.checkIngredients(ingredientChosen)) {
                if(pizzaOrder.isEmpty()){
                    pizzaOrder.add(ingredientChosen);
                    i++;
                    getToppings();
                }
                if(pizzaOrder.get(i-1).matches(ingredientChosen)){
                    getToppings();
                }else {
                    pizzaOrder.add(ingredientChosen);
                    i++;
                    getToppings();
                }
            }
            if(ingredientChosen.isEmpty()){
                placePizzaOrder();
            }
            else {
                System.out.println("Ingredient unavailable \n");
                getToppings();
            }
            }

    }

    public static void listIngredients(ArrayList<String> ingredientList){
        for(i = 2; i < ingredientList.size(); i++){
            if(!isNumeric(ingredientList.get(i))) {
                System.out.println(ingredientList.get(i));
            }
        }
    }
    public static boolean isNumeric(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    private static void placePizzaOrder() {
        bakingThread.setOrderName(pizzaOrder);
        checkPizzaQueue();
    }

    public static void checkPizzaQueue(){
        String currentOrder = bakingThread.bakedPizza.toLowerCase();
        System.out.println(bakingThread.bakingPizza);
        if(pizzaQueue.hasPizza()){
            pizzaQueue.addToQueue(currentOrder);
            orderPizza();
            }
            else{
            pizzaQueue.addToQueueFirst(currentOrder);
            startBaking();
            orderPizza();
        }

    }

    public static void startBaking() {
        pizzaOrder = new ArrayList<>();
        bakeOrder();
        pizza.i = 0;
        orderPizza();
    }

    public static void restartBaking(){
        pizzaOrder = new ArrayList<>();
        pizza.i = 0;
        if(pizzaQueue.hasPizza()) {
            bakeNewOrder();
        }else {
            orderPizza();
        }
    }

    public static void bakeOrder(){
            bakingThread.start();
    }

    public static void bakeNewOrder(){
        bakingThread.restart();
    }

    private static boolean orderConfirmed (String orderConfirmation){
            boolean flag;
            if (orderConfirmation.toLowerCase().matches("y") || orderConfirmation.toLowerCase().matches("yes")) {
                flag = true;
            } else {
                flag = false;
            }
            return flag;
        }
        private static ArrayList<String> getIngredients () {
            String fileName = "src/main/resources/ingredient_inventory.csv";
            ArrayList<String> ingredients = new ArrayList<>();
            File file = new File(fileName);

            try {
                Scanner input = new Scanner(file);
                while (input.hasNext()) {
                    if (input.hasNextInt()) {
                        ingredients.add(input.next());
                    } else {
                        String ingredient = input.next().replace(",", "");
                        ingredients.add(ingredient);
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return ingredients;
        }
    }
