package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class InputVerify {
        
    static void addInputValidation(JTextField textField, JFrame frame) {
       
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
              
                if (!Character.isDigit(c) ) {
                    e.consume();
                    JOptionPane.showMessageDialog(frame, "Please enter only numbers!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    textField.setText("");
                }
            }
        });
        
        textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String text = textField.getText();
                if (!text.matches("\\d+") && !text.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter only numbers!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    textField.setText(""); // Clear the text field if input is invalid
                }
            }
        });

        textField.setInputVerifier(new InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                String text = ((JTextField) input).getText();
                boolean isValid = text.matches("\\d+");
                if (!isValid) {
                    JOptionPane.showMessageDialog(frame, "Please enter only numbers!", "Invalid Input", JOptionPane.ERROR_MESSAGE);
                    ((JTextField) input).setText("");
                }
                return isValid;
            }

            @Override
            public boolean shouldYieldFocus(JComponent input) {
                return verify(input);
            }
        });
    }
}

