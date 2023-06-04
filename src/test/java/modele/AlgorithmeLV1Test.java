package modele;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class AlgorithmeLV1Test {

    @Test
    void testQueteEstRealisable() {
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();
        //assert algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(0));
        if ((algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(1)) == false)) throw new AssertionError();
        System.out.println("quete 1 = "+ algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(0)));
        System.out.println("quete 2 = "+ algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(1)));
    }

    @Test
    void getListePrecondition() {
    }

    @Test
    void aDesConditions() {
    }

    @Test
    void nbDeConditionsMinimum() {
    }
}
