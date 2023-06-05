package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.*;
import modele.LectureFichierTexte;
import vue.HBoxRoot;
import vue.MenuScenario;

import java.io.File;

public class ControleurAppliRPG implements EventHandler {

    @Override
    public void handle(Event event) {


        MenuScenario menuScenario = HBoxRoot.getMenuScenario();

        if (event.getSource() instanceof Button){
            System.out.println("it works");
            File planningFile = new File("ressources"+File.separator+"scenario_1.txt");
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

        /**
        if (event.getSource() instanceof ToggleButton){
            DateCalendrier date = (DateCalendrier) ((ToggleButton)event.getSource()).getUserData();
            reservationPane.setDate(date);
            dateSel = date;
            reservationPane.setDate((DateCalendrier) date);
            affichagePane.setDate(date);
            affichagePane.updateTab(planning.getReservationSemaine(((DateCalendrier) date).getWeekOfYear()));
        }

        */
    }
}
