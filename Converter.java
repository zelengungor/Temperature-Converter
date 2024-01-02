import javax.swing.*;

import View.ConverterFrame;

public class Converter {

  public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> new ConverterFrame());
  }
}
