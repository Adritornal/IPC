/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package poiupv;

import com.sun.javafx.logging.PlatformLogger;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
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
import static javafx.scene.input.KeyCode.EQUALS;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import static model.User.checkEmail;
import static model.User.checkNickName;
import static model.User.checkPassword;
import poiupv.FXMLSignUpController;
import model.User;

/**
 * FXML Controller class
 *
 * @author adrit
 */
public class FXMLRegistrarseController implements Initializable {
    
    private BooleanProperty validPassword;
    private BooleanProperty validEmail;
    private BooleanProperty equalPasswords;
    
    @FXML
    private Label lIncorrectEmail;
    @FXML
    private Button bRegistrarse;
    @FXML
    private TextField eemail;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField password2;
    @FXML
    private Label lIncorrectPassword;
    @FXML
    private Label lPassDifferent;
    @FXML
    private Label lNombreNoValido;
    @FXML
    private Button bInicia;
    @FXML
    private Button Mostrar;
    @FXML
    private TextField UserN;

    
     private void manageError(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.FALSE);
        showErrorMessage(errorLabel,textField);
        textField.requestFocus();
 
    }
     private void manageCorrect(Label errorLabel,TextField textField, BooleanProperty boolProp ){
        boolProp.setValue(Boolean.TRUE);
        hideErrorMessage(errorLabel,textField);
        
    }
    private void showErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(true);
        textField.styleProperty().setValue("-fx-background-color: #FCE5E0");    
    }
    private void hideErrorMessage(Label errorLabel,TextField textField)
    {
        errorLabel.visibleProperty().set(false);
        textField.styleProperty().setValue("");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        validEmail = new SimpleBooleanProperty();
        validPassword = new SimpleBooleanProperty();   
        equalPasswords = new SimpleBooleanProperty();
        
        validPassword.setValue(Boolean.FALSE);
        validEmail.setValue(Boolean.FALSE);
        equalPasswords.setValue(Boolean.FALSE);
        
        
        eemail.focusedProperty().addListener((observable, oldValue, newValue)->{
        if(!newValue){ //focus lost.
        checkEditEmail();
        }
        });
        
        password.focusedProperty().addListener((observable, oldValue, newValue)->{
        if(!newValue){ //focus lost.
        checkEditPassword();
        }
        });
        
        password2.focusedProperty().addListener((observable, oldValue, newValue)->{
        if(!newValue){ //focus lost.
        checkEquals();
        }
        });   
        
        BooleanBinding validFields = Bindings.and(validEmail, validPassword)
                 .and(equalPasswords);
        
        bRegistrarse.disableProperty().bind(
        Bindings.not(validFields)
        ); 
        
    }    

    private void checkEditEmail() {
        if(!checkEmail(eemail.textProperty().getValueSafe()))
        //Incorrect email
        manageError(lIncorrectEmail, eemail,validEmail );
        else
        manageCorrect(lIncorrectEmail, eemail,validEmail ); 
    }
    private void checkEditPassword() {
        if(!checkPassword(password.textProperty().getValueSafe()))
        //Incorrect email
        manageError(lIncorrectPassword, password,validPassword );
        else
        manageCorrect(lIncorrectPassword, password,validPassword ); 
    }
    private void checkEquals(){
        if(Poi.checkPassword(password.textProperty().getValueSafe())&&password.textProperty().getValueSafe().compareTo(
            password2.textProperty().getValueSafe()) != 0){
            showErrorMessage(lPassDifferent,password2);
            equalPasswords.setValue(Boolean.FALSE);
            password.textProperty().setValue("");
            password2.textProperty().setValue("");
            password.requestFocus();
        }else
        manageCorrect(lPassDifferent,password2,equalPasswords);
    }
    @FXML
    private void handleBRegisterOnAction(ActionEvent event) {
        try{
 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
            Parent root = loader.load();
            
            Stage stage= new Stage();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
            
            //stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.bRegistrarse.getScene().getWindow();
            myStage.close();
            
        }catch (IOException ex){
            //Logger.getLogger(FXMLSignUpController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    @FXML
    private void handleBAcceptOnAction(ActionEvent event) {
        try{
 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLIniciarSesion.fxml"));
            Parent root = loader.load();
            
            Stage stage= new Stage();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
            
            //stage.setOnCloseRequest(e -> controlador.closeWindows());
            
            Stage myStage = (Stage) this.bInicia.getScene().getWindow();
            myStage.close();
            
        }catch (IOException ex){
            //Logger.getLogger(FXMLSignUpController.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
    @FXML
    private void MostrarContraseñaButton() {
    }
}

    


    

    

    
    
    /*public void closeWindows(){
        try{
 

            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLSignUp.fxml"));
            Parent root = loader.load();

            FXMLSignUpController controlador = loader.getController();
            
            Stage stage= new Stage();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
                        
            Stage myStage = (Stage) this.bIinicia.getScene().getWindow();
            myStage.close();
            
        }catch (IOException ex){
            //System.Logger.getLogger(FXMLSignUpController.class.getName()).log(PlatformLogger.Level.SEVERE, null, ex);
        }
            }*/

