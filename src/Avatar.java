import java.awt.Graphics;

public class Avatar {

    private int x;
    private int y;
    private Double jarak;
    private String name;

    public Avatar(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setJarak(Double jarak) {
        this.jarak = jarak;
    }

    public Double getJarak() {
        return jarak;
    }

    public void move(int movingX, int movingY) {
        this.x += movingX;
        this.y += movingY;
    }

    public void draw(Graphics graphics) {
        graphics.fillRect(x, y, 10, 10);
    }
}