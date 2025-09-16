module com.aoc2023.aoc2023 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.aoc2023.aoc2023 to javafx.fxml;
    exports com.aoc2023.aoc2023;
}