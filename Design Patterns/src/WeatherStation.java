import java.util.ArrayList;
import java.util.List;
interface Subject {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
class WeatherStation implements Subject {
    private List<Observer> observers;
    private int temperature;
    public WeatherStation() {
        observers = new ArrayList<>();
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
        notifyObservers();
    }
    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}
interface Observer {
    void update(int temperature);
}
class Display implements Observer {
    private int temperature;
    @Override
    public void update(int temperature) {
        this.temperature = temperature;
        display();
    }
    private void display() {
        System.out.println("Current Temperature: " + temperature);
    }
}
class WeatherObserverMain {
    public static void main(String[] args) {
        WeatherStation weatherStation = new WeatherStation();

        Display display1 = new Display();
        Display display2 = new Display();

        weatherStation.registerObserver(display1);
        weatherStation.registerObserver(display2);

        weatherStation.setTemperature(27);
        weatherStation.setTemperature(34);

        weatherStation.removeObserver(display1);

        weatherStation.setTemperature(30);
    }
}
