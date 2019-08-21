package com.atguigu.gmall.bean;


class Pizza {

    private String parts;

    @Override
    public String toString() {
        return parts;
    }

    public void setParts(String parts) {
        this.parts = parts;

    }
}


abstract class PizzaBuilder {

    protected Pizza pizza;

    public Pizza getPizza() {
        return pizza;
    }

    public void createNewPizza() {
        Pizza pizza = new Pizza();
    }


    public abstract void buildParts();//第一个空
}


class HawaiianPizzaBuilder extends PizzaBuilder {

    public void buildParts() {
        pizza.setParts("cross + mild + ham&pineapple");
    }
}

class SpicyPizzaBuilder extends PizzaBuilder {
    public void buildParts() {
        pizza.setParts("没啥用");
    }
}

class Waiter {

    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }

    public Pizza getPizza() {
        return pizzaBuilder.getPizza();
    }

    public void construct() {
        pizzaBuilder.createNewPizza();
    }

  //  pizzaBuilder.buildParts();
}


class FastFoodOrdering {

    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiian_pizzabuilder = new HawaiianPizzaBuilder();
        hawaiian_pizzabuilder.buildParts();
        System.out.println("pizza" + waiter.getPizza());
    }
}

