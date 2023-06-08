package modele;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AlgorithmeLV1Test {
    @Test
    void testDecisionExhaustive(){
        File planningFile = new File("ressources"+File.separator+"scenario_0.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        algorithmeLV1.decisionExhaustive();
        assertEquals(16,algorithmeLV1.experience);

    }
    @Test
    void testGetIndexOfQuete0() {
        {
            File planningFile = new File("ressources" + File.separator + "scenario_1.txt");
            AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
            assertEquals(5, algorithmeLV1.getIndexOfQuete0());
        }

        {
            File planningFile1 = new File("ressources" + File.separator + "scenario_10.txt");
            AlgorithmeLV1 algorithmeLV1bis = new AlgorithmeLV1(planningFile1);
            System.out.println(algorithmeLV1bis.getIndexOfQuete0());
            assertEquals(18, algorithmeLV1bis.getIndexOfQuete0());
        }


    }

        @Test
    void testQueteEstRealisable() {
        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        List<Quete> ListeDesQuetes = algorithmeLV1.listeQuetes;
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
        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        List<Quete> ListeDesQuetes = algorithmeLV1.listeQuetes;

        assertEquals(4, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(0)));
        assertEquals(7, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(1)));
        assertEquals(1, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(2)));
        assertEquals(4, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(3)));
        assertEquals(4, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(4)));
        assertEquals(5, algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(5)));
    }

    @Test
    void testEnsemblesQuetesFaisables() {
        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);

        ArrayList<Quete> quetesFaisables = new ArrayList<>();
        for (Quete i : algorithmeLV1.getListeQuetes())
            if ((i.numero == 1) || (i.numero == 4))
                quetesFaisables.add(i);
        assertEquals(quetesFaisables, algorithmeLV1.ensemblesQuetesFaisables(algorithmeLV1.getListeQuetes()));

        File planningFile1 = new File("ressources"+File.separator+"scenario_0.txt");
        AlgorithmeLV1 algorithmeLV1bis = new AlgorithmeLV1(planningFile1);

        ArrayList<Quete> quetesFaisablesbis = new ArrayList<>();
        for (Quete i : algorithmeLV1bis.getListeQuetes())
            if ((i.numero == 1))
                quetesFaisablesbis.add(i);
        assertEquals(quetesFaisablesbis, algorithmeLV1bis.ensemblesQuetesFaisables(algorithmeLV1bis.getListeQuetes()));


    }

    @Test
    void testQuete_a_ete_realise() {
        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        algorithmeLV1.quete_a_ete_realise(algorithmeLV1.getListeQuetes().get(3));

        //Test pour la quete numéro 1
        assertEquals(3, algorithmeLV1.coordonneeIa.get(0));
        assertEquals(1, algorithmeLV1.coordonneeIa.get(1));
        assertEquals(2, algorithmeLV1.experience);
        assertEquals(54, algorithmeLV1.tempsPris);
        ArrayList <Integer> quetesFaites = new ArrayList <Integer>();
        quetesFaites.add(1);
        assertEquals( quetesFaites, algorithmeLV1.queteRealise);

        algorithmeLV1.quete_a_ete_realise(algorithmeLV1.getListeQuetes().get(4));
        assertEquals(4, algorithmeLV1.coordonneeIa.get(0));
        assertEquals(0, algorithmeLV1.coordonneeIa.get(1));
        assertEquals(4, algorithmeLV1.experience);
        assertEquals(156, algorithmeLV1.tempsPris);
        quetesFaites.add(4);
        assertEquals( quetesFaites, algorithmeLV1.queteRealise);
    }
    @Test
    void testQuetesRecherchePourX2(){
        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        algorithmeLV1.quetesRecherchePourX2(algorithmeLV1.getListeQuetes().get(5),algorithmeLV1.getListeQuetes());
        ArrayList <Integer> quetesAFaire = new ArrayList<>();
        quetesAFaire.add(0);
        quetesAFaire.add(3);
        quetesAFaire.add(1);
        quetesAFaire.add(4);
        assertEquals(quetesAFaire,algorithmeLV1.quetesAFairePourFinir);
    }

    @Test
    void testIlResteDesQuetes(){
        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        // test quand aucune quete n'est faite
        assertTrue(algorithmeLV1.ilResteDesQuetes(algorithmeLV1.getListeQuetes()));

        algorithmeLV1.quete_a_ete_realise(algorithmeLV1.getListeQuetes().get(0));
        algorithmeLV1.quete_a_ete_realise(algorithmeLV1.getListeQuetes().get(1));
        algorithmeLV1.quete_a_ete_realise(algorithmeLV1.getListeQuetes().get(2));
        algorithmeLV1.quete_a_ete_realise(algorithmeLV1.getListeQuetes().get(3));
        algorithmeLV1.quete_a_ete_realise(algorithmeLV1.getListeQuetes().get(4));
        algorithmeLV1.quete_a_ete_realise(algorithmeLV1.getListeQuetes().get(5));
        // test une fois toutes les quetes ajouté au quetes_réalisés
        assertFalse(algorithmeLV1.ilResteDesQuetes(algorithmeLV1.getListeQuetes()));
    }
    @Test
    void testDecisionEfficaceGlouton(){
        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        algorithmeLV1.decisionEfficaceGlouton();

        ArrayList <Integer>quetesFaisables = new ArrayList<>();
        quetesFaisables.add(4);
        quetesFaisables.add(1);
        quetesFaisables.add(2);
        quetesFaisables.add(3);
        quetesFaisables.add(0);

        assertEquals(quetesFaisables, algorithmeLV1.queteRealise);
    }

    void testDecisionEfficaceEnFonctionDesQuetes() {
        File planningFile = new File("ressources" + File.separator + "scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        algorithmeLV1.decisionEfficaceGlouton();

        ArrayList<Integer> quetesFaisables = new ArrayList<>();
        quetesFaisables.add(4);
        quetesFaisables.add(1);
        quetesFaisables.add(2);
        quetesFaisables.add(3);
        quetesFaisables.add(0);

        assertEquals(quetesFaisables, algorithmeLV1.queteRealise);
    }


    }
