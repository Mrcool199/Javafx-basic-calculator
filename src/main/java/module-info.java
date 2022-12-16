module com.example.bjjhb {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.bjjhb to javafx.fxml;
    exports com.example.bjjhb;
}