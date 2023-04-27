package designpattern.com.designpattern;

import designpattern.com.designpattern.adapterpattern.WeatherUi;
import designpattern.com.designpattern.builderpattern.Student;
import designpattern.com.designpattern.decoratorpattern.CheesePizza;
import designpattern.com.designpattern.decoratorpattern.Pizza;
import designpattern.com.designpattern.decoratorpattern.PlainBasePizza;
import designpattern.com.designpattern.decoratorpattern.VeggiePizza;
import designpattern.com.designpattern.factorypattern.PizzaStore;
import designpattern.com.designpattern.flyweight.Shape;
import designpattern.com.designpattern.flyweight.ShapeFactoryClass;
import designpattern.com.designpattern.prototypepattern.DeptDetails;
import designpattern.com.designpattern.prototypepattern.Employee;
import designpattern.com.designpattern.proxypattern.AuthorizationCheck;
import designpattern.com.designpattern.singleton.SingleTonClass;
import designpattern.com.designpattern.templatepattern.CSVDataRenderer;
import designpattern.com.designpattern.templatepattern.DataRenderer;
import designpattern.com.designpattern.templatepattern.XMLDataRenderer;

public class MainClass {
    public static void main(String[] args) throws Exception {
            
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

      /**
       * Flyweight pattern
       */

      
      /**
       *  If there is no factory class
        
       for(int i=1;i<10;i++){
             if(i%2==0){
            // new object is created everytime using new values


             Shape object=new Circle();

             *** no extrensic property division ***
             object.setRadius(3);
             object.setFillColor("red");
             object.setLineColior("white");
             object.draw();
          }
          else{
             Shape object=new Rectangle();

            *** no extrensic property division ***
             object.setLength(12);
             object.setBreadth(34);
             object.setFillStyle("dotted");
            object.draw();
         }
         */



      for(int i=1;i<10;i++){

        /**
         *  Every time already created obj will be returned from cache
         */
        if(i%2==0){
            Shape object=ShapeFactoryClass.getShape("circle");
            object.draw(3,"red","white");
        }
        else{
            Shape object=ShapeFactoryClass.getShape("rectangle");
            object.draw(12, 34, "dotted");
        }
      }

      
      /**
       * Decorator pattern
       * 
       */
      System.out.println("***********");
      Pizza pizza=new VeggiePizza(new CheesePizza(new PlainBasePizza()));
      pizza.bake();
      /**
       * Proxy pattern
       */
      System.out.println("***********");
      AuthorizationCheck authorizationCheck=new AuthorizationCheck();
      authorizationCheck.connectTo("airtel");

      /**
       * Prototype
       */

       System.out.println("***********");
       DeptDetails dept=new DeptDetails();
       dept.deptId=0011;

       DeptDetails dept2=dept.clone();
       Employee empl=new Employee();
       empl.setId(2);
       empl.setName("name3");
       
       dept.employees.add(empl);
       System.out.println(dept.employees);
       System.out.println(dept2.employees);


       /**
        * Builder class
        */
        System.out.println("*****@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@******");
        // not necessary to add all values
        Student student=Student.Builder.newInstance().setName("Faizal").setAge(23).build();
        student.print();

    
    }

    



}
