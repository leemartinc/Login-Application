/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package defaultapp;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
//import java.time.Duration;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author leemartinc
 */
public class LoginController implements Initializable {

    @FXML
    private JFXTextField username;
    @FXML
    private JFXPasswordField password;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton signup;
    @FXML
    private JFXButton exit;

    private AnchorPane rootPane;
    
    //for login access to enter the app
    boolean access = false;
    
    @FXML
    private Label wrong;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        wrong.setVisible(false);
    }    
//private void loadSplashScreen() throws IOException{
//    
//    StackPane pane = FXMLLoader.load(getClass().getResource("splash.fxml"));
//    
//    rootPane.getChildren().setAll(pane);
//    
//    FadeTransition fadeIn = new FadeTransition(Duration.seconds(3), pane);
//    
//    fadeIn.setFromValue(0);
//    
//    fadeIn.setToValue(1);
//    
//    fadeIn.setCycleCount(1);
//    
//     FadeTransition fadeOut = new FadeTransition(Duration.seconds(3), pane);
//    
//    fadeOut.setFromValue(0);
//    
//    fadeOut.setToValue(1);
//    
//    fadeOut.setCycleCount(1);
//    
//    fadeIn.play();
//    
//    fadeIn.setOnFinished((e)->{
//       fadeOut.play();
//    });
//   }
//    private void loadSplash() throws IOException{
//         Parent splashRoot = FXMLLoader.load(getClass().getResource("splash.fxml"));
//        Scene splashScene = new Scene(splashRoot);
//        Stage splashStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        splashStage.setScene(splashScene);
//        splashStage.show();
//    }

    //When login button is pressed...
    @FXML
    private void Login(ActionEvent event) throws Exception{
        
        String user = username.getText();
        String pass = password.getText();
        
        //condition for if the user name and password is in the database and correct
        if("".equals(user) && "".equals(pass)){
           access = true;} 
        else {access = false;}
        
        
        //condition for if login is failed or passed
        if(access){
        
        wrong.setVisible(false);    
            
        Parent splashRoot = FXMLLoader.load(getClass().getResource("splash.fxml"));
        Scene splashScene = new Scene(splashRoot);
        Stage splashStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        splashStage.setScene(splashScene);
        splashStage.show();
        
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        
        Scene scene2 = new Scene(root);
        
        Stage stage = new Stage();
        
        stage.setScene(scene2);
        
        stage.initStyle(StageStyle.DECORATED);
        
        stage.setTitle("Home");
     
        root.requestFocus();

        //Stage stageOld =(Stage) ((Node) event.getSource()).getScene().getWindow();

        FadeTransition fadeIn = new FadeTransition(Duration.seconds(5), splashRoot);
    
        fadeIn.setFromValue(0);
    
        fadeIn.setToValue(1);
    
        fadeIn.setCycleCount(1);
    
//    FadeTransition fadeOut = new FadeTransition(Duration.seconds(6), splashRoot);
//    
//    fadeOut.setFromValue(1);
//    
//    fadeOut.setToValue(0);
//    
//    fadeOut.setCycleCount(1);
    
        fadeIn.play();
    
        fadeIn.setOnFinished((e)->{
            
            splashStage.hide(); 
            
            stage.show();
            
        });     
    }
        else if(!access){ 
            wrong.setVisible(true);
        }
    }

    @FXML
    private void Signup(ActionEvent event) {
    }
    
     @FXML
    private void Exit(ActionEvent event) {
    Stage stage = (Stage) exit.getScene().getWindow();
    stage.close();
    }
    
}