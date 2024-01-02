package View;

import Model.TempConversions;

import javax.swing.*;
import java.awt.*;

public class ConverterFrame extends JFrame {

  public ConverterFrame() {
    super("Temperature Converter");

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    ConverterPanel converterPanel = new ConverterPanel(new TempConversions());

    setContentPane(converterPanel);  // Set the custom panel as the content pane

    setSize(500, 350);  // Adjusted the height to 250

    setLocationRelativeTo(null);

    getContentPane().setBackground(Color.decode("#E1E6FF"));

    setBackground(Color.decode("#E1E6FF"));

    setResizable(false);

    setVisible(true);
  }
}
