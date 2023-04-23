package designpattern.com.designpattern.adapterpattern;

public class WeatherFinder implements WeatherInterface{

    /**
     * Takes city name
     */
    @Override
    public int showTemp(String city) {
        return 33;
    }
    

}
