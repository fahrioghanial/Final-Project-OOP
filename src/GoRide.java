import javax.swing.SwingUtilities;

public class GoRide {
    public static void main(String[] args) {
        int[] koordinatRandom;
        if (args.length != 0) {
            int argsInt = Integer.parseInt(args[0]);
            if (argsInt < 3) {
                System.out.println("Ukuran map tidak boleh kurang dari tiga");
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
        Avatar aD1 = new Avatar(koordinatRandom[indexKoordinatRandom[2]], koordinatRandom[indexKoordinatRandom[3]]);
        Avatar aD2 = new Avatar(koordinatRandom[indexKoordinatRandom[4]], koordinatRandom[indexKoordinatRandom[5]]);
        Avatar aD3 = new Avatar(koordinatRandom[indexKoordinatRandom[6]], koordinatRandom[indexKoordinatRandom[7]]);
        Avatar aD4 = new Avatar(koordinatRandom[indexKoordinatRandom[8]], koordinatRandom[indexKoordinatRandom[9]]);
        Avatar aD5 = new Avatar(koordinatRandom[indexKoordinatRandom[10]], koordinatRandom[indexKoordinatRandom[11]]);

        avatarDriver[0] = aD1;
        avatarDriver[1] = aD2;
        avatarDriver[2] = aD3;
        avatarDriver[3] = aD4;
        avatarDriver[4] = aD5;

        Avatar[] avatarGab = new Avatar[6];
        avatarGab[0] = avatarUser;
        avatarGab[1] = avatarDriver[0];
        avatarGab[2] = avatarDriver[1];
        avatarGab[3] = avatarDriver[2];
        avatarGab[4] = avatarDriver[3];
        avatarGab[5] = avatarDriver[4];

        for (int i = 0; i < avatarGab.length; i++) {
            for (int j = 0; j < avatarGab.length; j++) {
                if (j != i) {
                    if (avatarGab[i].getX() == avatarGab[j].getX() && avatarGab[i].getY() == avatarGab[j].getY()) {
                        int randomInt = (int) (Math.random() * ((koordinatRandom.length - 1) - 0 + 1) + 0);
                        int randomInt2 = (int) (Math.random() * ((koordinatRandom.length - 1) - 0 + 1) + 0);
                        avatarGab[i] = new Avatar(koordinatRandom[randomInt], koordinatRandom[randomInt2]);
                        j = 0;
                    }
                }
            }
        }

        avatarUser = avatarGab[0];
        avatarDriver[0] = avatarGab[1];
        avatarDriver[1] = avatarGab[2];
        avatarDriver[2] = avatarGab[3];
        avatarDriver[3] = avatarGab[4];
        avatarDriver[4] = avatarGab[5];

        if (args.length != 0) {
            int n = Integer.parseInt(args[0]);
            if (n < 3) {
                System.out.println("Ukuran map tidak boleh kurang dari tiga");
            } else {
                UserInterface ui = new UserInterface(avatarUser, avatarDriver, n);
                SwingUtilities.invokeLater(ui);
            }
        } else {
            UserInterface ui = new UserInterface(avatarUser, avatarDriver, 20);
            SwingUtilities.invokeLater(ui);
        }

    }
}