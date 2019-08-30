package com.axosclearing.codingchallenge.pizzashop;

public class ingredient {
    public static boolean checkIngredients(String ingredientChosen) {
        if(ingredientChosen.isEmpty()) {
            if(pizza.pizzaOrder.isEmpty()){
                System.out.println("Please choose at least one topping.");
                pizza.orderPizza();
            }
        }
        boolean flag = true;
        for (int i = 0; i < pizza.ingredients.size(); i++) {
            if (ingredientChosen.toLowerCase().contains(pizza.ingredients.get(i))) {
                if (ingredientsAvailable(Integer.parseInt(pizza.ingredients.get(i + 1)))) {
                    pizza.ingredients.set((i + 1), String.valueOf((Integer.parseInt((pizza.ingredients.get(i + 1))) - 1)));
                    return true;
                } else {
                    flag = false;
                }
            } else {
                flag = false;
            }
        }
        return flag;
    }

    private static boolean ingredientsAvailable(int numberOfIngredient) {
        boolean flag;
        if(numberOfIngredient > 0){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }
}
