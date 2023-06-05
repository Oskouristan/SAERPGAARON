package vue;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MenuScenario extends GridPane {
    public MenuScenario(){
        this.setGridLinesVisible(false);
        this.setPadding(new Insets(40));
        this.setHgap(20);
        this.setVgap(20);


        ToggleGroup scenario = new ToggleGroup();


        for (int i =0 ;i<10;i++){
            RadioButton nouveauBouton = new RadioButton();
            Integer index = i+1;
            Label label = new Label("Scenario "+ index + " : " );
            this.add(label,1, i,2,1);
            this.add(nouveauBouton,3, i ,5,1);
            nouveauBouton.setToggleGroup(scenario);


        }

        Button bouttonEnregistrer = new Button("Enregistrer");
        this.add(bouttonEnregistrer,5,10,5,1);

    }
}
