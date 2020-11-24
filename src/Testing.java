import javax.swing.*;
import java.awt.Color;

public class Testing {

    public JPanel createContentPane() {

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setBackground(Color.CYAN);
        // totalGUI.setSize(100, 100);

        // We set the Layout Manager to null so we can manually place
        // the Panels.
        totalGUI.setLayout(null);

        // Now we create a new panel, size it, shape it,color it red.
        // then add it to the bottom JPanel.
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setLocation(10, 10);
        redPanel.setSize(50, 50);
        totalGUI.add(redPanel);

        // JPanel bluePanel = new JPanel();
        // bluePanel.setBackground(Color.blue);
        // bluePanel.setLocation(220, 10);
        // bluePanel.setSize(50, 50);
        // totalGUI.add(bluePanel);

        // Finally we return the JPanel.
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    public JPanel createContentPane(int n) {

        // We create a bottom JPanel to place everything on.
        JPanel totalGUI = new JPanel();
        totalGUI.setBackground(Color.CYAN);
        // totalGUI.setSize(100, 100);

        // We set the Layout Manager to null so we can manually place
        // the Panels.
        totalGUI.setLayout(null);

        // Now we create a new panel, size it, shape it,color it red.
        // then add it to the bottom JPanel.
        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setLocation(10, 10);
        redPanel.setSize(n, n);
        totalGUI.add(redPanel);

        // JPanel bluePanel = new JPanel();
        // bluePanel.setBackground(Color.blue);
        // bluePanel.setLocation(220, 10);
        // bluePanel.setSize(50, 50);
        // totalGUI.add(bluePanel);

        // Finally we return the JPanel.
        totalGUI.setOpaque(true);
        return totalGUI;
    }

    private static void createAndShowGUI() {

        // JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] There's 3 JPanels in here! [=]");

        // Create and set up the content pane.
        Testing demo = new Testing();
        frame.setContentPane(demo.createContentPane());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290, 200);
        frame.setVisible(true);
    }

    private static void createAndShowGUI(int n) {

        // JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("[=] There's 3 JPanels in here! [=]");

        // Create and set up the content pane.
        Testing demo = new Testing();
        frame.setContentPane(demo.createContentPane(n));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290, 200);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread:
        // creating and showing this application's GUI.
        if (args.length != 0) {
            int n = Integer.parseInt(args[0]);
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI(n);
                }
            });
        } else {
            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    createAndShowGUI();
                }
            });
        }

    }
}