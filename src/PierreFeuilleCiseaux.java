import java.util.Random;

public class PierreFeuilleCiseaux {

    public static void main(String[] args) {
        jouerPartie();
    }

    public static String choixAleatoire() {
        String[] choix = {"pierre", "feuille", "ciseaux"};
        Random random = new Random();
        return choix[random.nextInt(choix.length)];
    }

    public static String determinerGagnant(String joueur1, String joueur2) {
        if (joueur1.equals(joueur2)) return "égalité";
        switch (joueur1) {
            case "pierre":
                return (joueur2.equals("ciseaux")) ? "joueur 1" : "joueur 2";
            case "feuille":
                return (joueur2.equals("pierre")) ? "joueur 1" : "joueur 2";
            case "ciseaux":
                return (joueur2.equals("feuille")) ? "joueur 1" : "joueur 2";
            default:
                return "Erreur";
        }
    }

    public static void jouerPartie() {
        int scoreJoueur1 = 0, scoreJoueur2 = 0;

        while (true) {
            for (int tour = 1; tour <= 3; tour++) {
                String choixJoueur1 = choixAleatoire();
                String choixJoueur2 = choixAleatoire();
                String gagnant = determinerGagnant(choixJoueur1, choixJoueur2);

                System.out.printf("Tour %d: Joueur 1 (%s) vs Joueur 2 (%s) - Gagnant: %s%n", tour, choixJoueur1, choixJoueur2, gagnant);

                if (gagnant.equals("joueur 1")) scoreJoueur1++;
                if (gagnant.equals("joueur 2")) scoreJoueur2++;

                if (scoreJoueur1 == 2 || scoreJoueur2 == 2) break;
            }

            System.out.printf("Résultat Final: Joueur 1 (%d) - Joueur 2 (%d)%n", scoreJoueur1, scoreJoueur2);

            if (scoreJoueur1 == scoreJoueur2) {
                System.out.println("La partie est égalité. Rejouez !");
                scoreJoueur1 = 0;
                scoreJoueur2 = 0;
            } else {
                break;
            }
        }
    }
}