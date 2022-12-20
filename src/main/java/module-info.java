module com.example.supplychainmanagement {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.supplychainmanagement to javafx.fxml;
    exports com.example.supplychainmanagement;
}