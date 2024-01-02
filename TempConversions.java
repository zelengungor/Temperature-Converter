package Model;

public class TempConversions implements ConversionInterface {
  @Override
  public double kelvinToCelsius(double k) {
    return k - 273.15;
  }

  @Override
  public double kelvinToFahrenheit(double k) {
    return (k - 273.15) * 9 / 5 + 32;
  }

  @Override
  public double celsiusToKelvin(double c) {
    return c + 273.15;
  }

  @Override
  public double celsiusToFahrenheit(double c) {
    return (c * 9 / 5) + 32;
  }

  @Override
  public double fahrenheitToCelsius(double f) {
    return (f - 32) * 5 / 9;
  }

  @Override
  public double fahrenheitToKelvin(double f) {
    return (f - 32) * 5 / 9 + 273.15;
  }

  @Override
  public double convertTemperature(double temperature, TempScale fromScale, TempScale toScale) {
    if (fromScale == toScale) {
      return temperature;
    }

    switch (fromScale) {
      case CELSIUS:
        switch (toScale) {
          case CELSIUS:
            return temperature;
          case FAHRENHEIT:
            return celsiusToFahrenheit(temperature);
          case KELVIN:
            return celsiusToKelvin(temperature);
          default:
            throw new IllegalArgumentException("Unsupported target temperature scale: " + toScale);
        }
      case FAHRENHEIT:
        switch (toScale) {
          case CELSIUS:
            return fahrenheitToCelsius(temperature);
          case FAHRENHEIT:
            return temperature;
          case KELVIN:
            return fahrenheitToKelvin(temperature);
          default:
            throw new IllegalArgumentException("Unsupported target temperature scale: " + toScale);
        }
      case KELVIN:
        switch (toScale) {
          case CELSIUS:
            return kelvinToCelsius(temperature);
          case FAHRENHEIT:
            return kelvinToFahrenheit(temperature);
          case KELVIN:
            return temperature;
          default:
            throw new IllegalArgumentException("Unsupported target temperature scale: " + toScale);
        }
      default:
        throw new IllegalArgumentException("Unsupported temperature scale: " + fromScale);
    }
  }
}
