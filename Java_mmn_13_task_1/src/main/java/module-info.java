module com.example.java_mmn_13_task_1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_mmn_13_task_1 to javafx.fxml;
    exports com.example.java_mmn_13_task_1;
}