import java.util.Scanner;
public class FahrenheitTemp {
    private double temp;
    public FahrenheitTemp(double temp) {
        this.temp = temp;
    }
    public double getTemp() {
        return temp;
    }
}
interface CelsiusTemp {
    double getTempInCelsius();
}
class FahrenheitToCelsiusAdapter implements CelsiusTemp {
    private FahrenheitTemp fahrenheitTemp;
    public FahrenheitToCelsiusAdapter(FahrenheitTemp fahrenheitTemp) {
        this.fahrenheitTemp = fahrenheitTemp;
    }
    public double getTempInCelsius() {
        // Convert Fahrenheit to Celsius
        return (fahrenheitTemp.getTemp() - 32) * 5 / 9;
    }
}
class FtoCAdapterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter temperature in Fahrenheit: ");
        double temp = scanner.nextDouble();

        FahrenheitTemp fahrenheitTemp = new FahrenheitTemp(temp);
        CelsiusTemp adapter = new FahrenheitToCelsiusAdapter(fahrenheitTemp);

        double tempInCelsius = adapter.getTempInCelsius();
        System.out.println("Temperature in Celsius: " + tempInCelsius + " °C");
    }
}
