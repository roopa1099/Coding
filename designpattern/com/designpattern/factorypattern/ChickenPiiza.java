package designpattern.com.designpattern.factorypattern;

public class ChickenPiiza implements PizzaInterfce{

    @Override
    public void cook() {
        // TODO Auto-generated method stub
        System.out.println("Cooking Chicken pizza");
    }

    @Override
    public void ready() {
        // TODO Auto-generated method stub
        System.out.println("Chicken pizza is ready");
    }

}
