package vue;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import modele.AlgorithmeLV1;
import modele.Quete;

import java.util.TreeSet;

public class VBoxAffichageSolutions extends VBox {
    TableView <AlgorithmeLV1> tableDesResultats;
    public VBoxAffichageSolutions (){
         tableDesResultats = new TableView<>();

         TableColumn<AlgorithmeLV1, Quete> queteRealise = new TableColumn<>("quêtes réalisés");
         TableColumn <AlgorithmeLV1, Quete> expTotale = new TableColumn<>("expérience totale");
         TableColumn <AlgorithmeLV1, Quete> coordonneeIa = new TableColumn<>("coordonnée IA");
         TableColumn <AlgorithmeLV1, Quete> tempsPris = new TableColumn<>("temps pris");

         queteRealise.setCellValueFactory(new PropertyValueFactory<>("minitest1"));
         expTotale.setCellValueFactory(new PropertyValueFactory<>("minitest2"));
         coordonneeIa.setCellValueFactory(new PropertyValueFactory<>("minitest3"));
         tempsPris.setCellValueFactory(new PropertyValueFactory<>("minitest3"));

         tableDesResultats.getColumns().add(queteRealise);
         tableDesResultats.getColumns().add(expTotale);
         tableDesResultats.getColumns().add(coordonneeIa);
         tableDesResultats.getColumns().add(tempsPris);

         this.getChildren().add(tableDesResultats);
    }
    public void updateTab(AlgorithmeLV1 algorithmeLV1){
        tableDesResultats.getItems().clear();
        if (algorithmeLV1 == null) {return;}
        tableDesResultats.getItems().add(algorithmeLV1);

        System.out.println(tableDesResultats.getItems().toString());
    }


    }
