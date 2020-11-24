import java.awt.Color;
import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;

import javafx.scene.effect.ColorAdjust;

public class DrawingBoard extends JPanel {

    private Avatar avatarUser;
    private Avatar[] avatarDriver = new Avatar[5];
    private int map;

    public DrawingBoard(Avatar avatarUser, Avatar[] avatarDriver, int map) {
        this.setBackground(Color.GRAY);
        this.avatarUser = avatarUser;
        this.avatarDriver = avatarDriver;
        this.map = map;

    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        int x = 23;
        int y = 23;
        int counterTitik = 0;
        for (int i = 1; i <= this.map; i++) {
            graphics.setColor(Color.WHITE);
            graphics.drawOval(x, y, 5, 5);
            if (i == this.map) {
                x = x + 18;
                y = 23;
                i = 0;
            } else {
                y = y + 18;
            }
            counterTitik++;
            if (counterTitik == this.map * this.map) {
                break;
            }
        }
        // graphics.drawRect(10, 10, map, map);

        for (int i = 0; i < avatarDriver.length; i++) {
            if (i == 0) {
                graphics.setColor(Color.GREEN);
            } else if (i == 1) {
                graphics.setColor(Color.BLUE);
            } else if (i == 2) {
                graphics.setColor(Color.PINK);
            } else if (i == 3) {
                graphics.setColor(Color.YELLOW);
            } else {
                graphics.setColor(Color.RED);
            }
            avatarDriver[i].draw(graphics);
        }

        graphics.setColor(Color.BLACK);
        avatarUser.draw(graphics);

        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(0, 0, 10, 410);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(390, 0, 10, 410);

        // graphics.setColor(Color.BLACK);
        // graphics.fillRect(0, 0, 400, 10);
        // graphics.setColor(Color.BLACK);
        // graphics.fillRect(0, 400, 400, 10);

        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(30, 30, 20, 270);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(70, 30, 20, 270);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(110, 30, 20, 270);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(150, 30, 20, 270);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(190, 30, 20, 270);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(230, 30, 20, 270);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(270, 30, 20, 270);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(310, 30, 20, 270);
        // graphics.setColor(Color.GREEN);
        // graphics.fillRect(350, 30, 20, 270);
        // graphics.setColor(Color.BLACK);
        // graphics.fillRect(30, 320, 340, 20);
        // graphics.setColor(Color.BLACK);
        // graphics.fillRect(30, 360, 340, 20);
    }
}