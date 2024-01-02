package View;

import Model.ConversionInterface;
import Model.TempScale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConverterPanel extends JPanel {

  private JTextField textField;
  private JComboBox<String> comboBox;
  private JRadioButton kelvinRadioButton;
  private JRadioButton celsiusRadioButton;
  private JRadioButton fahrenheitRadioButton;
  private JLabel resultLabel;

  private ConversionInterface conversion;

  public ConverterPanel(ConversionInterface conversion) {
    this.conversion = conversion;
    setLayout(new GridBagLayout());
    setBackground(Color.decode("#F7FDFF"));
    initializeComponents();
  }

  private void initializeComponents() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.insets = new Insets(5, 5, 5, 5);

    // Create the "TEMPERATURE CONVERSION" label with a matching background color
    JLabel titleLabel = new JLabel("TEMPERATURE CONVERSION");
    titleLabel.setFont(new Font("Horizon", Font.BOLD, 19));
    titleLabel.setOpaque(true);
    titleLabel.setBackground(Color.decode("#F7FDFF"));
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 3;
    gbc.weighty = 0;
    gbc.anchor = GridBagConstraints.PAGE_START;
    add(titleLabel, gbc);

    // Create the "From" label
    JLabel fromLabel = new JLabel("From the value");
    fromLabel.setFont(new Font("JOptionPane", Font.PLAIN, 15));
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.LINE_START;
    add(fromLabel, gbc);

    // Create a JTextField
    textField = new JTextField(10);
    gbc.gridx = 1;
    gbc.anchor = GridBagConstraints.LINE_START;
    add(textField, gbc);

    // Create a JComboBox
    String[] temperatureOptions = {"Celsius", "Fahrenheit", "Kelvin"};
    comboBox = new JComboBox<>(temperatureOptions);
    gbc.gridx = 2;
    add(comboBox, gbc);

    // Create the "Convert to the Unit" label
    JLabel convertToLabel = new JLabel("Convert to the unit of");
    convertToLabel.setFont(new Font("JOptionPane", Font.PLAIN, 15));
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 3;
    gbc.anchor = GridBagConstraints.LINE_START;
    add(convertToLabel, gbc);

    // Create JRadioButton components
    kelvinRadioButton = new JRadioButton("Kelvin");
    celsiusRadioButton = new JRadioButton("Celsius");
    fahrenheitRadioButton = new JRadioButton("Fahrenheit");

    // Group the radio buttons to achieve mutual exclusion
    ButtonGroup group = new ButtonGroup();
    group.add(kelvinRadioButton);
    group.add(celsiusRadioButton);
    group.add(fahrenheitRadioButton);

    // Add JRadioButton components below the "Convert to the Unit" label
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    add(kelvinRadioButton, gbc);

    gbc.gridy = 4;
    add(celsiusRadioButton, gbc);

    gbc.gridy = 5;
    add(fahrenheitRadioButton, gbc);

    // Create the "Make the Conversion" button
    JButton conversionButton = new JButton("Make the Conversion");
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    add(conversionButton, gbc);

    // Create the "Reset" button
    JButton resetButton = new JButton("Reset");
    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.gridwidth = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    add(resetButton, gbc);

    // Create the result label
    resultLabel = new JLabel();
    gbc.gridx = 0;
    gbc.gridy = 8;
    gbc.gridwidth = 3;
    gbc.anchor = GridBagConstraints.CENTER;
    add(resultLabel, gbc);

    // Action listener for the conversion button
    conversionButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        convertTemperature();
      }
    });

    // Action listener for the reset button
    resetButton.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        resetFields();
      }
    });
  }

  private void convertTemperature() {
    try {
      double inputValue = Double.parseDouble(textField.getText());
      TempScale fromScale = getSelectedTempScale();
      TempScale toScale = getSelectedConversionScale();

      // Check for impossible temperatures
      if (isImpossibleTemperature(inputValue, fromScale)) {
        displayErrorMessage("Invalid input. Please enter a valid temperature value.");
        return;
      }

      double result = conversion.convertTemperature(inputValue, fromScale, toScale);
      resultLabel.setText(String.format("%.2f° %s is equal to %.2f° %s",
              inputValue, fromScale.name(), result, toScale.name()));
    } catch (NumberFormatException ex) {
      displayErrorMessage("Invalid input. Please enter a numeric value.");
    }
  }

  private void displayErrorMessage(String message) {
    JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
  }

  private boolean isImpossibleTemperature(double temperature, TempScale scale) {
    switch (scale) {
      case CELSIUS:
        return temperature < -273.15 || temperature > 5000;
      case FAHRENHEIT:
        return temperature < -459.67 || temperature > 9032;
      case KELVIN:
        return temperature < 0 || temperature > 5000;
      default:
        return false;
    }
  }

  private TempScale getSelectedTempScale() {
    String selectedUnit = (String) comboBox.getSelectedItem();
    switch (selectedUnit) {
      case "Celsius":
        return TempScale.CELSIUS;
      case "Fahrenheit":
        return TempScale.FAHRENHEIT;
      case "Kelvin":
        return TempScale.KELVIN;
      default:
        throw new IllegalArgumentException("Invalid temperature scale: " + selectedUnit);
    }
  }

  private TempScale getSelectedConversionScale() {
    if (kelvinRadioButton.isSelected()) {
      return TempScale.KELVIN;
    } else if (celsiusRadioButton.isSelected()) {
      return TempScale.CELSIUS;
    } else if (fahrenheitRadioButton.isSelected()) {
      return TempScale.FAHRENHEIT;
    } else {
      throw new IllegalArgumentException("No conversion unit selected");
    }
  }

  private void resetFields() {
    textField.setText("");
    comboBox.setSelectedIndex(0);
    kelvinRadioButton.setSelected(false);
    celsiusRadioButton.setSelected(false);
    fahrenheitRadioButton.setSelected(false);
    resultLabel.setText("");
  }
}

