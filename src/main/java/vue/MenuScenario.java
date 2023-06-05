package vue;

import javafx.event.ActionEvent;
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
            Label label = new Label("scenario_"+ index);
            Label labelEspace = new Label("  -->  ");

            this.add(label,1, i,2,1);
            this.add(labelEspace , 3,i,1,1);
            this.add(nouveauBouton,4, i ,5,1);
            nouveauBouton.setToggleGroup(scenario);


        }

        Button bouttonEnregistrer = new Button("Enregistrer");
        bouttonEnregistrer.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControleur());

        this.add(bouttonEnregistrer,5,10,5,1);

    }
}
