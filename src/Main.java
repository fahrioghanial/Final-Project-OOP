import javax.swing.SwingUtilities;
import ui.*;

public class Main {
    public static void main(String[] args) {
        int[] koordinatRandom;
        if (args.length != 0) {
            int argsInt = Integer.parseInt(args[0]);
            if (argsInt < 3) {
                System.out.println("Ukuran map tidak boleh kurang dari tiga");
                System.exit(0);
            }
            koordinatRandom = new int[argsInt];
        } else {
            koordinatRandom = new int[20];
        }

        koordinatRandom[0] = 23;
        for (int i = 1; i < koordinatRandom.length; i++) {
            koordinatRandom[i] = koordinatRandom[i - 1] + 18;
        }

        int[] indexKoordinatRandom = new int[12];
        for (int i = 0; i < 12; i++) {
            int randomInt = (int) (Math.random() * ((koordinatRandom.length - 1) - 0 + 1) + 0);
            indexKoordinatRandom[i] = randomInt;
        }

        Avatar avatarUser = new Avatar(koordinatRandom[indexKoordinatRandom[0]],
                koordinatRandom[indexKoordinatRandom[1]]);
        Avatar[] avatarDriver = new Avatar[5];
        avatarDriver[0] = new Avatar(koordinatRandom[indexKoordinatRandom[2]],
                koordinatRandom[indexKoordinatRandom[3]]);
        avatarDriver[1] = new Avatar(koordinatRandom[indexKoordinatRandom[4]],
                koordinatRandom[indexKoordinatRandom[5]]);
        avatarDriver[2] = new Avatar(koordinatRandom[indexKoordinatRandom[6]],
                koordinatRandom[indexKoordinatRandom[7]]);
        avatarDriver[3] = new Avatar(koordinatRandom[indexKoordinatRandom[8]],
                koordinatRandom[indexKoordinatRandom[9]]);
        avatarDriver[4] = new Avatar(koordinatRandom[indexKoordinatRandom[10]],
                koordinatRandom[indexKoordinatRandom[11]]);

        Avatar[] avatarGab = new Avatar[6];
        avatarGab[0] = avatarUser;
        avatarGab[1] = avatarDriver[0];
        avatarGab[2] = avatarDriver[1];
        avatarGab[3] = avatarDriver[2];
        avatarGab[4] = avatarDriver[3];
        avatarGab[5] = avatarDriver[4];

        // Agar saat spawn tidak ada yang tumpang tindih
        for (int i = 0; i < avatarGab.length; i++) {
            for (int j = 0; j < avatarGab.length; j++) {
                if (j != i) {
                    if (avatarGab[i].getX() == avatarGab[j].getX() && avatarGab[i].getY() == avatarGab[j].getY()) {
                        int randomInt = (int) (Math.random() * ((koordinatRandom.length - 1) - 0 + 1) + 0);
                        int randomInt2 = (int) (Math.random() * ((koordinatRandom.length - 1) - 0 + 1) + 0);
                        avatarGab[i] = new Avatar(koordinatRandom[randomInt], koordinatRandom[randomInt2]);
                        j = -1;
                    }
                }
            }
        }

        // Update koordinat baru yang unik
        avatarUser = avatarGab[0];
        avatarDriver[0] = avatarGab[1];
        avatarDriver[1] = avatarGab[2];
        avatarDriver[2] = avatarGab[3];
        avatarDriver[3] = avatarGab[4];
        avatarDriver[4] = avatarGab[5];

        avatarDriver[0].setName("Mamang Hijau");
        avatarDriver[1].setName("Mamang Magenta");
        avatarDriver[2].setName("Mamang Pink");
        avatarDriver[3].setName("Mamang Kuning");
        avatarDriver[4].setName("Mamang Merah");

        if (args.length != 0) {
            int argsInt = Integer.parseInt(args[0]);
            UserInterface ui = new UserInterface(avatarUser, avatarDriver, argsInt);
            SwingUtilities.invokeLater(ui);
        } else {
            UserInterface ui = new UserInterface(avatarUser, avatarDriver, 20);
            SwingUtilities.invokeLater(ui);
        }

    }
}