package action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ui.*;

public class Animation implements ActionListener {
    private DrawingBoard drawingBoard;

    public Animation(DrawingBoard drawingBoard) {
        this.drawingBoard = drawingBoard;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (drawingBoard.getSesi() == "proceed") {
            drawingBoard.repaint();
            int index;
            for (index = 0; index < drawingBoard.getAvatarDriver().length; index++) {
                if (drawingBoard.getDriverTerdekat().getJarak() == drawingBoard.getAvatarDriver()[index].getJarak()) {
                    break;
                }
            }

            // Mengkonvert koordinat kartesius ke koordinat JPanel sesuai rumus skala yang
            // sudah kami tentukan
            int xUserConvert = drawingBoard.getAvatarUser().getX();
            int yUserConvert = drawingBoard.getAvatarUser().getY();

            int xDriverConvert = drawingBoard.getAvatarDriver()[index].getX();
            int yDriverConvert = drawingBoard.getAvatarDriver()[index].getY();

            int xTujuanConvert = 23 + (drawingBoard.getTujuanX() - 1) * 18;
            int yTujuanConvert = 23 + (drawingBoard.getMapSize() - drawingBoard.getTujuanY()) * 18;

            // Animasi ketika driver menghampiri user
            if (drawingBoard.getAvatarUser().getX() != drawingBoard.getAvatarDriver()[index].getX()
                    || drawingBoard.getAvatarUser().getY() != drawingBoard.getAvatarDriver()[index].getY()) {
                if (xDriverConvert < xUserConvert) {
                    drawingBoard.getAvatarDriver()[index].move(2, 0);
                } else if (xDriverConvert > xUserConvert) {
                    drawingBoard.getAvatarDriver()[index].move(-2, 0);
                } else {
                    if (yDriverConvert > yUserConvert) {
                        drawingBoard.getAvatarDriver()[index].move(0, -2);
                    } else if (yDriverConvert < yUserConvert) {
                        drawingBoard.getAvatarDriver()[index].move(0, 2);
                    }
                }
            }

            // Animasi ketika user dan driver pergi ke tujuan
            else if (drawingBoard.getAvatarUser().getX() == drawingBoard.getAvatarDriver()[index].getX()
                    && drawingBoard.getAvatarUser().getY() == drawingBoard.getAvatarDriver()[index].getY()) {
                if (xUserConvert < xTujuanConvert) {
                    drawingBoard.getAvatarUser().move(2, 0);
                    drawingBoard.getAvatarDriver()[index].move(2, 0);
                } else if (xUserConvert > xTujuanConvert) {
                    drawingBoard.getAvatarUser().move(-2, 0);
                    drawingBoard.getAvatarDriver()[index].move(-2, 0);
                } else {
                    if (yUserConvert > yTujuanConvert) {
                        drawingBoard.getAvatarUser().move(0, -2);
                        drawingBoard.getAvatarDriver()[index].move(0, -2);
                    } else if (yUserConvert < yTujuanConvert) {
                        drawingBoard.getAvatarUser().move(0, 2);
                        drawingBoard.getAvatarDriver()[index].move(0, 2);
                    }
                }
            }

            // Driver yang telah mengantar user dipindahkan ke koordinat random
            if (drawingBoard.getAvatarUser().getX() == xTujuanConvert
                    && drawingBoard.getAvatarUser().getY() == yTujuanConvert) {
                int[] koordinatRandom = new int[drawingBoard.getMapSize()];
                koordinatRandom[0] = 23;
                for (int i = 1; i < koordinatRandom.length; i++) {
                    koordinatRandom[i] = koordinatRandom[i - 1] + 18;
                }

                int[] indexKoordinatRandom = new int[2];
                for (int i = 0; i < 2; i++) {
                    int randomInt = (int) (Math.random() * ((koordinatRandom.length - 1) - 0 + 1) + 0);
                    indexKoordinatRandom[i] = randomInt; 
                }
                drawingBoard.getAvatarDriver()[index].setX(koordinatRandom[indexKoordinatRandom[0]]);
                drawingBoard.getAvatarDriver()[index].setY(koordinatRandom[indexKoordinatRandom[1]]);
                drawingBoard.setSesi("kosong");
            }
        }
    }
}
