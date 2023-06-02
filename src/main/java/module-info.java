module com.example.sae {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.sae to javafx.fxml;
    exports com.example.sae;
    exports vue;
    exports modele;

}