package designpattern.com.designpattern.flyweight;

// use abstract method instead of interface to declare empty methods without implementation
public abstract class Shape {
    
     public void draw(int length, int breadth, String fillStyle){ };

     public void draw(int radius, String fillColor, String lineColor){ }

   
    
}
