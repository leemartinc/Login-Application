/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Optional:

//Same scene -> 
//private AnchorPane rootPane;
//AnchorPane pane = FXMLLoader.load(getClass().getResource("NAME.fxml"));
//rootPane.getChildren().seatAll(pane);

//splash screen ->
//private StackPane rootPane;
//private void loadSplashScreen(){
//StackPane pane = FXMLLoader.load(getClass().getResource("NAME.fxml"));
//rootPane.getChildren().seatAll(pane);
//FadeTransition fadeIn = new FadeTransition(Duration .second(3), pane);
//fadeIn.setFromValue(0);
//fadeIn.setToValue(1);
//fadeIn.setCycleCount(1);

//fadeIn.play();
//}

package defaultapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author leemartinc
 */
public class DefaultApp extends Application {
    
    //init login/first page
    @Override
    public void start(Stage stage) throws Exception{
        stage.initStyle(StageStyle.UNDECORATED);
        
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        
        stage.setTitle("Welcome");
        
        stage.show();
        
        root.requestFocus();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
