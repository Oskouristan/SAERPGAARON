package modele;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {

    public static void main (String [] args){
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1();
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();
        //algorithmeLV1.quete_a_ete_realise(ListeDesQuetes.get(4));


        /**
        System.out.println("quete 3 = "+ algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(2)));
        System.out.println("quete 3 = "+ (ListeDesQuetes.get(2)).nbDeConditionsMinimum());

        System.out.println("quete 4 = "+ algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(3)));
        System.out.println("quete 5 = "+ algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(4)));
        */
        /**
        System.out.println(algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(0)));
        System.out.println(algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(1)));
        System.out.println(algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(2)));
        System.out.println(algorithmeLV1.temps_necessaire_se_rendre_vers_la_quete(ListeDesQuetes.get(4)));
        */
        /**
        algorithmeLV1.quete_a_ete_realise(ListeDesQuetes.get(0));
        algorithmeLV1.quete_a_ete_realise(ListeDesQuetes.get(1));
        algorithmeLV1.quete_a_ete_realise(ListeDesQuetes.get(2));
        */
        //System.out.println("quete 1 = "+ algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(0)));
        //System.out.println("quete 2 = "+ algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(1)));
        //System.out.println("quete 3 = "+ algorithmeLV1.queteEstRealisable(ListeDesQuetes.get(2)));
        //ArrayList <Quete> quetesRestantes =  algorithmeLV1.ensemblesQuetesFaisables(ListeDesQuetes);
        //System.out.println("ensemble des quêtes faisables" + Arrays.toString(new ArrayList[]{quetesRestantes}));

        /**
        algorithmeLV1.decisionPlusProcheEtRapide(ListeDesQuetes);

        System.out.println(algorithmeLV1.experience);
        System.out.println(algorithmeLV1.tempsPris);
        System.out.println(Arrays.toString(algorithmeLV1.coordonneeIa));
        System.out.println(algorithmeLV1.queteRealise);
        */
        //algorithmeLV1.quetesRecherchePourX(ListeDesQuetes.get(4),ListeDesQuetes);
        //System.out.println((algorithmeLV1.quetesAFairePourFinir).toString());
        //algorithmeLV1.quetesRecherchePourX2(ListeDesQuetes.get(18),ListeDesQuetes);
        //System.out.println(ListeDesQuetes.get(18).nbDeConditionsMinimum());
        //algorithmeLV1.decisionGloutonne(ListeDesQuetes);
        //algorithmeLV1.decisionExhaustivesEtGloutonne(ListeDesQuetes);
        algorithmeLV1.quetesRecherchePourX2(ListeDesQuetes.get(5),ListeDesQuetes);

        //algorithmeLV1.decisionExhaustive(ListeDesQuetes);
        System.out.println(algorithmeLV1.toString());

    }
}
