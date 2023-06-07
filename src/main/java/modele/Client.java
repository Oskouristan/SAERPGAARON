package modele;

import java.io.File;
import java.util.ArrayList;

public class Client {

    public static void main (String [] args){
        File scenarioFile = new File("ressources"+File.separator+"scenario_10.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(scenarioFile);
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();
        //algorithmeLV1.quete_a_ete_realise(ListeDesQuetes.get(4));

        //algorithmeLV1.quetesRecherchePourX2(ListeDesQuetes.get(5),ListeDesQuetes);

        //algorithmeLV1.decisionExhaustive(ListeDesQuetes);
        //System.out.println(algorithmeLV1.toString());


        algorithmeLV1.decisionEfficaceGlouton();
        System.out.println(algorithmeLV1.toString());


        AlgorithmeLV1 algorithmeLV2 = new AlgorithmeLV1(scenarioFile);
        algorithmeLV2.decisionEfficaceEnFonctionDesQuetes();
        System.out.println(algorithmeLV2.toString());

        AlgorithmeLV1 algorithmeLV3 =new AlgorithmeLV1(scenarioFile);
        algorithmeLV3.decisionExhaustivesEtGloutonne();
        System.out.println(algorithmeLV3.toString());
    }
}
