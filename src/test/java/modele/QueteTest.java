package modele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


class QueteTest {

    @Test
    void extractionValeur() {
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();

    }


    @Test
    void aDesConditions() {
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();
        assertTrue(ListeDesQuetes.get(0).aDesConditions(), "quete numéro 2 a des conditions");
        assertTrue(ListeDesQuetes.get(1).aDesConditions(), "quete numéro 5 a des conditions");
        assertTrue(ListeDesQuetes.get(2).aDesConditions(), "quete numéro 3 a des conditions");
        assertFalse(ListeDesQuetes.get(3).aDesConditions(), "quete numéro 1 n'a pas de conditions");
        assertFalse(ListeDesQuetes.get(4).aDesConditions(), "quete numéro 4 n'a pas de conditions");
        assertTrue(ListeDesQuetes.get(5).aDesConditions(), "quete numéro 0 a des conditions");



    }

    @Test
    void nbDeConditionsMinimum() {
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();
        assertEquals(1,ListeDesQuetes.get(0).nbDeConditionsMinimum(), "quete numéro 2 a 1 condition minimum");
        assertEquals(2,ListeDesQuetes.get(1).nbDeConditionsMinimum(), "quete numéro 5 a 2 conditions minimums");
        assertEquals(2,ListeDesQuetes.get(2).nbDeConditionsMinimum(), "quete numéro 3 a 2 conditions minimums");
        assertEquals(0,ListeDesQuetes.get(3).nbDeConditionsMinimum(), "quete numéro 1 n'a pas de conditions");
        assertEquals(0,ListeDesQuetes.get(4).nbDeConditionsMinimum(), "quete numéro 4 n'a pas de conditions");
        assertEquals(2,ListeDesQuetes.get(5).nbDeConditionsMinimum(), "quete numéro 0 a des conditions");


    }
}