package vue;

import controleur.ControleurAppliRPG;
import javafx.scene.layout.HBox;


public class HBoxRoot extends HBox {
    static private ControleurAppliRPG controleurAppliRPG;
    static private VBoxAffichageSolutions vBoxAffichageSolutions;
    static private MenuScenario menuScenario;

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


