module com.example.fakeexam {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.fakeexam to javafx.fxml;
    exports com.example.fakeexam;
}