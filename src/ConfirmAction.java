import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import java.util.Arrays;

public class ConfirmAction implements ActionListener {
    private JSpinner x;
    private JSpinner y;
    private DrawingBoard drawingBoard;
    private JLabel destination;
    private int harga;
    private JPanel panel;
    private JButton proses;

    public ConfirmAction(JSpinner x, JSpinner y, JLabel destination, DrawingBoard drawingBoard, JPanel panel,
            JButton proses) {
        this.x = x;
        this.y = y;
        this.drawingBoard = drawingBoard;
        this.destination = destination;
        this.panel = panel;
        this.proses = proses;
    }

    public void driverTerdekat() {
        Double[] jarak = new Double[5];
        Double[] jarakTerkecil = new Double[5];
        for (int i = 0; i < 5; i++) {
            // rumus mencari jarak antara 2 titik
            jarak[i] = Math.sqrt(Math
                    .pow((this.drawingBoard.getAvatarDriver()[i].getX() - this.drawingBoard.getAvatarUser().getX()), 2)
                    + Math.pow(
                            (this.drawingBoard.getAvatarDriver()[i].getY() - this.drawingBoard.getAvatarUser().getY()),
                            2));
            this.drawingBoard.getAvatarDriver()[i].setJarak(jarak[i]);
            jarakTerkecil[i] = jarak[i];
        }
        Arrays.sort(jarakTerkecil);
        int index;
        for (index = 0; index < 5; index++) {
            if (jarakTerkecil[0] == jarak[index]) {
                break;
            }
        }
        this.drawingBoard.setDriverTerdekat(this.drawingBoard.getAvatarDriver()[index]);
    }

    public void hitungHarga(int xUser, int yUser, int xTujuan, int yTujuan) {
        // Convert ke koordinat JPanel sesuai rumus skala yang sudah kami tentukan
        int xUserConvert = this.drawingBoard.getAvatarUser().getX();
        int yUserConvert = this.drawingBoard.getAvatarUser().getY();
        int xTujuanConvert = 23 + (xTujuan - 1) * 18;
        int yTujuanConvert = 23 + (this.drawingBoard.getMapSize() - yTujuan) * 18;
        if (xUser < xTujuan) {
            if (yUser < yTujuan) {
                int counter = 0;
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert + 18;
                    counter++;
                    while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                        yUserConvert = yUserConvert - 18;
                        counter++;
                    }
                }
                harga = 100 * counter;
            } else if (yUser > yTujuan) {
                int counter = 0;
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert + 18;
                    counter++;
                    while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                        yUserConvert = yUserConvert + 18;
                        counter++;
                    }
                }
                harga = 100 * counter;
            } else {
                int counter = 0;
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert + 18;
                    counter++;
                }
                harga = 100 * counter;
            }
        } else if (xUser > xTujuan) {
            if (yUser < yTujuan) {
                int counter = 0;
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert - 18;
                    counter++;
                    while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                        yUserConvert = yUserConvert - 18;
                        counter++;
                    }
                }
                harga = 100 * counter;
            } else if (yUser > yTujuan) {
                int counter = 0;
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert - 18;
                    counter++;
                    while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                        yUserConvert = yUserConvert + 18;
                        counter++;
                    }
                }
                harga = 100 * counter;
            } else {
                int counter = 0;
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert - 18;
                    counter++;
                }
                harga = 100 * counter;
            }
        } else {
            if (yUser < yTujuan) {
                int counter = 0;
                while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                    yUserConvert = yUserConvert - 18;
                    counter++;
                }
                harga = 100 * counter;
            } else if (yUser > yTujuan) {
                int counter = 0;
                while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                    yUserConvert = yUserConvert + 18;
                    counter++;
                }
                harga = 100 * counter;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        driverTerdekat();
        int xUser = (this.drawingBoard.getAvatarUser().getX() - 5) / 18;
        int yUser = this.drawingBoard.getMapSize() - ((this.drawingBoard.getAvatarUser().getY() - 23) / 18);
        int xTujuan = Integer.valueOf(x.getValue().toString());
        int yTujuan = Integer.valueOf(y.getValue().toString());
        hitungHarga(xUser, yUser, xTujuan, yTujuan);
        this.drawingBoard.setTujuanX(xTujuan);
        this.drawingBoard.setTujuanY(yTujuan);
        this.drawingBoard.confirmKoordinat();
        String info = "<html><ul><li>Koordinat Tujuan (x,y) : (" + x.getValue().toString() + ","
                + y.getValue().toString() + ")</li><li>Driver Terdekat : "
                + this.drawingBoard.getDriverTerdekat().getName() + "</li><li>Harga : " + String.valueOf(this.harga)
                + " (Harga per titik : 100) </li></ul></html>";
        this.destination.setText(info);
        this.panel.add(proses);
    }
}