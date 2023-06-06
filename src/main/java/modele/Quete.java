package modele;


import java.util.Arrays;
import java.util.Scanner;

public class Quete {
    int numero;
    int[] coordonnee;
    String position;
    int[] listePrecondition;
    int duree;
    int experience;
    String intitule;
    Scanner scanner; // fdfsdfsd

    @Override
    public String toString() {
        return "Quete{" +
                "numero=" + numero +
                ", coordonnee=" + Arrays.toString(coordonnee) +
                ", position='" + position + '\'' +
                ", listePrecondition=" + Arrays.toString(listePrecondition) +
                ", duree=" + duree +
                ", experience=" + experience +
                ", intitule='" + intitule + '\'' +
                ", scanner=" + scanner +
                '}';
    }

    /**
    public static Comparator<Quete> byShortestTime = new Comparator<Quete>() {
        @Override
        public int compare(Quete o1, Quete o2) {
            return 0;
        }
    };*/



    public Quete(String ligne){
        scanner = new Scanner(ligne).useDelimiter("\\|");
        while (scanner.hasNext()){
            this.numero = scanner.nextInt();
            //this.position = scanner.next();
            this.coordonnee = extractionValeur (2);
            this.listePrecondition = extractionValeur(4);
            this.experience = scanner.nextInt();
            this.duree = scanner.nextInt();
            this.intitule = scanner.next();
        }
    }

    public int[] extractionValeur(int longueur){
        String preconditions = scanner.next();
        int[] listePrecond = new int[longueur];
        preconditions = preconditions.replace("(","");
        preconditions = preconditions.replace(")","");
        preconditions = preconditions.replace(" ","");
        Scanner scanPrecondition = new Scanner(preconditions).useDelimiter(",");
        Integer i= 0;
        //Scanner scanner  = new Scanner();
        while (scanPrecondition.hasNext()){
            String extrait = scanPrecondition.next();
            if (! extrait.equals(""))
                listePrecond[i] = Integer.parseInt(extrait);
            i++;}
        //System.out.println(Arrays.toString(listePrecond));
        return listePrecond;
    }

    /**
     * la méthode aDesConditions renvoie un booléen
     * true si l'objet this a des conditions
     * false sinon
     */
    public boolean aDesConditions(){
        for (int i : listePrecondition){
            if (i != 0){
                return true;
            }
        }
        return false;
    }

    /**
     * Cette fonction renvoie un entier qui représente le nombre de conditions minimum de this
     * Les seules possibilités sont soit 0,1 ou 2.
     */
    public int nbDeConditionsMinimum(){
        if ((this.listePrecondition[0] ==0) && (this.listePrecondition[1]==0) && (this.listePrecondition[2]==0) && (this.listePrecondition[3]==0))
            return 0;
        if (((this.listePrecondition[0] !=0) || (this.listePrecondition[1]!=0)) && ((this.listePrecondition[2]!=0) || (this.listePrecondition[3]!=0)))
            return 2;
        else
            return 1;
    }

}
