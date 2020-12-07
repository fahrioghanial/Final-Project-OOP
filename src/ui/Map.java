package ui;

import java.awt.Color;
import java.awt.Graphics;

public class Map {
    private DrawingBoard drawingBoard;
    private Graphics graphics;
    private Avatar avatarUser;
    private Avatar[] avatarDriver = new Avatar[5];

    public Map(Graphics graphics, DrawingBoard drawingBoard) {
        this.graphics = graphics;
        this.drawingBoard = drawingBoard;
    }

    public void drawMap() {
        // titik pojok kiri atas terletak pada koordinat 23,23 pada JPanel
        int x = 23;
        int y = 23;
        int counterTitik = 0;
        graphics.setColor(Color.ORANGE);
        graphics.drawLine(11, drawingBoard.getMapSize() * 5 + drawingBoard.getMapSize() * 13 + 22, 11, 11);
        graphics.drawString("0", 11, drawingBoard.getMapSize() * 5 + drawingBoard.getMapSize() * 13 + 35);
        graphics.drawString("X", drawingBoard.getMapSize() * 5 + drawingBoard.getMapSize() * 13 + 30,
                drawingBoard.getMapSize() * 5 + drawingBoard.getMapSize() * 13 + 25);
        graphics.drawString("Y", 11, 9);
        graphics.drawLine(11, drawingBoard.getMapSize() * 5 + drawingBoard.getMapSize() * 13 + 22,
                drawingBoard.getMapSize() * 5 + drawingBoard.getMapSize() * 13 + 22,
                drawingBoard.getMapSize() * 5 + drawingBoard.getMapSize() * 13 + 22);

        // Gambar titik map sesuai ukuran yang diminta
        // Gambar titik dimulai dari pojok kiri atas (kolom pertama) dan lanjut hingga
        // kolom pertama terisi lalu mulai lagi ke kolom berikutnya
        for (int i = 1; i <= drawingBoard.getMapSize(); i++) {
            graphics.setColor(Color.WHITE);
            graphics.drawOval(x, y, 5, 5);
            if (i == drawingBoard.getMapSize()) {
                x = x + 18;
                y = 23;
                i = 0;
            } else {
                y = y + 18;
            }
            counterTitik++;
            if (counterTitik == drawingBoard.getMapSize() * drawingBoard.getMapSize()) {
                break;
            }
        }

        for (int i = 0; i < avatarDriver.length; i++) {
            avatarDriver[i] = drawingBoard.getAvatarDriver()[i];
        }

        // Meng-spawn 5 avatar driver
        for (int i = 0; i < drawingBoard.getAvatarDriver().length; i++) {
            if (i == 0) {
                graphics.setColor(Color.GREEN);
            } else if (i == 1) {
                graphics.setColor(Color.MAGENTA);
            } else if (i == 2) {
                graphics.setColor(Color.PINK);
            } else if (i == 3) {
                graphics.setColor(Color.YELLOW);
            } else {
                graphics.setColor(Color.RED);
            }
            avatarDriver[i].draw(graphics);
        }
        drawingBoard.setAvatarDriver(avatarDriver);
        // Meng-spawn avatar user
        graphics.setColor(Color.WHITE);
        avatarUser = drawingBoard.getAvatarUser();
        avatarUser.draw(graphics);
        drawingBoard.setAvatarUser(avatarUser);
    }
}