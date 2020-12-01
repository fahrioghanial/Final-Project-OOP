import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.util.ArrayList;

public class DrawingBoard extends JPanel {

    private Avatar avatarUser;
    private Avatar[] avatarDriver = new Avatar[5];
    private Avatar driverDekat;
    private ArrayList<String> history = new ArrayList<String>();
    private int counterPerjalanan = 0;
    private int xUserTemp;
    private int yUserTemp;
    private int mapSize;
    private int harga;
    private int xTujuan;
    private int yTujuan;
    private Boolean isConfirm;
    private Map map;
    private Pathways pathways;
    private DrawingBoard drawingBoard = this;

    public DrawingBoard(Avatar avatarUser, Avatar[] avatarDriver, int mapSize) {
        this.setBackground(Color.GRAY);
        this.avatarUser = avatarUser;
        this.avatarDriver = avatarDriver;
        this.mapSize = mapSize;
        this.isConfirm = false;
    }

    public void confirmKoordinat() {
        this.isConfirm = true;
        this.xUserTemp = (avatarUser.getX() - 5) / 18;
        this.yUserTemp = this.getMapSize() - ((avatarUser.getY() - 23) / 18);
        repaint();
    }

    public void proceed() {
        this.isConfirm = false;
        this.counterPerjalanan++;
        history.add("Perjalanan ke-" + String.valueOf(counterPerjalanan) + "<br>Dari: (" + String.valueOf(xUserTemp)
                + "," + String.valueOf(yUserTemp) + ")<br>Ke: (" + String.valueOf(xTujuan) + ","
                + String.valueOf(yTujuan) + ")<br>");
        repaint();
    }

    public void setTujuanX(int x) {
        this.xTujuan = x;
    }

    public void setTujuanY(int y) {
        this.yTujuan = y;
    }

    public int getTujuanX() {
        return this.xTujuan;
    }

    public int getTujuanY() {
        return this.yTujuan;
    }

    public int getMapSize() {
        return this.mapSize;
    }

    public int getHarga() {
        return this.harga;
    }

    public void setAvatarUser(Avatar avatarUser) {
        this.avatarUser = avatarUser;
    }

    public void setAvatarDriver(Avatar[] avatarDriver) {
        this.avatarDriver = avatarDriver;
    }

    public void setDriverTerdekat(Avatar driverDekat) {
        this.driverDekat = driverDekat;
    }

    public Avatar getAvatarUser() {
        return this.avatarUser;
    }

    public Avatar[] getAvatarDriver() {
        return this.avatarDriver;
    }

    public Avatar getDriverTerdekat() {
        return this.driverDekat;
    }

    public ArrayList<String> getHistory() {
        return this.history;
    }

    public int getCounterPerjalanan() {
        return this.counterPerjalanan;
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (!isConfirm) {
            // Gambar peta, driver, user
            map = new Map(graphics, drawingBoard);
            map.drawMap();
        } else {
            // Gambar peta, driver, user
            map = new Map(graphics, drawingBoard);
            map.drawMap();
            // Gambar jalur pada drawing board
            pathways = new Pathways(drawingBoard, graphics);
            pathways.drawPathways();
        }
    }
}
