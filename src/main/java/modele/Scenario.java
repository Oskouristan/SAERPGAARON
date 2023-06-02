package modele;
import java.util.ArrayList;
public class Scenario {
    private static ArrayList <Quete> provQuetes = new ArrayList<>();
    public Scenario (){
    }
    public void ajout(Quete quete){
        provQuetes.add(quete);
    }
    public static ArrayList<Quete> getProvQuetes(){return provQuetes;}

    public String toString(){
        return provQuetes.toString();
    }

}

