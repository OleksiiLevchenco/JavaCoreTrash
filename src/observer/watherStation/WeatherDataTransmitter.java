package observer.watherStation;

import observer.watherStation.displays.Observer;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Alexey Levchhenko
 */
public class WeatherDataTransmitter implements Observable {

    private List<Observer> observers = new LinkedList<Observer>();

    private WeatherParams weatherData;

    public WeatherParams getWeatherData() {
        return weatherData;
    }



    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update(this);
        }
    }

    public void weatherDataChange(WeatherParams weatherParams){

        weatherData = weatherParams;

        notifyObservers();
    }
}
