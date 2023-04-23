package designpattern.com.designpattern.decoratorpattern;

public class CheesePizza extends PizzaDecorator {

    public CheesePizza(Pizza pizza) {
        super(pizza);
    }

    public void bake(){
        super.bake();
        System.out.println("Adding Cheese");
    }
    
}
