module clubfutbol.torerosclub {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires javafx.base;
    requires javafx.graphics;
    

    opens clubfutbol.torerosclub to javafx.fxml, javafx.base, javafx.graphics;
    opens clubfutbol.torerosclub.modulos.tablas to javafx.base;
    exports clubfutbol.torerosclub;
    exports clubfutbol.torerosclub.modulos.tablas;


}
