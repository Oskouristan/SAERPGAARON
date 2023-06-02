package modele;

import java.util.Arrays;
import java.util.Comparator;
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

    @Override
    public String toString() {
        return "Quete{" +
                "numero=" + numero +
                ", coordonne='" + Arrays.toString(coordonnee) + '\'' +
                ", listePreconditions='" + Arrays.toString(listePrecondition) + '\'' +
                ", duree=" + duree +
                ", experience=" + experience +
                ", intitule='" + intitule + '\'' + '}';
    }
    public int[] getListePrecondition(){
        return this.listePrecondition;
    }
    public boolean aDesConditions(){
        for (int i : listePrecondition){
            if (i != 0){
                return true;
            }
        }
        return false;
    }
    public int nbDeConditionsMinimum(){
        if ((this.listePrecondition[0] ==0) && (this.listePrecondition[1]==0) && (this.listePrecondition[2]==0) && (this.listePrecondition[3]==0))
            return 0;
        if (((this.listePrecondition[0] !=0) || (this.listePrecondition[1]!=0)) && ((this.listePrecondition[2]==0) || (this.listePrecondition[3]==0)))
            return 2;
        else
            return 1;
    }

}
