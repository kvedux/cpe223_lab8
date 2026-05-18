module cpe223.karlvince.lab8 {

    requires transitive javafx.graphics;
    requires transitive javafx.controls;
    requires javafx.fxml;

    opens cpe223.karlvince.lab8 to javafx.fxml;
    exports cpe223.karlvince.lab8;
}
