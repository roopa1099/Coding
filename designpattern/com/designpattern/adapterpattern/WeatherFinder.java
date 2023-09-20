package designpattern.com.designpattern.adapterpattern;

public class WeatherFinder implements WeatherInterface{

    /**
     * Takes city name
     */
    @Override
    public int showTemp(String city) {
        //  based on city return temperature
        return 33;
    }
    

}
