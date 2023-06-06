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

            File planningFile = new File("ressources"+File.separator+menuScenario.getScenario());
            AlgorithmeLV1 algorithmeLV1 = new AlgorithmeLV1(planningFile);
            algorithmeLV1.decisionExhaustivesEtGloutonne();
            /**
            try {
                res = new Reservation(reservationPane.getDate(), reservationPane.getPlageHoraire(), reservationPane.getTitre());
                planning.ajout(res);
                affichagePane.updateTab(planning.getReservationSemaine(dateSel.getWeekOfYear()));
            } catch (ExceptionPlanning e) {
                throw new RuntimeException(e);}
            LectureEcriture.ecriture(HBoxRoot.getPlanningFile(),planning);
            */
        }
        if (event.getSource() instanceof RadioButton) {
            menuScenario.setNomScenario((String) ((RadioButton)event.getSource()).getUserData());}
        if (event.getSource() instanceof ToggleButton) {
            System.out.println(((String) ((ToggleButton)event.getSource()).getUserData()));}
    }
}
