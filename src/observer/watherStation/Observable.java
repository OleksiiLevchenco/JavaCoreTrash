package observer.watherStation;

import observer.watherStation.displays.Observer;

/**
 * @author Alexey Levchhenko
 */
public interface Observable {

    public void addObserver(Observer o);

    public void deleteObserver(Observer o);

    public void notifyObservers();


}
