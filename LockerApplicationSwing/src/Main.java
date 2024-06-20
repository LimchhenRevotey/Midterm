import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {
    private JPasswordField passwordField;
    private JLabel statusLabel;
    private String password;
    private boolean isPasswordSet;

    public Main() {
        setTitle("Locker Application");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 160);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel buttonPanel = new JPanel(new GridLayout(3,3));

        String[] textButton = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (String number : textButton){
            JButton button = new JButton(number);
            buttonPanel.add(button);
            button.addActionListener(e -> {
                String buttonClick = e.getActionCommand();
                switch (buttonClick){
                    case "1", "2", "3", "4", "5", "6", "7", "8", "9" -> display(buttonClick);
                }
            });
        }

        panel.add(buttonPanel);

        JPanel submitPanel = new JPanel(new FlowLayout(10));

        JButton btnClear = new JButton("Clear");
        passwordField = new JPasswordField();
        passwordField.setPreferredSize(new Dimension(200, 30));
        JButton btnEnter = new JButton("Enter");
        statusLabel = new JLabel("Enter Password");

        btnClear.addActionListener(e -> {
            passwordField.setText("");
        });

        submitPanel.add(btnClear);
        submitPanel.add(passwordField);
        submitPanel.add(btnEnter);
        submitPanel.add(statusLabel);

        btnEnter.addActionListener(e -> {
            String enteredPassword = passwordField.getText();
            if (!isPasswordSet) {
                password = enteredPassword;
                statusLabel.setText("Password Set");
                isPasswordSet = true;
            } else {
                if (enteredPassword.equals(password)) {
                    statusLabel.setText("Correct Password");
                } else {
                    statusLabel.setText("Incorrect Password");
                }
            }
            passwordField.setText("");
        });


        add(panel, BorderLayout.NORTH);
        add(submitPanel, BorderLayout.CENTER);
    }

    public void display(String number){
        passwordField.setText(passwordField.getText() + number);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main app = new Main();
            app.setVisible(true);
        });
    }
}