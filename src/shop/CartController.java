package shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import static shop.MarketController.imagesFruits;
import static shop.MarketController.priceFruits;
import static shop.MarketController.quantityFruits;

public class CartController implements Initializable {

    private AnchorPane scroll;
    @FXML
    private GridPane grid;
    @FXML
    private Text total;

    public GridPane getGrid() {
        return grid;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {         
        int row = 1;
        double temp_total_price = 0;
        try {
            for (int i = 0; i < imagesFruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("itemCart.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemCartController itemCartController = fxmlLoader.getController();
                itemCartController.setDataCart(imagesFruits.get(i), quantityFruits.get(i));

                grid.add(anchorPane, 0, row);
                grid.setPrefWidth(551);
                grid.setPrefHeight(86);

                GridPane.setMargin(anchorPane, new Insets(15));
                
                temp_total_price = temp_total_price + (quantityFruits.get(i) * priceFruits.get(i));
                        
                row++;
            }
            
            total.setText(String.valueOf(Math.floor(temp_total_price)) + " €");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
    
}
