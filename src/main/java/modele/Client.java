package modele;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class Client {

    public static void main (String [] args){
        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        ArrayList<Quete> ListeDesQuetes = Scenario.getProvQuetes();
        //algorithmeLV1.quete_a_ete_realise(ListeDesQuetes.get(4));

        algorithmeLV1.quetesRecherchePourX2(ListeDesQuetes.get(5),ListeDesQuetes);

        //algorithmeLV1.decisionExhaustive(ListeDesQuetes);
        System.out.println(algorithmeLV1.toString());

    }
}
