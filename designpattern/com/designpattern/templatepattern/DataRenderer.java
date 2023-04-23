package designpattern.com.designpattern.templatepattern;


/**
 * Defines template for child class
 */
public abstract class DataRenderer {
    
    public void render() {
        String readData=readData();
        String processedData=processData(readData);
        System.out.println(processedData);
    }

    public abstract String readData();

    public abstract String processData(String data);
}
