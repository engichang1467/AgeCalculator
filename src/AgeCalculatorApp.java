/**
 * AgeCalculatorApp.java
 * This is the main class that start the whole thing
 * @author Michael Chang
 */

import javax.swing.*;

public class AgeCalculatorApp {

    /**
     * This is the main function that will call the GUI app
     * @param args
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AgeCalculatorGUI();
            }
        });

    }
}