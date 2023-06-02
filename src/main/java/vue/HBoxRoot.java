package vue;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import modele.*;

import java.io.File;


public class HBoxRoot extends HBox {


    public HBoxRoot() {
        Label test = new Label("test");
        this.getChildren().add(test);
    }
}


