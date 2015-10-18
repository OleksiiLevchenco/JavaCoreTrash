package observer.watherStation.displays;

import observer.watherStation.WeatherDataTransmitter;
import observer.watherStation.WeatherParams;
import observer.watherStation.Observable;

/**
 * @author Alexey Levchhenko
 */
public class StatisticDisplay implements Observer, Display {

    WeatherParams averageWeatherParams;
    WeatherParams newWeatherParams;
    float maxTemperature;
    float minTemperature;
    boolean firstStart = true;

    public StatisticDisplay() {
        averageWeatherParams = new WeatherParams();
    }

    @Override
    public void update(Observable observable) {
        if (observable instanceof WeatherDataTransmitter){
            WeatherParams newWeatherParams = ((WeatherDataTransmitter) observable).getWeatherData();

            if (firstStart) {
                maxTemperature = newWeatherParams.getTemperature();
                minTemperature = newWeatherParams.getTemperature();
                averageWeatherParams = newWeatherParams;
                firstStart = false;
            }

        averageWeatherParams = averageParams(averageWeatherParams, newWeatherParams);
        extremaTemperature(newWeatherParams);
        display();
        }
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    private WeatherParams averageParams(WeatherParams w1, WeatherParams w2) {



        WeatherParams temp = new WeatherParams();
        temp.setTemperature((w1.getTemperature() + w2.getTemperature()) / 2);
        temp.setPressure((w1.getPressure() + w2.getPressure()) / 2);
        temp.setHumidity((w1.getHumidity() + w2.getHumidity()) / 2);

        return temp;
    }

    private void extremaTemperature(WeatherParams weatherParams) {
        if (firstStart) {
            this.maxTemperature = weatherParams.getTemperature();
            this.minTemperature = weatherParams.getTemperature();
            firstStart = false;
        } else {
            this.maxTemperature = Math.max(this.maxTemperature, weatherParams.getTemperature());
            this.minTemperature = Math.min(this.minTemperature, weatherParams.getTemperature());
        }

    }

    @Override
    public String toString() {
        return "StatisticDisplay{" +
                "minTemperature=" + minTemperature +
                ", maxTemperature=" + maxTemperature +
                ", averageWeatherParams= " + averageWeatherParams +
                '}';
    }
}
