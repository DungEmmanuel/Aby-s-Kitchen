/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abykitchen;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Dungs
 */
public class User 
{
   // private final static String USERNAME_PROP_NAME = "userName";
    private String userName;
    //private final static String PASSWORD_PROP_NAME = "password";
    private String password;
    public User() 
    {
        userName = "";
        password = "";
    }
    public final String getUserName() 
    {
        return userName;
    }
    
    public final String getPassword() 
    {
        return password;
    }
    public final void setPassword(String passwords) 
    {
        password=passwords;
    }
    public final void setUserName(String username) 
    {
        userName=username;
    }
}
