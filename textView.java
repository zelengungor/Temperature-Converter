package View;

import Model.TempConversions;
import Model.TempScale;

import java.util.Scanner;

class textView {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the temperature value:");
    double temperature = scanner.nextDouble();

    System.out.println("Enter the source temperature scale (CELSIUS, FAHRENHEIT, KELVIN):");
    TempScale fromScale = TempScale.valueOf(scanner.next().toUpperCase());

    System.out.println("Enter the target temperature scale (CELSIUS, FAHRENHEIT, KELVIN):");
    TempScale toScale = TempScale.valueOf(scanner.next().toUpperCase());

    TempConversions tempConversions = new TempConversions();
    double convertedTemperature = tempConversions.convertTemperature(temperature, fromScale, toScale);

    System.out.println("Converted temperature: " + convertedTemperature);
  }
}
