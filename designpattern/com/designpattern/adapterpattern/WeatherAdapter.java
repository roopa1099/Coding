package designpattern.com.designpattern.adapterpattern;

public class WeatherAdapter {

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
