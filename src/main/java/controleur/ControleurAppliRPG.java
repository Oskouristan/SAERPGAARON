package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleButton;
import modele.AlgorithmeLV1;
import vue.HBoxRoot;
import vue.MenuScenario;

import java.io.File;

public class ControleurAppliRPG implements EventHandler {


    @Override
    public void handle(Event event) {


        MenuScenario menuScenario = HBoxRoot.getMenuScenario();

        if (event.getSource() instanceof Button){
            HBoxRoot.getvBoxAffichageSolutions().effacerSolutionPrecedente();

            File planningFile = new File("ressources"+File.separator+menuScenario.getScenario());
            AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);

            //switch(menuScenario.getIndexChoix()) {
            //}

            if (menuScenario.getIndexChoix()==0)
                algorithmeLV1.decisionExhaustive();
            if (menuScenario.getIndexChoix()==1)
                algorithmeLV1.decisionExhaustivesOptimaleEnTermeDeDeplacement();
            if (menuScenario.getIndexChoix()==2)
                algorithmeLV1.decisionEfficaceGlouton();
            if (menuScenario.getIndexChoix()==3)
                algorithmeLV1.decisionEfficaceEnFonctionDesQuetes();
        }
        if (event.getSource() instanceof RadioButton) {
            menuScenario.setNomScenario((String) ((RadioButton)event.getSource()).getUserData());}
        if (event.getSource() instanceof ToggleButton) {
            System.out.println(((String) ((ToggleButton)event.getSource()).getUserData()));}
    }
}
