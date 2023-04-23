package designpattern.com.designpattern.adapterpattern;

public class WeatherUi {

    public  int findTemp(int zipcode){
        /**
         * in this case the input here is zipcode
         * 
         * WeatherFinder showTemp() requires city name 
         * 
         * So, we create an adapter class to convert zip code to city and return temp. 
         * 
         * We could have done it here itself, but it is better to keep it less complex.
         */
        WeatherAdapter weatherAdapter=new WeatherAdapter();
        return weatherAdapter.findTemperature(zipcode);
    }
}
