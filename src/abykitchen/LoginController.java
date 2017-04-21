/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abykitchen;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dungs
 */
public class LoginController implements Initializable 
{
    
    private String queryString, staff_role;
    DBConnector dbconnect=new DBConnector();
    ResultSet rs=null;
     @FXML
      private Label signIn;
     
     @FXML
      private TextField usernameField;
      
      @FXML
      private TextField passwordField;
      
      
      @FXML
      private Button login;
      
      @FXML
      private Button cancel;
      private Object event;
   
      
      
      
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    
    
    
    @FXML
    void loginFired(ActionEvent event) 
    {
        authenticate(usernameField.getText(), passwordField.getText());
    }
    
    
    @FXML
    void cancelFired(ActionEvent event) 
    {
        
    }
    
    
    
    
    private void authenticate(String user_name, String pass_word) 
    {
        
        
        try
        {
           queryString="select role FROM users WHERE username ='" + user_name + "' AND password ='" + pass_word + "';";
           rs=dbconnect.selectRecordsFromTable(queryString);
           
           if(rs.first())
           {
                rs.beforeFirst();
                while(rs.next())
               {
                  staff_role=rs.getNString("role");
                  if(staff_role.equals("salesrep"))
                  {
                      AbyKitchen.changeScene("WorkPlatForm.fxml");
                  }
                  if(staff_role.equals("administrator"))
                  {
                              
                  }
                      
               }
               

               
           }
           else
           {
               //issue a popup saying either of the credentials is wrong pls try again
               
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("Warning Dialog");
                alert.setContentText("Either the User or Password is Incorrect!, Please check and try again");
                alert.showAndWait();
               
               
           }
           
        } catch (SQLException | IOException ex) 
        {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
       
    }
}
