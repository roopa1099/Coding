package designpattern.com.designpattern.flyweight;

public class Rectangle extends Shape{

    private String label;
    // extrensic so will take them a parameters 
    // private int length;
    // private int breadth;
    // private String fillStyle;
   
    public Rectangle(){
        label="Rectangle";
    }

    @Override
    public void draw(int length, int breadth, String fillStyle) {
        System.out.println("Drawing "+label+" with length "+length+" and breadth "+breadth+" and style is "+fillStyle);
    }
    
}
