module edu.neumont.csc180.cvaughn.webcrawler {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires java.sql;

    opens edu.neumont.csc180.cvaughn.webcrawler to javafx.fxml;
    exports edu.neumont.csc180.cvaughn.webcrawler;
}
