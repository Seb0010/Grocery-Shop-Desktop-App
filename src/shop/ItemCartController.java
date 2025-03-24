package shop;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class ItemCartController implements Initializable {
    
    @FXML
    private AnchorPane items;
    @FXML
    private TextField quantity;
    @FXML
    private ImageView remove_item;
    @FXML
    private ImageView img;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setDataCart(String src, double quantityCart) {  
        String temp = Double.toString(quantityCart);
        quantity.setText(temp);
        Image image = new Image(getClass().getResourceAsStream(src));
        img.setImage(image);
        
    }

}
