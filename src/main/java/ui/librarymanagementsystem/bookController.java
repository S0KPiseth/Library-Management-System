package ui.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class bookController{

    @FXML
    private Label authorName;

    @FXML
    private Label bookName;

    @FXML
    private ImageView coverImage;

   public void setData(Book book){
       Image image = new Image(getClass().getResourceAsStream("Assets/icons8-no-image-240.png"));
       coverImage.setImage(image);
       bookName.setText(book.getBookName());
       authorName.setText(book.getBookAuthor());

   }
}
