package ui.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

import java.io.IOException;


public class mainFrameController {
    @FXML
    private ImageView bookCategories;
    @FXML
    private ImageView chatMessage;
    @FXML
    private ImageView uploadBook;
    @FXML
    private Line bookCategoriesPointer;
    @FXML
    private Line chatMessagePointer;
    @FXML
    private Line uploadBookPointer;
    @FXML
    private Button closeBtn;
    @FXML
    private Button maxBtn;
    @FXML
    private Button minBtn;
    @FXML
    private VBox mainBookContianer;
    @FXML
    AnchorPane tempPane;

    //get image
    Image bookCategoriesImage = new Image(getClass().getResourceAsStream("Assets/icons8-book-50.png"));
    Image closeBtnImage = new Image(getClass().getResourceAsStream("Assets/pause _icon.png"));
    Image maxBtnImage = new Image(getClass().getResourceAsStream("Assets/maximize-2.png"));
    Image minBtnImage = new Image(getClass().getResourceAsStream("Assets/minus.png"));


    public void onBookCategoriesClicked(MouseEvent event) throws IOException {
        chatMessagePointer.setVisible(false);
        uploadBookPointer.setVisible(false);
        bookCategoriesPointer.setVisible(true);
        bookCategories.setImage(bookCategoriesImage);
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("bookGenre.fxml"));
        // stack overflow
        Region n = (Region)fxml.load();
        tempPane.getChildren().add(n);
        n.prefWidthProperty().bind(tempPane.widthProperty());
        n.prefHeightProperty().bind(tempPane.heightProperty());

    }
    public void onChatMessageClicked(MouseEvent event) {
        chatMessagePointer.setVisible(true);
        uploadBookPointer.setVisible(false);
        bookCategoriesPointer.setVisible(false);
    }
    public void onUploadBookClicked(MouseEvent event) {
        chatMessagePointer.setVisible(false);
        uploadBookPointer.setVisible(true);
        bookCategoriesPointer.setVisible(false);
    }
}
