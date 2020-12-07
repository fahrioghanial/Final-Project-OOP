package ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.util.ArrayList;

public class DrawingBoard extends JPanel {

    private Avatar avatarUser;
    private Avatar[] avatarDriver = new Avatar[5];
    private Avatar driverDekat;
    private ArrayList<String> history = new ArrayList<String>();
    private int counterPerjalanan = 0;
    private int mapSize;
    private int xTujuan;
    private int yTujuan;
    private String sesi;
    private Timer timer;
    private DrawingBoard drawingBoard = this;
    private Map map;
    private Pathways pathways;

    public DrawingBoard(Avatar avatarUser, Avatar[] avatarDriver, int mapSize) {
        this.setBackground(Color.DARK_GRAY);
        this.avatarUser = avatarUser;
        this.avatarDriver = avatarDriver;
        this.mapSize = mapSize;
        this.sesi = "kosong";
        this.timer = new Timer(1, new Animation(drawingBoard));
        this.timer.start();
    }

    public void confirmKoordinat() {
        this.sesi = "confirm";
        repaint();
    }

    public void proceed() {
        this.sesi = "proceed";
        this.counterPerjalanan++;
        int xUser = (avatarUser.getX() - 5) / 18;
        int yUser = this.getMapSize() - ((avatarUser.getY() - 23) / 18);
        history.add("Perjalanan ke-" + String.valueOf(counterPerjalanan) + "<br>Dari: (" + String.valueOf(xUser) + ","
                + String.valueOf(yUser) + ")<br>Ke: (" + String.valueOf(xTujuan) + "," + String.valueOf(yTujuan)
                + ")<br>");
        repaint();
    }

    public void setTujuanX(int x) {
        this.xTujuan = x;
    }

    public void setTujuanY(int y) {
        this.yTujuan = y;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
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

    public int getTujuanX() {
        return this.xTujuan;
    }

    public int getTujuanY() {
        return this.yTujuan;
    }

    public int getMapSize() {
        return this.mapSize;
    }

    public String getSesi() {
        return this.sesi;
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
        if (sesi == "kosong" || sesi == "proceed") {
            // Gambar peta, driver, user
            map = new Map(graphics, drawingBoard);
            map.drawMap();
        } else if (sesi == "confirm") {
            // Gambar peta, driver, user
            map = new Map(graphics, drawingBoard);
            map.drawMap();
            // Gambar jalur pada drawing board
            pathways = new Pathways(drawingBoard, graphics);
            pathways.drawPathways();
        }
    }
}
