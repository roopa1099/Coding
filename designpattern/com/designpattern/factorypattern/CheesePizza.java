package designpattern.com.designpattern.factorypattern;

public class CheesePizza implements PizzaInterfce {

    @Override
    public void cook() {
        // TODO Auto-generated method stub
        System.out.println("Cooking Cheese pizza");
    }

    @Override
    public void ready() {
        // TODO Auto-generated method stub
        System.out.println(" Cheese Pizza is ready");
    }
    
}
