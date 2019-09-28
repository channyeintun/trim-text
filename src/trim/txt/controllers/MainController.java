/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trim.txt.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author ASUS
 */
public class MainController implements Initializable {
    
    @FXML
    private JFXTextArea textField;
    @FXML
    private JFXButton trimButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void Trim(ActionEvent event) {
        String text=textField.getText();
        textField.clear();
        textField.setText(trimText(text));
    }
    
    private String trimText(String text){
        text=text.replaceAll("[\\n\\t ]","");
        System.out.println("Process successful");
        return text;
    }
}
