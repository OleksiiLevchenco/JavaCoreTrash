package observer.watherStation.displays;

import observer.watherStation.WeatherParams;
import observer.watherStation.Observable;
import observer.watherStation.WeatherDataTransmitter;


/**
 * @author Alexey Levchhenko
 */
public class GeneralDisplay implements Observer, Display {

    WeatherParams weatherParams;

    public GeneralDisplay() {
        weatherParams = new WeatherParams();
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof WeatherDataTransmitter){
        weatherParams = ((WeatherDataTransmitter) observable).getWeatherData();
        display();
        }
    }

    @Override
    public void display() {

        System.out.println(weatherParams);

    }
}
