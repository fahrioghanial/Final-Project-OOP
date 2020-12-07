package ui;

import java.awt.Container;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Avatar avatarUser;
    private Avatar[] avatarDriver = new Avatar[5];
    private int map;
    private JSpinner x;
    private JSpinner y;
    private JLabel info;
    private JLabel historyLabel;
    private DrawingBoard drawingBoard;
    private MenuPanel menuPanel;

    public UserInterface(Avatar avatarUser, Avatar[] avatarDriver, int map) {
        this.avatarUser = avatarUser;
        this.avatarDriver = avatarDriver;
        this.map = map;
    }

    @Override
    public void run() {
        frame = new JFrame("Go-Ride App");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        drawingBoard = new DrawingBoard(avatarUser, avatarDriver, map);
        frame.add(drawingBoard);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        menuPanel = new MenuPanel(x, y, info, historyLabel, drawingBoard, map);
        container.add(menuPanel.combinePanelFinal(), BorderLayout.EAST);
    }

    public JFrame getFrame() {
        return frame;
    }
}