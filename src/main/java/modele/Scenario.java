package modele;

import java.util.ArrayList;
import java.util.List;


public class Scenario {
    private List<Quete> provQuetes = new ArrayList<>();

    public Scenario() {
    }

    public void ajout(Quete quete) {
        provQuetes.add(quete);
    }

    public List<Quete> getProvQuetes() {
        return provQuetes;
    }

    public String toString() {
        return provQuetes.toString();
    }

}

