package Model;

public interface ConversionInterface {
  double kelvinToCelsius(double k);
  double kelvinToFahrenheit(double k);

  double celsiusToKelvin(double c);
  double celsiusToFahrenheit(double c);

  double fahrenheitToCelsius(double f);
  double fahrenheitToKelvin(double f);

  double convertTemperature(double temperature, TempScale fromScale, TempScale toScale);
}
