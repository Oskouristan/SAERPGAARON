package vue;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class MenuScenario extends GridPane {
    String nomScenario;

    ComboBox choixDecision;

    int indexChoix ;


    public MenuScenario(){
        this.setGridLinesVisible(false);
        this.setPadding(new Insets(40));
        this.setHgap(20);
        this.setVgap(20);


        ToggleGroup scenario = new ToggleGroup();

        Label labelScenario= new Label("Scenario");
        this.add(labelScenario,2,0,5,1);

        int index = 0;
        for(int i =1 ;i<4;i++){

            for(int j =0 ;j<24;j=j+6){
                if (index<11) {
                    RadioButton nouveauBouton = new RadioButton();
                    String nomScenario = new String("scenario_" + index + ".txt");
                    index++;

                    Label label = new Label(nomScenario);

                    this.add(label, j, i, 5, 1);
                    this.add(nouveauBouton, j +4, i, 1, 1);

                    nouveauBouton.setToggleGroup(scenario);
                    nouveauBouton.setUserData(nomScenario);
                    nouveauBouton.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControleur());
                }
            }
        }

        Label labelDecision = new Label("Type de Décision");
        this.add(labelDecision,2,5,5,1);


        choixDecision =  new ComboBox();
        ArrayList <String> choixDecisionPossibles = new ArrayList<>();
        choixDecisionPossibles.add("decisionExhaustive");
        choixDecisionPossibles.add("decisionExhaustivesEtGloutonne");
        choixDecisionPossibles.add("decisionEfficaceGlouton");
        choixDecisionPossibles.add("decisionEfficaceEnFonctionDesQuetes");

        for(String typeDecision : choixDecisionPossibles){
            choixDecision.getItems().add(typeDecision);
        }
        this.add(choixDecision, 1,7,8,1);

        Button bouttonEnregistrer = new Button("Enregistrer");
        bouttonEnregistrer.addEventHandler(ActionEvent.ACTION, HBoxRoot.getControleur());
        this.add(bouttonEnregistrer,5,10,5,1);

    }
    public String getScenario(){
        return nomScenario;
    }
    public void setNomScenario(String nom){
        this.nomScenario =nom;
        //System.out.println("nom "+nomScenario);
    }
    public int getIndexChoix(){
        indexChoix = choixDecision.getSelectionModel().getSelectedIndex();
        return indexChoix;
    }


}

















