package shop;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class FXMLDocumentController implements Initializable {
    
    @FXML
    private AnchorPane main_form;
    @FXML
    private TextField username;
    @FXML
    private Button loginBtn;
    @FXML
    private Button close;
    
    private double x = 0;
    private double y = 0;
    
    public String name = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void loginAdmin(ActionEvent event) throws IOException {
        
        // We Could Put SQL System

        if(username.getText() == null || username.getText().trim().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);

            alert.setContentText("You Must Fill Username!");
            
            alert.showAndWait();
        } else {
            name = username.getText();
            
            Parent root = FXMLLoader.load(getClass().getResource("market.fxml"));
            
            Stage prev = (Stage) ((Node) event.getSource()).getScene().getWindow();
            prev.close();
            
            Stage Home = new Stage();
            
            Scene scene = new Scene(root);

            Home.getIcons().add(new javafx.scene.image.Image("img/favicon.png"));

            Home.setResizable(false);
            Home.setMaximized(true);
            Home.centerOnScreen();
            Home.setScene(scene);
            Home.show();  
        }
        
    }

    @FXML
    private void close(ActionEvent event) {
        System.exit(0);
    }
    
}
