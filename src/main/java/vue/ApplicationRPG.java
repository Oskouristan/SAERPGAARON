package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;

public class ApplicationRPG extends Application {
    @Override
    public void start(Stage stage){
        /**
         * On instancie au départ la classe HBoxRoot qui sera contenu dans la scene
         */
        HBoxRoot root = new HBoxRoot();
        Scene scene = new Scene(root,800,460);
        //File [] fichiersCss = new File("css").listFiles();
        //for (File fichier : fichiersCss) {
            //scene.getStylesheets().add(fichier.toURI().toString());}
        stage.setScene(scene);
        stage.setTitle("Application RPG");
        stage.show();
    }
    public static void main(String[] args) {
        Application.launch();
    }
}