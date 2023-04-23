package designpattern.com.designpattern.decoratorpattern;

public class PizzaDecorator implements Pizza{
    
    private Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza=pizza;
    }


    @Override
    public void bake() {
        // TODO Auto-generated method stub
        pizza.bake();
    }
}
