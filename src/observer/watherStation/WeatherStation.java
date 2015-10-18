package observer.watherStation;

import observer.watherStation.displays.GeneralDisplay;
import observer.watherStation.displays.StatisticDisplay;

/**
 * @author Alexey Levchhenko
 */
public class WeatherStation {

    WeatherParams weatherData;
    WeatherDataTransmitter wdt;
    GeneralDisplay generalDisplay;
    StatisticDisplay statisticDisplay;

    public WeatherStation() {
        weatherData = new WeatherParams();
        wdt = new WeatherDataTransmitter();
        generalDisplay = new GeneralDisplay();
        statisticDisplay = new StatisticDisplay();
        wdt.addObserver( generalDisplay );
        wdt.addObserver( statisticDisplay );

    }


    public static void main(String[] args) {

        WeatherStation weatherStation = new WeatherStation();

        weatherStation.reciveNewData(20, 35, 700);
        weatherStation.reciveNewData(30, 40, 800);
        weatherStation.reciveNewData(35, 45, 800);
        weatherStation.reciveNewData(20, 35, 800);

    }

    private void reciveNewData(float t, float h, float p){

        weatherData.setTemperature(t);
        weatherData.setHumidity(h);
        weatherData.setPressure(p);
        wdt.weatherDataChange(weatherData);
    }
}
