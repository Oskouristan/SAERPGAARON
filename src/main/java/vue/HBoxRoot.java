package vue;
import controleur.ControleurAppliRPG;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modele.*;

import java.io.File;


public class HBoxRoot extends HBox {
    static ControleurAppliRPG controleurAppliRPG;
    static VBoxAffichageSolutions vBoxAffichageSolutions;
    static MenuScenario menuScenario;


    public HBoxRoot() {
        controleurAppliRPG = new ControleurAppliRPG();
        vBoxAffichageSolutions = new VBoxAffichageSolutions();
        menuScenario = new MenuScenario();

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
}


