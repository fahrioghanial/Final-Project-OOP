import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HistoryAction implements ActionListener {
    private DrawingBoard drawingBoard;
    private JLabel destination;
    private JPanel panel;
    private JButton closeHistory;

    public HistoryAction(DrawingBoard drawingBoard, JLabel destination, JPanel panel, JButton closeHistory) {
        this.drawingBoard = drawingBoard;
        this.destination = destination;
        this.panel = panel;
        this.closeHistory = closeHistory;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String[] history = new String[this.drawingBoard.getCounterPerjalanan()];
        for (int i = 0; i < history.length; i++) {
            history[i] = this.drawingBoard.getHistory().get(i).toString();
        }
        String historyShow = "<html>Riwayat Perjalanan: <br>";
        for (int i = 0; i < history.length; i++) {
            historyShow = historyShow + history[i] + "<br>";
        }
        historyShow = historyShow + "</html>";
        this.destination.setText(historyShow);
        this.panel.add(closeHistory);
    }
}