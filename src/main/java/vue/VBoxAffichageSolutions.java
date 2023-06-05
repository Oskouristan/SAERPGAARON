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

        TableColumn<AlgorithmeLV1, Quete> dateColumn1 = new TableColumn<>("Test1");
        TableColumn <AlgorithmeLV1, Quete> dateColumn2 = new TableColumn<>("Test2");
        TableColumn <AlgorithmeLV1, Quete> dateColumn3 = new TableColumn<>("Test3");
        dateColumn1.setCellValueFactory(new PropertyValueFactory<>("minitest1"));
        dateColumn2.setCellValueFactory(new PropertyValueFactory<>("minitest2"));
        dateColumn3.setCellValueFactory(new PropertyValueFactory<>("minitest3"));
        tableDesResultats.getColumns().add(dateColumn1);
        tableDesResultats.getColumns().add(dateColumn2);
        tableDesResultats.getColumns().add(dateColumn3);

        this.getChildren().add(tableDesResultats);


    }
    public void updateTab(AlgorithmeLV1 algorithmeLV1){
        tableDesResultats.getItems().clear();
        if (algorithmeLV1 == null) {return;}
        tableDesResultats.getItems().add(algorithmeLV1);

        System.out.println(tableDesResultats.getItems().toString());
    }


    }
