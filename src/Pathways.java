import java.awt.Color;
import java.awt.Graphics;

public class Pathways {
    private DrawingBoard drawingBoard;
    private Graphics graphics;

    public Pathways(DrawingBoard drawingBoard, Graphics graphics) {
        this.drawingBoard = drawingBoard;
        this.graphics = graphics;
    }

    public void drawPathways() {
        int xUser = (drawingBoard.getAvatarUser().getX() - 5) / 18;
        int yUser = drawingBoard.getMapSize() - ((drawingBoard.getAvatarUser().getY() - 23) / 18);
        // Convert ke koordinat JPanel sesuai rumus skala yang sudah kami tentukan
        int xUserConvert = drawingBoard.getAvatarUser().getX();
        int yUserConvert = drawingBoard.getAvatarUser().getY();
        // history.add("Perjalanan ke ")
        int xTujuanConvert = 23 + (drawingBoard.getTujuanX() - 1) * 18;
        int yTujuanConvert = 23 + (drawingBoard.getMapSize() - drawingBoard.getTujuanY()) * 18;
        if (xUser < drawingBoard.getTujuanX()) {
            if (yUser < drawingBoard.getTujuanY()) {
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert + 18;
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                    while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                        yUserConvert = yUserConvert - 18;
                        graphics.setColor(Color.WHITE);
                        graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                    }
                }
            } else if (yUser > drawingBoard.getTujuanY()) {
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert + 18;
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                    while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                        yUserConvert = yUserConvert + 18;
                        graphics.setColor(Color.WHITE);
                        graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                    }
                }
            } else {
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert + 18;
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                }
            }
        } else if (xUser > drawingBoard.getTujuanX()) {
            if (yUser < drawingBoard.getTujuanY()) {
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert - 18;
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                    while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                        yUserConvert = yUserConvert - 18;
                        graphics.setColor(Color.WHITE);
                        graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                    }
                }
            } else if (yUser > drawingBoard.getTujuanY()) {
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert - 18;
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                    while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                        yUserConvert = yUserConvert + 18;
                        graphics.setColor(Color.WHITE);
                        graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                    }
                }
            } else {
                while (xUserConvert != xTujuanConvert) {
                    xUserConvert = xUserConvert - 18;
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                }
            }
        } else {
            if (yUser < drawingBoard.getTujuanY()) {
                while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                    yUserConvert = yUserConvert - 18;
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                }
            } else if (yUser > drawingBoard.getTujuanY()) {
                while (yUserConvert != yTujuanConvert && xUserConvert == xTujuanConvert) {
                    yUserConvert = yUserConvert + 18;
                    graphics.setColor(Color.WHITE);
                    graphics.fillOval(xUserConvert, yUserConvert, 6, 6);
                }
            }
        }
    }
}