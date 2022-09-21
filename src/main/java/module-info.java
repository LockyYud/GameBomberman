module com.example.loadmap {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.loadmap to javafx.fxml;
    exports com.example.loadmap;
}