package sWProjektFX;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class MenuController {
    private Player p1, p2, p3, p4, p5 = null;

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private AnchorPane rules;
    @FXML
    private Label welcomeLabel1, welcomeLabel2;
    @FXML
    private ButtonBar playerCho, colorCho;
    @FXML
    private Button colorRedButton, colorBlueButton, colorGreenButton, colorGrayButton, colorWhiteButton, playButton, backButton, rulesButton, rulesBack;
    private int playerCount, countOfPlayers;

    @FXML
    public void plG2(ActionEvent e) {
        welcomeLabel2.setText("Which color do you want to have?");
        playerCho.setDisable(true);
        playerCho.setVisible(false);
        colorCho.setDisable(false);
        colorCho.setVisible(true);
        backButton.setDisable(false);
        backButton.setVisible(true);
        playerCount = 2; countOfPlayers = 2;
        p1 = new Player();
        p2 = new Player();
    }

    @FXML
    public void plG3(ActionEvent e) {
        welcomeLabel2.setText("Which color do you want to have?");
        playerCho.setDisable(true);
        playerCho.setVisible(false);
        colorCho.setDisable(false);
        colorCho.setVisible(true);
        backButton.setDisable(false);
        backButton.setVisible(true);
        playerCount = 3; countOfPlayers = 3;
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
    }

    @FXML
    public void plG4(ActionEvent e) {
        welcomeLabel2.setText("Which color do you want to have?");
        playerCho.setDisable(true);
        playerCho.setVisible(false);
        colorCho.setDisable(false);
        colorCho.setVisible(true);
        backButton.setDisable(false);
        backButton.setVisible(true);
        playerCount = 4; countOfPlayers = 4;
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        p4 = new Player();
    }

    @FXML
    public void plG5(ActionEvent e) {
        welcomeLabel2.setText("Which color do you want to have?");
        playerCho.setDisable(true);
        playerCho.setVisible(false);
        colorCho.setDisable(false);
        colorCho.setVisible(true);
        backButton.setDisable(false);
        backButton.setVisible(true);
        playerCount = 5; countOfPlayers = 5;
        p1 = new Player();
        p2 = new Player();
        p3 = new Player();
        p4 = new Player();
        p5 = new Player();
    }

    @FXML
    public void colorRedCho() throws IOException{
        colorRedButton.setDisable(true);
        playerColorChoose("red");
        if (playerCount == 0){
            colorCho.setVisible(false);
            playButton.setVisible(true);
        }
    }
    @FXML
    public void colorBlueCho()throws IOException{
        colorBlueButton.setDisable(true);
        playerColorChoose("blue");
        if (playerCount == 0){
            colorCho.setVisible(false);
            playButton.setVisible(true);
        }
    }
    @FXML
    public void colorGreenCho() throws IOException{
        colorGreenButton.setDisable(true);
        playerColorChoose("green");
        if (playerCount == 0){
            colorCho.setVisible(false);
            playButton.setVisible(true);
        }
    }
    @FXML
    public void colorGrayCho() throws IOException{
        colorGrayButton.setDisable(true);
        playerColorChoose("gray");
        if (playerCount == 0){
            colorCho.setVisible(false);
            playButton.setVisible(true);
        }
    }
    @FXML
    public void colorWhiteCho() throws IOException {
        colorWhiteButton.setDisable(true);
        playerColorChoose("white");
        if (playerCount == 0) {
            colorCho.setVisible(false);
            playButton.setVisible(true);
        }
    }
    public void playerColorChoose(String color) throws IOException{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("sceneGameSmall.fxml"));
        root = loader.load();
        if (p1.getColor() == null) {
            p1.setColor(color);
            playerCount -= 1;
        } else if (p2.getColor() == null) {
            p2.setColor(color);
            playerCount -= 1;
        } else if (p3.getColor() == null) {
            p3.setColor(color);
            playerCount -= 1;
        } else if (p4.getColor() == null) {
            p4.setColor(color);
            playerCount -= 1;
        } else {
            p5.setColor(color);
            playerCount -= 1;
        }
    }

    @FXML
    public void backToMainMenu(){
        welcomeLabel2.setText("How many players will play?");
        colorRedButton.setDisable(false);
        colorBlueButton.setDisable(false);
        colorGreenButton.setDisable(false);
        colorGrayButton.setDisable(false);
        colorWhiteButton.setDisable(false);
        playerCho.setDisable(false);
        playerCho.setVisible(true);
        colorCho.setDisable(true);
        colorCho.setVisible(false);
        p1 = null;
        p2 = null;
        if(p3 != null){p3 = null;}
        if(p4 != null){p4 = null;}
        if(p5 != null){p5 = null;}
        playButton.setVisible(false);
        backButton.setDisable(true);
        backButton.setVisible(false);
    }

    @FXML
    public void rulesShow(){
        rules.setVisible(true);
    }
    @FXML
    public void rulesHide(){
        rules.setVisible(false);
    }
    @FXML
    public void switchToGameScene(ActionEvent ev) {
        if (countOfPlayers == 2 || countOfPlayers == 3) {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("sceneGameSmall.fxml"));
                root = loader.load();
                GameController gC = loader.getController();
                gC.coloredText1(p1.getColor());
                gC.coloredText2(p2.getColor());
                gC.coloredTextPlayerNow(p1.getColor());
                if(countOfPlayers == 3) {
                    gC.coloredText3(p3.getColor());
                    gC.spaceCreation(countOfPlayers, p1, p2, p3, null, null);
                } else {
                    gC.hidePlayerLabel3();
                    gC.spaceCreation(countOfPlayers, p1, p2, null, null, null);
                }
                stage = (Stage) ((Node) ev.getSource()).getScene().getWindow();
                scene = new Scene(root, 1400, 700);
                stage.setScene(scene);
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            try {
                FXMLLoader loader = new FXMLLoader(Main.class.getResource("sceneGameBig.fxml"));
                root = loader.load();
                GameController gC = loader.getController();
                gC.coloredText1(p1.getColor());
                gC.coloredText2(p2.getColor());
                gC.coloredText3(p3.getColor());
                gC.coloredText4(p4.getColor());
                gC.coloredTextPlayerNow(p1.getColor());
                if(countOfPlayers == 5) {
                    gC.coloredText5(p5.getColor());
                    gC.spaceCreation(countOfPlayers, p1, p2, p3, p4, p5);
                } else {
                    gC.hidePlayerLabel5();
                    gC.spaceCreation(countOfPlayers, p1, p2, p3, p4, null);
                }
                stage = (Stage) ((Node) ev.getSource()).getScene().getWindow();
                scene = new Scene(root, 1400, 700);
                stage.setScene(scene);
                stage.show();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}