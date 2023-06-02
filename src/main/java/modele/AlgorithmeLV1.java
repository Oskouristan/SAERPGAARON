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

        File planningFile = new File("ressources"+File.separator+"scenario_0.txt");
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
        if(queteRealise.contains(quete.numero) == false){
            int[] liste = quete.getListePrecondition();
            if(premierePartieEstRealisable(liste) && secondePartieEstRealisable(liste))
                return true;
            return false;
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
        //System.out.println("temps pour arriver à la quête = " +temps_necessaire_se_rendre_vers_la_quete(quete));

        coordonneeIa[0] = quete.coordonnee[0];
        coordonneeIa[1] = quete.coordonnee[1];

        //System.out.println("duree quete = " + quete.duree);
        //System.out.println("tempsPris = " + tempsPris);
    }

    public ArrayList<Quete> ensemblesQuetesFaisables(ArrayList <Quete> provQuetes){
        ArrayList<Quete> quetesFaisables = new ArrayList<>();
        for(Quete i : provQuetes){
            if((queteRealise.contains(i.numero)== false) && (queteEstRealisable(i)==true) ){
                quetesFaisables.add(i);
            }
        }
        return quetesFaisables;
    }

    public boolean ilResteDesQuetes(ArrayList <Quete> provQuetes){
        for (Quete i : provQuetes)
            if(queteRealise.contains(i.numero)== false )
                return true;
        return false;
        }



    public void quetesRecherchePourX (Quete quete,ArrayList <Quete> provQuetes){
        System.out.println(quetesAFairePourFinir);
        if (quetesAFairePourFinir.contains(quete.numero) == false){
            quetesAFairePourFinir.add(quete.numero);
            if (quete.aDesConditions()){
                // parcours recherche première condition
                // recherche deuxième


                for (int i : quete.listePrecondition){
                    if (i!= 0){
                        for (Quete j : provQuetes){
                            if (j.numero == i ){
                                quetesRecherchePourX(j,provQuetes);
                                return;
                            }
                        }
                        //quetesRecherchePourX();
                    }
                }
            }
        }
    }
    public void quetesRecherchePourX2 (Quete quete,ArrayList <Quete> provQuetes){
        if (quetesAFairePourFinir.contains(quete.numero) == false){
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
                            //quetesRecherchePourX();
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

    public void decisionPlusProcheEtRapide(ArrayList <Quete> provQuetes) {
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
     * finir la quête 0 le plus vite
     * @param provQuetes
     */
    public void decisionGloutonne(ArrayList <Quete> provQuetes){

        for (Quete i: provQuetes){
            if (i.numero == 0){

                quetesRecherchePourX2(i,provQuetes);
                System.out.println(quetesAFairePourFinir);
            }
        }

        while (queteRealise.contains(0) == false){
            for (int x : quetesAFairePourFinir){
                for (Quete y  : provQuetes) {
                    if (y.numero == x){
                        if (queteEstRealisable(y)){
                            System.out.println(y.numero);
                            //quetesAFairePourFinir.remove(quetesAFairePourFinir.get(x));
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
