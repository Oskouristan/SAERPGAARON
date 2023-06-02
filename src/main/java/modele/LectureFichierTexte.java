package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LectureFichierTexte {
    public static Scenario lecture (File fichier) {
        Scenario scenario = new Scenario();
        Scanner scanner = null;
        try {
            scanner = new Scanner(fichier);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);
                scenario.ajout(new Quete(line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return scenario;

    }
}
