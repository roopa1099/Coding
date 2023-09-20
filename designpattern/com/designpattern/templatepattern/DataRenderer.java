package designpattern.com.designpattern.templatepattern;


/**
 * Defines template for child class
 */
public abstract class DataRenderer {
    //single template method to call all other method
    public void render() {
        String readData=readData();
        String processedData=processData(readData);
        System.out.println(processedData);
    }

    public abstract String readData();

    public abstract String processData(String data);
}
