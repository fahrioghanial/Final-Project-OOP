import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ProceedAction implements ActionListener {
    private DrawingBoard drawingBoard;
    private Avatar avatarUser;
    private Avatar[] avatarDriver = new Avatar[5];
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
        this.panel.remove(proses);
        this.panel.add(orderAgain);
        int xTujuanConvert = 23 + (this.drawingBoard.getTujuanX() - 1) * 18;
        int yTujuanConvert = 23 + (this.drawingBoard.getMapSize() - this.drawingBoard.getTujuanY()) * 18;
        for (int i = 0; i < 5; i++) {
            this.avatarDriver[i] = this.drawingBoard.getAvatarDriver()[i];
        }
        int index;
        for (index = 0; index < 5; index++) {
            if (this.drawingBoard.getDriverTerdekat().getJarak() == this.drawingBoard.getAvatarDriver()[index]
                    .getJarak()) {
                break;
            }
        }
        int[] koordinatRandom = new int[this.drawingBoard.getMapSize()];
        koordinatRandom[0] = 23;
        for (int i = 1; i < koordinatRandom.length; i++) {
            koordinatRandom[i] = koordinatRandom[i - 1] + 18;
        }

        int[] indexKoordinatRandom = new int[2];
        for (int i = 0; i < 2; i++) {
            int randomInt = (int) (Math.random() * ((koordinatRandom.length - 1) - 0 + 1) + 0);
            indexKoordinatRandom[i] = randomInt;
        }
        this.avatarDriver[index].setX(koordinatRandom[indexKoordinatRandom[0]]);
        this.avatarDriver[index].setY(koordinatRandom[indexKoordinatRandom[1]]);
        this.drawingBoard.setAvatarDriver(avatarDriver);
        this.avatarUser = new Avatar(xTujuanConvert, yTujuanConvert);
        this.drawingBoard.setAvatarUser(avatarUser);
        this.drawingBoard.proceed();
        this.info.setText(this.info.getText() + "\n");
        panel.remove(proses);
        panel.add(orderAgain);
    }
}