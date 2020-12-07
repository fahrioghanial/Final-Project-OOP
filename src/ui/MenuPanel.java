package ui;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SpinnerNumberModel;
import javax.swing.BoxLayout;
import action.*;

public class MenuPanel extends JPanel {
    private JSpinner x;
    private JSpinner y;
    private JLabel info;
    private JLabel historyLabel;
    private DrawingBoard drawingBoard;
    private int map;

    public MenuPanel(JSpinner x, JSpinner y, JLabel info, JLabel historyLabel, DrawingBoard drawingBoard, int map) {
        this.x = x;
        this.y = y;
        this.info = info;
        this.historyLabel = historyLabel;
        this.drawingBoard = drawingBoard;
        this.map = map;
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        x = new JSpinner(new SpinnerNumberModel(1, 1, map, 1));
        y = new JSpinner(new SpinnerNumberModel(1, 1, map, 1));
        panel.add(new JLabel("Tujuan x: "));
        panel.add(x);
        panel.add(new JLabel("Tujuan y: "));
        panel.add(y);
        return panel;
    }

    private JPanel createPanel2() {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        info = new JLabel();
        JLabel userInfo = new JLabel("<html><br><h3>User : Avatar Putih</h3></html>");
        JButton buttonConfirm = new JButton("Konfirmasi Tujuan");
        JButton buttonHistory = new JButton("History");
        JButton buttonProses = new JButton("Proses Layanan");
        JButton buttonOrderAgain = new JButton("Pesan Lagi");
        JButton buttonCloseHistory = new JButton("Tutup History");
        panel.add(userInfo);
        panel.add(buttonConfirm);
        panel.add(buttonHistory);
        panel.add(info);
        buttonConfirm.addActionListener(new ConfirmAction(x, y, info, drawingBoard, panel, buttonProses));
        buttonProses.addActionListener(new ProceedAction(drawingBoard, info, panel, buttonOrderAgain, buttonProses));
        buttonOrderAgain.addActionListener(new OrderAgainAction(x, y, info, panel, buttonOrderAgain));
        buttonHistory.addActionListener(new HistoryAction(drawingBoard, historyLabel, panel, buttonCloseHistory));
        buttonCloseHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                historyLabel.setText("");
                panel.remove(buttonCloseHistory);
            }
        });
        return panel;
    }

    private JPanel combinePanel() {
        JPanel panel = new JPanel();
        BoxLayout layout = new BoxLayout(panel, BoxLayout.Y_AXIS);
        panel.setLayout(layout);
        panel.add(createPanel());
        panel.add(createPanel2());
        return panel;
    }

    private JPanel combinePanelNorth() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(combinePanel(), BorderLayout.NORTH);
        return panel;
    }

    public JPanel combinePanelFinal() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        historyLabel = new JLabel();
        panel.add(combinePanelNorth());
        panel.add(historyLabel);
        return panel;
    }
}