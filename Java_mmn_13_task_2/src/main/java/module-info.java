module com.example.java_mmn_13_task_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.java_mmn_13_task_2 to javafx.fxml;
    exports com.example.java_mmn_13_task_2;
}