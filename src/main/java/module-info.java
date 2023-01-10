module clubfutbol.torerosclub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens clubfutbol.torerosclub to javafx.fxml;
    exports clubfutbol.torerosclub;
}
