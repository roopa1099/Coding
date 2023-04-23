package designpattern.com.designpattern;

import designpattern.com.designpattern.adapterpattern.WeatherUi;
import designpattern.com.designpattern.factorypattern.PizzaStore;
import designpattern.com.designpattern.singleton.SingleTonClass;
import designpattern.com.designpattern.templatepattern.CSVDataRenderer;
import designpattern.com.designpattern.templatepattern.DataRenderer;
import designpattern.com.designpattern.templatepattern.XMLDataRenderer;

public class MainClass {
    public static void main(String[] args) {
            
    /**
     * SingleTon
     * 
     */

     SingleTonClass obj=SingleTonClass.getInstance();
     SingleTonClass obj2=SingleTonClass.getInstance();
     System.out.println(obj==obj2);


     /**
      * Factory Pattern
      */
      PizzaStore store=new PizzaStore();
      store.orderPizza("cheese");
        
     /**
      * Template Pattern
      */
      DataRenderer dataRenderer=new XMLDataRenderer();
      dataRenderer.render();

      dataRenderer=new CSVDataRenderer();
      dataRenderer.render();

      /**
       * Template pattern
       */
      WeatherUi weatherUi=new WeatherUi();
      System.out.println(weatherUi.findTemp(490006)); 
      
    }





}
