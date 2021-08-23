/**
 * AgeCalculatorGUI.java
 *
 * The GUI of the Age Calculator
 * @author Michael Chang
 */

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import com.github.lgooddatepicker.components.*;

public class AgeCalculatorGUI {

    // Setting up the application frame
    FlowLayout experimentLayout;
    JFrame applicationFrame;
    JPanel mainPanel;

    // Panel for age message
    TitledBorder ageMessageTitle;
    JLabel ageMessage;
    JPanel ageMessagePanel;
    Border ageMessageInnerBorder;

    // Panel for get date panel
    JPanel getDatePanel;
    private DatePicker dtp;
    JButton getDateButton;

    /**
     * The is the function that creates the GUI
     */
    public AgeCalculatorGUI() {
        applicationFrame = new JFrame("CMPT 213 Age Calculator");
        applicationFrame.setSize(450, 200);
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Tells what happen when the window is closed
        applicationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        experimentLayout = new FlowLayout();

        // add a panel for get age
        ageMessagePanel = new JPanel();
        ageMessageTitle = BorderFactory.createTitledBorder("Your age as of today");
        ageMessagePanel.setBorder(ageMessageTitle);

        ageMessageInnerBorder = new EmptyBorder(20,20,20,20);
        ageMessagePanel.setBorder(BorderFactory.createCompoundBorder(ageMessageTitle, ageMessageInnerBorder));
        ageMessage = new JLabel("Enter your data of birth and press the 'Check Age' button");
        ageMessagePanel.add(ageMessage);
        mainPanel.add(ageMessagePanel);

        // Section for user input date
        getDatePanel = new JPanel();
        getDatePanel.setBorder(new EmptyBorder(20,20,20,20));
        DatePickerSettings settings = new DatePickerSettings();

        dtp = new DatePicker(settings);
        LocalDate today = LocalDate.now();
        settings.setDateRangeLimits(LocalDate.MIN, today);
        getDatePanel.add(dtp);

        getDateButton = new JButton("Check Age");
        getDateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalDate birthDate = dtp.getDate();
                LocalDate today = LocalDate.now();

                // Check if the input is empty
                if (birthDate == null) {
                    JOptionPane.showMessageDialog(applicationFrame, "Please insert your birthday before checking your age");
                }

                // Get the user's age
                int age = Period.between(birthDate, today).getYears();

                // Check if the birthday is today or the same month and date
                if (birthDate.compareTo(today) == 0 || (birthDate.getMonth() == today.getMonth() && birthDate.getDayOfMonth() == today.getDayOfMonth()))
                {
                    ageMessage.setText("You are " + age + " year old! Happy Birthday!!");
                } else {
                    ageMessage.setText("You are " + age + " year old!");
                }

            }
        });
        getDatePanel.add(getDateButton);

        mainPanel.add(getDatePanel);

        applicationFrame.add(mainPanel);
        applicationFrame.setVisible(true);
    }
}