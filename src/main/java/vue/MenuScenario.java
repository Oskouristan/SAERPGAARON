package vue;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class MenuScenario extends GridPane {
    String nomScenario;


    public MenuScenario(){
        this.setGridLinesVisible(false);
        this.setPadding(new Insets(40));
        this.setHgap(20);
        this.setVgap(20);


        ToggleGroup scenario = new ToggleGroup();


        for (int i =0 ;i<10;i++){
            RadioButton nouveauBouton = new RadioButton();
            Integer index = i+1;
            String nomScenario = new String("scenario_"+ index+".txt");

            Label label = new Label(nomScenario);
            Label labelEspace = new Label("  -->  ");

            this.add(label,1, i,2,1);
            this.add(labelEspace , 3,i,1,1);
            this.add(nouveauBouton,4, i ,5,1);

            nouveauBouton.setToggleGroup(scenario);
            nouveauBouton.setUserData(nomScenario);
            nouveauBouton.addEventHandler(ActionEvent.ACTION,HBoxRoot.getControleur());
        }

        Button bouttonEnregistrer = new Button("Enregistrer");
        bouttonEnregistrer.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControleur());


        this.add(bouttonEnregistrer,5,10,5,1);

    }
    public String getScenario(){
        return nomScenario;
    }
    public void setNomScenario(String nom){
        this.nomScenario =nom;
        System.out.println("nom "+nomScenario);
    }

}

















