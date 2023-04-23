package designpattern.com.designpattern.factorypattern;

public class VegPizza implements PizzaInterfce{

    @Override
    public void cook() {
        // TODO Auto-generated method stub
        System.out.println("Cooking Veg pizza");
    }

    @Override
    public void ready() {
        // TODO Auto-generated method stub
        System.out.println("Veg pizza is ready");
    }
    
}
