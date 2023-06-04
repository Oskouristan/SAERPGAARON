package modele;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;

public class AlgorithmeLV1 {
    ArrayList <Integer> queteRealise;
    Integer experience;
    Integer[] coordonneeIa;
    Integer tempsPris;

    ArrayList <Integer> quetesAFairePourFinir;
    public AlgorithmeLV1(){
        tempsPris = 0;
        experience = 0;
        queteRealise = new ArrayList<>();
        coordonneeIa = new Integer[2];
        coordonneeIa[0] = 0;
        coordonneeIa[1] = 0;


        quetesAFairePourFinir = new ArrayList<>();

        File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
        Scenario scenario = LectureFichierTexte.lecture(planningFile);
        System.out.println(scenario);
    }

    public Boolean premierePartieEstRealisable(int[] tableau) {
        return (tableau[0] == 0 && tableau[1] == 0)
                ||
                (queteRealise.contains(tableau[0]) || queteRealise.contains(tableau[1]));
    }

    public Boolean secondePartieEstRealisable(int[] tableau) {
        return
                (tableau[2] == 0 && tableau[3] == 0)
                ||
                (queteRealise.contains(tableau[2]) || queteRealise.contains(tableau[3]));
    }
    /**
     * Cette fonction permet de savoir si une quête est réalisable en fonction des quêtes parcouru par l'IA
     * pour cela elle prend un @param quete de type Quete et @return un booléen (true si la quete est faisable false sinon)
     */
    public boolean queteEstRealisable(Quete quete){
        if( !queteRealise.contains(quete.numero)){
            int[] liste = quete.listePrecondition;
            return premierePartieEstRealisable(liste) && secondePartieEstRealisable(liste);
        }
        return false;
    }

    /**
     * cette fonction prend en
     * @param quete de type Quete
     * et calcule le temps qu'il faut à l'ia pour
     * se rendre à la quête et retourne
     *le resultat de ce calcul sous forme d'entier
     */
    public int temps_necessaire_se_rendre_vers_la_quete(Quete quete){
        int[] queteCoordonnee = quete.coordonnee;
        int Xpas = abs(coordonneeIa[0] - queteCoordonnee[0]);
        int Ypas = abs(coordonneeIa[1] - queteCoordonnee[1]);
        return Xpas+Ypas;
    }

    /**
     * met les champs de l'algorithme à jour quand une quête est faite
     * cette fonction ne retourne rien et prend en paramètre un objet Quete
     */
    public void quete_a_ete_realise(Quete quete){
        queteRealise.add(quete.numero);
        experience = experience + quete.experience;

        tempsPris = tempsPris + temps_necessaire_se_rendre_vers_la_quete(quete) + quete.duree;

        coordonneeIa[0] = quete.coordonnee[0];
        coordonneeIa[1] = quete.coordonnee[1];

    }

    public ArrayList<Quete> ensemblesQuetesFaisables(ArrayList <Quete> provQuetes){
        ArrayList<Quete> quetesFaisables = new ArrayList<>();
        for(Quete i : provQuetes){
            if((!queteRealise.contains(i.numero)) && (queteEstRealisable(i)) ){
                quetesFaisables.add(i);
            }
        }
        return quetesFaisables;
    }

    public boolean ilResteDesQuetes(ArrayList <Quete> provQuetes){
        for (Quete i : provQuetes)
            if(!queteRealise.contains(i.numero))
                return true;
        return false;
        }

    public void quetesRecherchePourX2 (Quete quete,ArrayList <Quete> provQuetes){
        if (!quetesAFairePourFinir.contains(quete.numero)){
            quetesAFairePourFinir.add(quete.numero);
            if (quete.aDesConditions()){
                if(quete.nbDeConditionsMinimum() ==1 ){
                    for (int i : quete.listePrecondition){
                        if (i!= 0){
                            for (Quete j : provQuetes){
                                if (j.numero == i ){
                                    quetesRecherchePourX2(j,provQuetes);
                                    return;
                                }
                            }
                        }
                    }
                }
                if(quete.nbDeConditionsMinimum() ==2){
                    int indexPremiereCondition = quete.listePrecondition[0];
                    int indexDeuxiemeCondition = quete.listePrecondition[2];
                    for (Quete j : provQuetes){
                        if (j.numero == indexPremiereCondition ){
                            quetesRecherchePourX2(j,provQuetes);


                        }
                        if (j.numero == indexDeuxiemeCondition ){
                            quetesRecherchePourX2(j,provQuetes);

                        }
                    }
                }
            }
        }
    }


    /**
     * Cette fonction renvoie la quête la plus intéréssante à faire en prenant en compte le temps et l'expérience qu'elle apporte
     * Donner une solution efficace optimale en termes de durée. Ce genre de solution correspond à un speedrun
     */

    public void decisionExhaustive(ArrayList <Quete> provQuetes){
        while (ilResteDesQuetes(provQuetes)) {
            for (Quete quete : provQuetes){
                if (queteEstRealisable(quete)){
                    quete_a_ete_realise(quete);
                }
            }
        }
    }

    /**
     * Cette fonction decisionExhaustivesEtGloutonne prend en paramètre un objet de type
     * ArrayList contenant des objets quetes (appelé provQuetes)
     * Tant que la fonction ilResteDesQuetes est vrai on crée un ensemble des quêtes faisables
     * à partir de la liste provQuetes puis on prend la première quete qu'il y a dans cet ensemble des quetes faisables
     * et on la compare avec les quetes restantes de la liste des quetesFaisables pour voir laquelle a la
     * distance_pour_se_rendre+ durée la plus courte puis cette quete est réalisé.
     */
    public void decisionExhaustivesEtGloutonne (ArrayList <Quete> provQuetes) {
        while (ilResteDesQuetes(provQuetes)) {
            ArrayList<Quete> quetesFaisables = ensemblesQuetesFaisables(provQuetes);
            Quete queteParDefaut = quetesFaisables.get(0);

            for (Quete i : quetesFaisables) {
                if ((queteParDefaut.duree + temps_necessaire_se_rendre_vers_la_quete(queteParDefaut)) > (i.duree + temps_necessaire_se_rendre_vers_la_quete(i)))
                    queteParDefaut = i;
            }
            quete_a_ete_realise(queteParDefaut);
            //return queteParDefaut.numero;
        }
    }

    /**
     * l'objectif de cette méthode est de finir la quête 0 le plus vite
     * @param provQuetes
     */
    public void decisionGloutonne(ArrayList <Quete> provQuetes){
        for (Quete i: provQuetes){
            if (i.numero == 0){
                quetesRecherchePourX2(i,provQuetes);
            }
        }
        while (!queteRealise.contains(0)){
            for (int x : quetesAFairePourFinir){
                for (Quete y  : provQuetes) {
                    if (y.numero == x){
                        if (queteEstRealisable(y)){
                            quete_a_ete_realise(y);}
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "AlgorithmeLV1{" +
                "queteRealise=" + queteRealise +
                ", experience=" + experience +
                ", coordonneeIa=" + Arrays.toString(coordonneeIa) +
                ", tempsPris=" + tempsPris +
                ", quetesAFairePourFinir=" + quetesAFairePourFinir +
                '}';
    }
}
