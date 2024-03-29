# Temperature-Converter

This is a simple Java Swing-based GUI application for converting temperatures between Celsius, Fahrenheit, and Kelvin. The application includes a graphical interface with input fields, radio buttons, and buttons for temperature conversion.

![converterImage](https://github.com/zelengungor/Temperature-Converter/assets/80821262/b5f25a65-286c-4b18-a293-4c2536d420ad)
## Instructions

Follow these steps to run the Temperature Converter GUI:

1. Ensure you have Java installed on your machine.

2. Compile the Java files using the following commands in the terminal or command prompt:

    ```bash
    javac Model/*.java View/*.java
    ```

3. Run the Converter class:

    ```bash
    java View.Converter
    ```

4. The Temperature Converter GUI window should appear. Enter the temperature value, select the source temperature scale, select the target temperature scale, and click the "Make the Conversion" button. The converted temperature will be displayed.

## Usage

- Enter the temperature value in the provided text field.

- Select the source temperature scale (Celsius, Fahrenheit, or Kelvin) from the combo box.

- Choose the target temperature scale (Celsius, Fahrenheit, or Kelvin) using the radio buttons.

- Click the "Make the Conversion" button to perform the temperature conversion.

- To reset the input fields, click the "Reset" button.

## Command-Line Interface (Text-based)

An additional command-line interface (CLI) is provided for temperature conversion. To use it, run the `textView` class:

```bash
java View.textView
```

Follow the prompts to enter the temperature value and select the source and target temperature scales. The converted temperature will be displayed in the console.

## Notes

- The GUI supports temperature conversion within reasonable temperature ranges. Input validation is implemented to handle invalid input values.

- The CLI version allows temperature conversion through a text-based interface.

Feel free to explore and use this Temperature Converter GUI for your temperature conversion needs!

**Enjoy converting temperatures with the Temperature Converter GUI!**
