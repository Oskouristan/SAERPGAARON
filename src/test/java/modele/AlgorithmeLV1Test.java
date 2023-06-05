package modele;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmeLV1Test {

    @Test
    void testQueteEstRealisable() {
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();
        //assert algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(0));


        assertEquals(false, algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(0)));
        assertEquals(false, algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(1)));
        assertEquals(false, algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(2)));
        assertEquals(true, algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(3)));
        assertEquals(true, algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(4)));
        assertEquals(false, algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(5)));
    }
    @Test
    void testTemps_necessaire_se_rendre_vers_la_quete() {
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();

        assertEquals(4, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(0)));
        assertEquals(7, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(1)));
        assertEquals(1, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(2)));
        assertEquals(4, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(3)));
        assertEquals(4, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(4)));
        assertEquals(5, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(5)));
    }

    @Test
    void testEnsemblesQuetesFaisables() {
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();

        ArrayList<Quete> quetesFaisables = new ArrayList<>();
        for (Quete i : Scenario.getProvQuetes())
            if ((i.numero == 1) || (i.numero == 4))
                quetesFaisables.add(i);
        assertEquals(quetesFaisables, algorithmeLV1.ensemblesQuetesFaisables(Scenario.getProvQuetes()));

    }

    @Test
    void testQuete_a_ete_realise() {
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        algorithmeLV1.quete_a_ete_realise(Scenario.getProvQuetes().get(3));

        //Test pour la quete numéro 1
        assertEquals(3, algorithmeLV1.coordonneeIa[0]);
        assertEquals(1, algorithmeLV1.coordonneeIa[1]);
        assertEquals(2, algorithmeLV1.experience);
        assertEquals(54, algorithmeLV1.tempsPris);
        ArrayList <Integer> quetesFaites = new ArrayList <Integer>();
        quetesFaites.add(1);
        assertEquals( quetesFaites, algorithmeLV1.queteRealise);

        algorithmeLV1.quete_a_ete_realise(Scenario.getProvQuetes().get(4));
        assertEquals(4, algorithmeLV1.coordonneeIa[0]);
        assertEquals(0, algorithmeLV1.coordonneeIa[1]);
        assertEquals(4, algorithmeLV1.experience);
        assertEquals(156, algorithmeLV1.tempsPris);
        quetesFaites.add(4);
        assertEquals( quetesFaites, algorithmeLV1.queteRealise);
    }
    @Test
    void testQuetesRecherchePourX2(){
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        algorithmeLV1.quetesRecherchePourX2(Scenario.getProvQuetes().get(5),Scenario.getProvQuetes());
        ArrayList <Integer> quetesAFaire = new ArrayList<>();
        quetesAFaire.add(0);
        quetesAFaire.add(3);
        quetesAFaire.add(1);
        quetesAFaire.add(4);
        assertEquals(quetesAFaire,algorithmeLV1.quetesAFairePourFinir);

        System.out.println("Work work work");
    }

    @Test
    void testIlResteDesQuetes(){
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        assertTrue(algorithmeLV1.ilResteDesQuetes(Scenario.getProvQuetes()));

        algorithmeLV1.quete_a_ete_realise(Scenario.getProvQuetes().get(0));
        algorithmeLV1.quete_a_ete_realise(Scenario.getProvQuetes().get(1));
        algorithmeLV1.quete_a_ete_realise(Scenario.getProvQuetes().get(2));
        algorithmeLV1.quete_a_ete_realise(Scenario.getProvQuetes().get(3));
        algorithmeLV1.quete_a_ete_realise(Scenario.getProvQuetes().get(4));
        algorithmeLV1.quete_a_ete_realise(Scenario.getProvQuetes().get(5));

        assertFalse(algorithmeLV1.ilResteDesQuetes(Scenario.getProvQuetes()));

        System.out.println("I'm good yeah i'm feelin all right");
    }

}
