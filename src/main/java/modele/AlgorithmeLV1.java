package modele;

import vue.HBoxRoot;

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
    ArrayList <Quete> listeQuetes;

    public AlgorithmeLV1(File planningFile){
        tempsPris = 0;
        experience = 0;
        queteRealise = new ArrayList<>();
        coordonneeIa = new Integer[2];
        coordonneeIa[0] = 0;
        coordonneeIa[1] = 0;

        quetesAFairePourFinir = new ArrayList<>();

        Scenario scenario = LectureFichierTexte.lecture(planningFile);
        listeQuetes =  scenario.getProvQuetes();
        System.out.println(scenario);
    }

    public int getIndexOfQuete0(){
        for (Quete i: listeQuetes){
            if (i.numero==0)
                return listeQuetes.indexOf(i);
        }
        return 0;
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
        if(!queteRealise.contains(quete.numero)){
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

    public void decisionExhaustive(){
        while ((ilResteDesQuetes(listeQuetes)) && ((listeQuetes.size()-1) <queteRealise.size()) ){
            for (Quete quete : listeQuetes){
                if ((queteEstRealisable(quete)) && (quete.numero!=0)){
                    quete_a_ete_realise(quete);
                }
            }
        }
        for (Quete quete : listeQuetes){
            if (quete.numero ==0){
                quete_a_ete_realise(quete);
                return;}
        }
    }

    /**
     * Cette fonction decisionExhaustivesEtGloutonne utilise un champ de cette classe (listeQuetes) qui est un objet de type
     * ArrayList contenant des objets quetes
     * Tant que la fonction ilResteDesQuetes est vrai on crée un ensemble des quêtes faisables
     * à partir de la liste provQuetes puis on prend la première quete qu'il y a dans cet ensemble des quetes faisables
     * et on la compare avec les quetes restantes de la liste des quetesFaisables pour voir laquelle a la
     * distance_pour_se_rendre+ durée la plus courte puis cette quete est réalisé.
     */
    public void decisionExhaustivesEtGloutonne () {
        while (ilResteDesQuetes(listeQuetes)) {

            //HBoxRoot.getvBoxAffichageSolutions().updateTab(this);

            ArrayList<Quete> quetesFaisables = ensemblesQuetesFaisables(listeQuetes);
            Quete queteParDefaut = quetesFaisables.get(0);

            for (Quete i : quetesFaisables) {
                if ((queteParDefaut.duree + temps_necessaire_se_rendre_vers_la_quete(queteParDefaut)) > (i.duree + temps_necessaire_se_rendre_vers_la_quete(i)))
                    queteParDefaut = i;
            }

            quete_a_ete_realise(queteParDefaut);

        }
        //HBoxRoot.getvBoxAffichageSolutions().updateTab(this);
    }
    /**
     * l'objectif de cette méthode est de finir la quête 0 le plus vite
     * pour cela elle utilise le champs listeQuetes qui est une liste d'objet Quete nommé provQuetes
     * que l'on va utiliser pour determiner les quetes à faire pour faire la quete
     * 0 de manière gloutonne et on les stocke le numéro de ces quetes dans le champ
     * queteAFairePourFinir de l'AlgotihmeLV1 puis tant que la quete 0 n'est pas faites
     * on scanne la liste d'entier contenant le numéro des quetes pour faire la quete 0
     * et on fait les quetes faisables des que possible.
     */
    public void decisionEfficace(){
        for (Quete i: listeQuetes){
            if (i.numero == 0){
                quetesRecherchePourX2(i,listeQuetes);
            }
        }
        while (!queteRealise.contains(0)){
            for (int x : quetesAFairePourFinir){
                for (Quete y  : listeQuetes) {
                    if (y.numero == x){
                        if (queteEstRealisable(y)){
                            quete_a_ete_realise(y);}
                    }
                }
            }
        }
    }

    /**
     * Cette algorithme réalise toutes les quetes les plus proches realisable tant que la quete 0 n'est pas réalisable
     * puis l'a réalise dès que possible.
     */
    public void decisionEfficaceGlouton(){
        while (!queteEstRealisable(listeQuetes.get(getIndexOfQuete0()))) {
            Quete queteParDefaut = ensemblesQuetesFaisables(listeQuetes).get(0);
            for (Quete i : ensemblesQuetesFaisables(listeQuetes)){
                if (temps_necessaire_se_rendre_vers_la_quete(i)<= temps_necessaire_se_rendre_vers_la_quete(queteParDefaut))
                    queteParDefaut = i;
            }
            quete_a_ete_realise(queteParDefaut);
        }
        quete_a_ete_realise((listeQuetes.get(getIndexOfQuete0())));
    }

    /**
     * Solution efficace qui fait le nombre minimum de quetes et à chaque fois la quete la plus proche *
     * si elle est faisable et qu'elle est nécessaire pour réaliser la quête 0.
     */

    public void decisionEfficaceEnFonctionDesQuetes(){
        while (!queteEstRealisable(listeQuetes.get(getIndexOfQuete0()))) {
            quetesRecherchePourX2((listeQuetes.get(getIndexOfQuete0())),listeQuetes);
            ArrayList <Quete> listeQuetesFaisable = new ArrayList<>();
            for(Quete i : listeQuetes){
                if(!queteRealise.contains(i.numero) && quetesAFairePourFinir.contains(i.numero)){
                    listeQuetesFaisable.add(i);
                }
            }
            Quete queteParDefaut = (ensemblesQuetesFaisables(listeQuetesFaisable)).get(0);

            for (Quete i : ensemblesQuetesFaisables(listeQuetesFaisable)){
                if (temps_necessaire_se_rendre_vers_la_quete(i)<= temps_necessaire_se_rendre_vers_la_quete(queteParDefaut))
                    queteParDefaut = i;
            }
            quete_a_ete_realise(queteParDefaut);

        }
        quete_a_ete_realise((listeQuetes.get(getIndexOfQuete0())));
    }

    /**
     * Ma méthode coup de coeur personnellement
     * elle retourne tous les champs de la classe algo sous forme de string
     */
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
