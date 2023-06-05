package controleur;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import modele.*;
import modele.LectureFichierTexte;
import vue.HBoxRoot;

public class ControleurAppliRPG implements EventHandler {

    @Override
    public void handle(Event event) {
        /**
         * On récupère les différentes instances des champs de HBoxRoot avec les fonction get

        PlanningCollections planning = HBoxRoot.getPlanning();
        GridPaneFormulaireReservation reservationPane = HBoxRoot.getReservationPane();
        VBoxAffichagePlanning affichagePane = HBoxRoot.getAffichagePane();

        //Ici on attribue une fonction à chaque bouton une fonction qui différe en fonction de sa nature
        //Si il s'agit d'un toggleBouton il récupère la date qu'il lui est attribué et on change ensuite la date
        //de la reservation et on change le tableau de AffichagePlanning pour qu'il affiche les reservations en liens avec
        //La semaine de la date du bouton cliqué
        if (event.getSource() instanceof ToggleButton){
            DateCalendrier date = (DateCalendrier) ((ToggleButton)event.getSource()).getUserData();
            reservationPane.setDate(date);
            dateSel = date;
            reservationPane.setDate((DateCalendrier) date);
            affichagePane.setDate(date);
            affichagePane.updateTab(planning.getReservationSemaine(((DateCalendrier) date).getWeekOfYear()));
        }
        // ici bouton enregistrer est concerné cette fonction permet dans le cas ou le bouton enregistrer est cliqué
        // de ajouter la reservation au tableau de l'affichage planning si évidemment la reservation n'est pas vide
        // Et l'enregistre dans un fichier seriazable pour ne pas que cette reservation soit perdue
        if (event.getSource() instanceof Button){
            Reservation res;
            try {
                res = new Reservation(reservationPane.getDate(), reservationPane.getPlageHoraire(), reservationPane.getTitre());
                planning.ajout(res);
                affichagePane.updateTab(planning.getReservationSemaine(dateSel.getWeekOfYear()));
            } catch (ExceptionPlanning e) {
                throw new RuntimeException(e);}
            LectureEcriture.ecriture(HBoxRoot.getPlanningFile(),planning);

        }*/
    }
}
