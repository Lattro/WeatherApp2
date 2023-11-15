module com.example.weatherapp2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;


    opens com.example.weatherapp2 to javafx.fxml;
    exports com.example.weatherapp2;
    opens com.example.wetherapp to javafx.fxml;
}