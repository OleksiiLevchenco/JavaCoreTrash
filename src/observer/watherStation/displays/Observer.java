package observer.watherStation.displays;

import observer.watherStation.Observable;


/**
 * @author Alexey Levchhenko
 */
public interface Observer {
    public void update(Observable observable);
}
