package designpattern.com.designpattern.decoratorpattern;

public class VeggiePizza  extends PizzaDecorator{
    
    public VeggiePizza(Pizza pizza){
       super(pizza);
    }

    public void bake(){
        super.bake();
        System.out.println("Adding veggies");
    }
}
