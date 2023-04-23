package designpattern.com.designpattern.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactoryClass {

    // cache
    static Map<String, Shape> objMap = new HashMap<>();

    public static Shape getShape(String type) {

        Shape obj = null;
        if (objMap.get(type) != null) {
            obj = objMap.get(type);
        } else {
            if (type.equals("circle")) {
                obj = new Circle();
            } else if (type.equals("rectangle")) {
                obj = new Rectangle();
            }

            objMap.put(type, obj);
        }

        return obj;
    }

}
