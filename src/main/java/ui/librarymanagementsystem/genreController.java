package ui.librarymanagementsystem;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class genreController implements Initializable {

    @FXML
    private HBox bookContainer;

    @FXML
    private Label genre;
    @FXML
    private GridPane normalBooks;
    @FXML
    private VBox bookDisplayFrame;

    double genreFilter = 4.7;
    List<Book> books;
    List<String> bookNames = new ArrayList<>();
    List<String> authors = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            boolean option = true;

            getBooksByGenre(genreFilter, bookNames, authors, option);
            books = new ArrayList<>(getBook(bookNames,authors));

            for(Book book : books){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("bookInfo.fxml"));
                AnchorPane bookDisplay= fxmlLoader.load();
                bookController bookController = fxmlLoader.getController();
                bookController.setData(book);
                bookContainer.getChildren().add(bookDisplay);
            }
            System.out.println(bookNames);
            bookNames.clear();
            authors.clear();
            books.clear();
            option = false;
            getBooksByGenre(genreFilter, bookNames, authors, option);
            books = new ArrayList<>(getBook(bookNames,authors));
            int colums =0;
            int row =1;
            for(int i =0; i<20; i++){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("bookInfo.fxml"));
                AnchorPane bookDisplay = fxmlLoader.load();
                bookController bookController = fxmlLoader.getController();
                bookController.setData(books.get(i));
                if (colums ==15){
                    colums=0;
                    row++;
                }
                normalBooks.add(bookDisplay,colums++, row);
            }
            System.out.println(bookNames);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public static void getBooksByGenre(double genreInput, List<String> bookNames, List<String> authors, boolean option) {
        String filePath ="src/main/resources/ui/librarymanagementsystem/Assets/clean_books.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header row

            // Read file line by line
            while ((line = br.readLine()) != null) {
                String[] values = line.split(","); // Assuming CSV is comma-separated

                if (values.length > 4) {
                    String bookName = values[0];  // Name column
                    String author = values[1];    // Author column
                    String  bookGenre = values[values.length-3];// Genre column

                    // If the genre matches, add book name and author to their respective lists
                    if (option){
                        if (Float.parseFloat(bookGenre) >genreInput ) {
                            bookNames.add(bookName);
                            authors.add(author);
                        }
                    }else{
                        if (Float.parseFloat(bookGenre) <genreInput ) {
                            bookNames.add(bookName);
                            authors.add(author);
                        }
                    }
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private List<Book> getBook(List<String> bookName, List<String> authors) {
        List<Book> books = new ArrayList<>();
        Book book = new Book();
        for (int i = 0; i < bookName.size(); i++) {
            book.setBookName(bookName.get(i));
            book.setBookAuthor(authors.get(i));
            books.add(book);
            book = new Book();
        }
        return books;
    }
}
