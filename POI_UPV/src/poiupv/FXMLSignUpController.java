/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poiupv;

import com.sun.javafx.logging.PlatformLogger;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.BooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author adrit
 */
public class FXMLSignUpController implements Initializable {

    @FXML
    private Label lIncorrectPassword;
    @FXML
    private Button bAccept;
    @FXML
    private TextField UserN;
    @FXML
    private PasswordField Password;
    @FXML
    private Label IncorrectUser;
    @FXML
    private Button bRegistro;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBAcceptOnAction(ActionEvent event) {
        try{
 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root1 = loader.load();
            
            Stage stage1= new Stage();
            Scene scene = new Scene(root1);
            
            stage1.setScene(scene);
            stage1.show();
            
            //stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.bAccept.getScene().getWindow();
            myStage.close();
            
        }catch (IOException ex){
            //Logger.getLogger(FXMLSignUpController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @FXML
    private void handleBRegistroOnAction(ActionEvent event) {
        try{
 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLRegistrarse.fxml"));
            Parent root = loader.load();
            
            Stage stage= new Stage();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.bRegistro.getScene().getWindow();
            myStage.close();
            
        }catch (IOException ex){
            //Logger.getLogger(FXMLSignUpController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    
}
