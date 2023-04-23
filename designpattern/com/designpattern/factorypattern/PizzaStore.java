package designpattern.com.designpattern.factorypattern;

public class PizzaStore {
    /**
     * Responsible for placing orders
     */
    public PizzaInterfce orderPizza(String type){
        //not responsible for object creatiobn
        PizzaInterfce pizza=PizzaFactory.createPizza(type);
        pizza.cook();
        pizza.ready();
        return pizza;
    }

}
