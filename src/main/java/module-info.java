module ui.librarymanagementsystem {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens ui.librarymanagementsystem to javafx.fxml;
    exports ui.librarymanagementsystem;
}