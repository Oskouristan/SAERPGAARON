package vue;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modele.*;

import java.io.File;


public class HBoxRoot extends HBox {


    public HBoxRoot() {
        VBoxAffichageSolutions vBoxAffichageSolutions = new VBoxAffichageSolutions();
        Label test = new Label("test");
        getChildren().add(vBoxAffichageSolutions);
    }
}


