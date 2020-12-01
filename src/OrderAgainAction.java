import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JButton;

public class OrderAgainAction implements ActionListener {
    private JPanel panel;
    private JButton orderAgain;
    private JSpinner x;
    private JSpinner y;
    private JLabel info;

    public OrderAgainAction(JSpinner x, JSpinner y, JLabel info, JPanel panel, JButton orderAgain) {
        this.x = x;
        this.y = y;
        this.info = info;
        this.panel = panel;
        this.orderAgain = orderAgain;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        this.x.setValue(1);
        this.y.setValue(1);
        this.info.setText("");
        this.panel.remove(orderAgain);
    }
}