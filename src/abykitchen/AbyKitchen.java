/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abykitchen;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Dungs
 */
public class AbyKitchen extends Application 
{
    
     static Stage theStage;
     @Override public void init() 
     {
        Font.loadFont(AbyKitchen.class.getResourceAsStream("Roboto-Thin.ttf"), 10).getName();
        Font.loadFont(AbyKitchen.class.getResourceAsStream("Roboto-Light.ttf"), 10).getName();
     }
    
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        theStage=primaryStage;    
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        theStage.setScene(new Scene(root, 630, 312));
        theStage.setTitle("Aby's FastFood");
        theStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        launch(args);
    }
    
    
    public static void changeScene(String SceneName)throws IOException
    {
        
		Parent root = FXMLLoader.load(AbyKitchen.class.getResource(SceneName));
                theStage.setScene(new Scene(root, 1000, 600));
                theStage.getScene().setRoot(root);
                theStage.centerOnScreen();
                theStage.show();
    }
}
