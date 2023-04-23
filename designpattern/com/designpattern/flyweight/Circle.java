package designpattern.com.designpattern.flyweight;

public class Circle extends Shape{
    

    private String label;
    // extrensic so will take them a parameters 
    // private int radius;
    // private String fillColor;
    // private String lineColor;

    public Circle(){
        label="Circle";
    }

    @Override
    public void draw(int radius, String fillColor, String lineColor) {
        System.out.println("Drawing "+label+" with radius "+radius+" filled with "+fillColor+" and line color is "+lineColor);
    }

}
