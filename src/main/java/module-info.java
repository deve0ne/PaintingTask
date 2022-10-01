module com.deveone.paintingtask {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.deveone.paintingtask to javafx.fxml;
    exports com.deveone.paintingtask;
    exports com.deveone.paintingtask.shapes;
    opens com.deveone.paintingtask.shapes to javafx.fxml;
}