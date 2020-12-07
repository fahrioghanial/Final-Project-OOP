package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import ui.*;

public class ProceedAction implements ActionListener {
    private DrawingBoard drawingBoard;
    private JPanel panel;
    private JButton orderAgain;
    private JButton proses;
    private JLabel info;

    public ProceedAction(DrawingBoard drawingBoard, JLabel info, JPanel panel, JButton orderAgain, JButton proses) {
        this.drawingBoard = drawingBoard;
        this.panel = panel;
        this.orderAgain = orderAgain;
        this.proses = proses;
        this.info = info;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.drawingBoard.proceed();
        this.info.setText(this.info.getText() + "\n");
        this.panel.remove(proses);
        this.panel.add(orderAgain);
    }
}