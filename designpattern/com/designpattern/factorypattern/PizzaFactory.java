package designpattern.com.designpattern.factorypattern;

public class PizzaFactory {
    // this method will be static
    public static PizzaInterfce createPizza(String type) {

        if(type=="cheese"){
            return new CheesePizza();
        }
        else if(type=="chicken"){
            return new ChickenPiiza();
        }
        else{
            return new VegPizza();
        }
        
    }
}
