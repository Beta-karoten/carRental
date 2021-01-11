module projekt {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.sql;

    opens projekt to javafx.fxml;
    exports projekt;
}