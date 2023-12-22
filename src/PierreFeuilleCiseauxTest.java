import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PierreFeuilleCiseauxTest {

    @Test
    public void Verifie_que_la_methode_choixAleatoire_renvoie_une_des_trois_valeurs_attendues() {
        String choix = PierreFeuilleCiseaux.choixAleatoire();
        assertTrue(choix.equals("pierre") || choix.equals("feuille") || choix.equals("ciseaux"));
    }

    @Test
    public void test_de_cas_egalite() {
        // Test de cas d'égalité
        assertEquals("égalité", PierreFeuilleCiseaux.determinerGagnant("pierre", "pierre"));

        // Tests de cas où joueur 1 gagne
        assertEquals("joueur 1", PierreFeuilleCiseaux.determinerGagnant("pierre", "ciseaux"));
        assertEquals("joueur 1", PierreFeuilleCiseaux.determinerGagnant("feuille", "pierre"));
        assertEquals("joueur 1", PierreFeuilleCiseaux.determinerGagnant("ciseaux", "feuille"));

        // Tests de cas où joueur 2 gagne
        assertEquals("joueur 2", PierreFeuilleCiseaux.determinerGagnant("ciseaux", "pierre"));
        assertEquals("joueur 2", PierreFeuilleCiseaux.determinerGagnant("pierre", "feuille"));
        assertEquals("joueur 2", PierreFeuilleCiseaux.determinerGagnant("feuille", "ciseaux"));

        // Test de cas d'erreur
        assertEquals("Erreur", PierreFeuilleCiseaux.determinerGagnant("inconnu", "feuille"));
    }
}