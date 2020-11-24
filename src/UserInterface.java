import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;

public class UserInterface implements Runnable {

    private JFrame frame;
    private Avatar avatarUser;
    private Avatar[] avatarDriver = new Avatar[5];
    private int map;

    public UserInterface(Avatar avatarUser, Avatar[] avatarDriver, int map) {
        this.avatarUser = avatarUser;
        this.avatarDriver = avatarDriver;
        this.map = map;
    }

    public UserInterface() {
    }

    @Override
    public void run() {
        frame = new JFrame("Go-Ride App");
        frame.setPreferredSize(new Dimension(600, 600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        DrawingBoard drawingBoard = new DrawingBoard(avatarUser, avatarDriver, map);

        // frame.add(new DrawingBoard(avatarUser, avatarDriver, map));
        JScrollPane scroll = new JScrollPane(drawingBoard);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        frame.add(scroll);
        createComponents(frame.getContentPane());
        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container) {
        // DrawingBoard drawingBoard = new DrawingBoard(avatarUser, avatarDriver, map);
        // container.add(drawingBoard);
        container.add(combinePanel(), BorderLayout.SOUTH);
        // JScrollPane scroll = new JScrollPane(drawingBoard);

        // scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));

        panel.add(new JButton("Konfirmasi Tujuan"));
        panel.add(new JButton("History"));
        return panel;
    }

    private JPanel createPanel2() {
        JPanel panel = new JPanel(new GridLayout(1, 4));

        panel.add(new JLabel("Tujuan x: "));
        panel.add(new JTextField());
        panel.add(new JLabel("Tujuan y: "));
        panel.add(new JTextField());
        return panel;
    }

    private JPanel combinePanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        panel.add(createPanel2());
        panel.add(createPanel());
        return panel;
    }

    public JFrame getFrame() {
        return frame;
    }
}