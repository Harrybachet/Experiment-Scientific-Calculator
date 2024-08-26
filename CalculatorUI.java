import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorUI {
    private JFrame frame;
    private JTextField display;
    private Calculator calculator;

    public CalculatorUI() {
        calculator = new Calculator();

        frame = new JFrame("Scientific Calculator");
        display = new JTextField();

        // Setting up the display
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        frame.add(display, BorderLayout.NORTH);

        // Setting up buttons
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "sqrt", "log", "M+", "MR"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.PLAIN, 20));
            button.addActionListener(new ButtonClickListener());
            panel.add(button);
        }

        frame.add(panel, BorderLayout.CENTER);

        // Frame settings
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("=")) {
                try {
                    double result = calculator.calculate(display.getText());
                    display.setText(Double.toString(result));
                } catch (InvalidInputException | MathOperationException ex) {
                    display.setText("Error: " + ex.getMessage());
                }
            } else if (command.equals("M+")) {
                calculator.getMemory().addToMemory(Double.parseDouble(display.getText()));
            } else if (command.equals("MR")) {
                display.setText(Double.toString(calculator.getMemory().recallMemory()));
            } else if (command.equals("sqrt") || command.equals("log")) {
                display.setText(display.getText() + " " + command + " ");
            } else {
                display.setText(display.getText() + command);
            }
        }
    }
}
