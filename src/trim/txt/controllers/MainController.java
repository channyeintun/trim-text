/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trim.txt.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.net.URL;
import javafx.util.Duration;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Popup;

/**
 *
 * @author Chan Nyein Tun
 */
public class MainController implements Initializable {

    @FXML
    private JFXTextArea textField;
    @FXML
    private JFXButton trimButton;
    @FXML
    private JFXButton copyButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void Trim(ActionEvent event) {
        String text = textField.getText();
        textField.clear();
        textField.setText(trimText(text));
    }

    private String trimText(String text) {
        text = text.replaceAll("[\\n\\t ]", "");
        System.out.println("Process successful");
        return text;
    }

    @FXML
    private void CopyToClipboard(ActionEvent event) throws IOException {
        String str = textField.getText();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        StringSelection strSel = new StringSelection(str);
        clipboard.setContents(strSel, null);
        Label label = new Label("Copied to Clipboard");
        label.setStyle("-fx-background-color:transparent");
        label.setStyle("-fx-text-fill:white");
        Popup popup = new Popup();
        popup.setX(586.4189453125);
        popup.setY(350.0);
        popup.setAutoHide(true);
        popup.getContent().add(label);
        if (!popup.isShowing()) {
            popup.show(textField.getScene().getWindow());
            System.out.println(popup.getX());
            System.out.println(popup.getY());
            PauseTransition delay = new PauseTransition(Duration.seconds(1));
            delay.setOnFinished(e -> popup.hide());
            delay.play();
        }
    }

}
