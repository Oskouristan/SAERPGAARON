package vue;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.AlgorithmeLV1;
import modele.Quete;

import java.io.File;

public class VBoxAffichageSolutions extends VBox {
    TableView <AlgorithmeLV1> tableDesResultats;
    public VBoxAffichageSolutions (){

        tableDesResultats = new TableView<>();

        TableColumn<AlgorithmeLV1, Quete> queteRealise = new TableColumn<>("quêtes réalisés");
        TableColumn <AlgorithmeLV1, Quete> expTotale = new TableColumn<>("expérience totale");
        TableColumn <AlgorithmeLV1, Quete> coordonneeIa = new TableColumn<>("coordonnée IA");
        TableColumn <AlgorithmeLV1, Quete> tempsPris = new TableColumn<>("temps pris");
        TableColumn <AlgorithmeLV1, Quete> listeQuetes = new TableColumn<>("liste des quetes");

        queteRealise.setCellValueFactory(new PropertyValueFactory<>("queteRealise"));
        expTotale.setCellValueFactory(new PropertyValueFactory<>("experience"));
        coordonneeIa.setCellValueFactory(new PropertyValueFactory<>("coordonneeIa"));
        tempsPris.setCellValueFactory(new PropertyValueFactory<>("tempsPris"));
        listeQuetes.setCellValueFactory(new PropertyValueFactory<>("listeQuetes"));


        tableDesResultats.getColumns().add(queteRealise);
        tableDesResultats.getColumns().add(expTotale);
        tableDesResultats.getColumns().add(coordonneeIa);
        tableDesResultats.getColumns().add(tempsPris);
        tableDesResultats.getColumns().add(listeQuetes);

        this.getChildren().add(tableDesResultats);
        /**
        File planningFile = new File("ressources"+File.separator+"scenario_0.txt");
        AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
        algorithmeLV1.decisionExhaustivesEtGloutonne();

        */
    }
    public void effacerSolutionPrecedente(){

            System.out.println("effacerSolutionPrecedente");
        tableDesResultats.getItems().clear();
    }
    public void updateTab(AlgorithmeLV1 algorithmeLV1){
        tableDesResultats.getItems().clear();
        if (algorithmeLV1 == null) {return;}
        tableDesResultats.getItems().add(algorithmeLV1);
    }


    }
