package vue;
import controleur.ControleurAppliRPG;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modele.*;

import java.io.File;


public class HBoxRoot extends HBox {
    ControleurAppliRPG controleurAppliRPG;
    VBoxAffichageSolutions vBoxAffichageSolutions;
    MenuScenario menuScenario;


    public HBoxRoot() {
        controleurAppliRPG = new ControleurAppliRPG();

        vBoxAffichageSolutions = new VBoxAffichageSolutions();
        menuScenario = new MenuScenario();

        getChildren().addAll(menuScenario,vBoxAffichageSolutions);
    }

    public ControleurAppliRPG getControleur(){
        return controleurAppliRPG;
    }
    public VBoxAffichageSolutions getvBoxAffichageSolutions(){
        return vBoxAffichageSolutions;
    }
    public MenuScenario getMenuScenario(){
        return menuScenario;
    }
}


