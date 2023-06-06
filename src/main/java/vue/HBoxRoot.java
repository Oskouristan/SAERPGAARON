package vue;
import controleur.ControleurAppliRPG;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modele.*;

import java.io.File;


public class HBoxRoot extends HBox {
    static private ControleurAppliRPG controleurAppliRPG;
    static private VBoxAffichageSolutions vBoxAffichageSolutions;
    static private MenuScenario menuScenario;
    static private MenuDecisions menuDecisions;


    public HBoxRoot() {
        controleurAppliRPG = new ControleurAppliRPG();
        vBoxAffichageSolutions = new VBoxAffichageSolutions();
        menuScenario = new MenuScenario();
        menuDecisions = new MenuDecisions();

        getChildren().addAll(menuScenario,vBoxAffichageSolutions);
    }

    public static ControleurAppliRPG getControleur(){
        return controleurAppliRPG;
    }
    public static VBoxAffichageSolutions getvBoxAffichageSolutions(){
        return vBoxAffichageSolutions;
    }
    public static MenuScenario getMenuScenario(){
        return menuScenario;
    }
    public static MenuDecisions getMenuDecisions(){return menuDecisions;}
}


