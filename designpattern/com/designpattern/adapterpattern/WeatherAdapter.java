package designpattern.com.designpattern.adapterpattern;

public class WeatherAdapter {

    // the user might want to send zipcode instead of city name, so adapter does the conversion from zipcode to city
    public int findTemperature(int zipcode){
    String city;
    if(zipcode==19012){
        city="Dubai";
    }
    else if(zipcode==490006){
        city="Bhilai";
    }
    else{
        city="Cityy";
    }

    /**
     * Conversion
     */
    WeatherFinder weatherFinder=new WeatherFinder();
   return  weatherFinder.showTemp(city);
    }

}
