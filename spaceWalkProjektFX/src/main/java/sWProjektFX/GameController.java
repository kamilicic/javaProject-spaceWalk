package sWProjektFX;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.TreeSet;


public class GameController {
    private boolean rocketsMoved, planetCanBeEnabled, someRocket, someBRocket, someMRocket, someSRocket, tokenUsed;
    private int playerIndex, rocketIndex, rocketMoveCounter, confirmCounter, playerIndexHelper;
    private Integer[] rocketsToMoveIndex;
    private Player p1, p2, p3, p4, p5;
    private Space space;
    private Rocket[] rocketsToMove, rocketsToMoveSorted, rocketsToMoveComplete;
    private ActionEvent mainEvent;
    private ImageView[] rocketImageViews, rocketImageViews2;
    @FXML
    private ImageView rocketImageView1, rocketImageView2, rocketImageView3,
            rocketImageView4, rocketImageView5, rocketImageView6, rocketImageView7, rocketImageView8, rocketImageView9, rocketImageView10,
            rocketImageView11, rocketImageView12, rocketImageView13, rocketImageView14, rocketImageView15, rocketImageView16, rocketImageView17,
            rocketImageView18, rocketImageView19, rocketImageView20, rocketImageView21, rocketImageView22, rocketImageView23, rocketImageView24,
            rocketImageView25, rocketImageView26, rocketImageView27, rocketImageView28, rocketImageView29, rocketImageView30, rocketImageView31,
            rocketImageView32, rocketImageView33, rocketImageView34, rocketImageView35, rocketImageView36, rocketImageView37, rocketImageView38,
            rocketImageView39, rocketImageView40, rocketImageView41, rocketImageView42, rocketImageView43, rocketImageView44, rocketImageView45,
            rocketMoveImageView1, rocketMoveImageView2, rocketMoveImageView3, rocketMoveImageView4, rocketMoveImageView5, rocketMoveImageView6,
            rocketMoveImageView7, rocketMoveImageView8, rocketMoveImageView9, rocketMoveImageView10, rocketMoveImageView11, rocketMoveImageView12,
            rocketMoveImageView13, rocketMoveImageView14, rocketMoveImageView15;
    @FXML
    private Button blackHole1, blackHole2, blackHole3, planet1, planet2, planet3, planet4, planet5, planet6, planet7,
            planet8, planet9, planet10, planet11, planet12, planet13, planet14, planet15, planet16, planet17, planet18,
            rocketPlaceButton, rocketMoveButton, rocketShowButton, showRocketBack, showRocketBack2, bigButton, mediumButton, smallButton,
            rocketMoveButton1,  rocketMoveButton2,  rocketMoveButton3,  rocketMoveButton4,  rocketMoveButton5,  rocketMoveButton6,
            rocketMoveButton7,  rocketMoveButton8,  rocketMoveButton9,  rocketMoveButton10,  rocketMoveButton11,  rocketMoveButton12,
            rocketMoveButton13,  rocketMoveButton14,  rocketMoveButton15, confirmButton, confirmButton1, confirmButton2,
            infoPlayer1Button, infoPlayer2Button, infoPlayer3Button, infoPlayer4Button, infoPlayer5Button,
            infoPlayer1Button2, infoPlayer2Button2, infoPlayer3Button2, infoPlayer4Button2, infoPlayer5Button2,
            player1TokenButton, player2TokenButton, player3TokenButton, player4TokenButton, player5TokenButton;
    @FXML
    private Label player1, player2, player3, player4, player5,
            playerToken1, playerToken2, playerToken3, playerToken4, playerToken5,
            player1BR, player1MR, player1SR, player1BigRockets, player1MediumRockets, player1SmallRockets,
            player2BR, player2MR, player2SR, player2BigRockets, player2MediumRockets, player2SmallRockets,
            player3BR, player3MR, player3SR, player3BigRockets, player3MediumRockets, player3SmallRockets,
            player4BR, player4MR, player4SR, player4BigRockets, player4MediumRockets, player4SmallRockets,
            player5BR, player5MR, player5SR, player5BigRockets, player5MediumRockets, player5SmallRockets,
            text1, text2, textBig, textMedium, textSmall, infoLabel, choosingLabel, playerNow, nowPlayingLabel,
            player1End, player2End, player3End, player4End, player5End, player3TokenEnd, player4TokenEnd, player5TokenEnd,
            player3BigRocketsEnd, player4BigRocketsEnd, player5BigRocketsEnd, player3MediumRocketsEnd, player4MediumRocketsEnd,
            player5MediumRocketsEnd, player3SmallRocketsEnd, player4SmallRocketsEnd, player5SmallRocketsEnd,
            player1TokenEndShow, player2TokenEndShow, player3TokenEndShow, player4TokenEndShow, player5TokenEndShow,
            player1BigRocketsEndShow, player2BigRocketsEndShow, player3BigRocketsEndShow, player4BigRocketsEndShow,
            player5BigRocketsEndShow, player1MediumRocketsEndShow, player2MediumRocketsEndShow, player3MediumRocketsEndShow,
            player4MediumRocketsEndShow, player5MediumRocketsEndShow, player1SmallRocketsEndShow, player2SmallRocketsEndShow,
            player3SmallRocketsEndShow, player4SmallRocketsEndShow, player5SmallRocketsEndShow, player3ScoreEnd,  player4ScoreEnd,
            player5ScoreEnd, player1ScoreShow,  player2ScoreShow, player3ScoreShow, player4ScoreShow, player5ScoreShow;
    @FXML
    private AnchorPane planetMenuAnchorPane, rocketsOnPlanetAnchorPane, rocketsOnPlanetAnchorPane2, rocketSizeAnchorPane, endingScreen;
    @FXML
    private ButtonBar buttonBarPlace, buttonBarMove;

    public void spaceCreation(int i, Player pl1, Player pl2, Player pl3, Player pl4, Player pl5) {
        playerIndex = rocketIndex = rocketMoveCounter = confirmCounter = 0;
        planetCanBeEnabled = true; tokenUsed = false;
        space = new Space(pl1, pl2, pl3, pl4, pl5, i);
        if (space.getCountOfPlayers() == 2) {
            space.addPlayer(space.getPlayersArray(), space.getP1());space.addPlayer(space.getPlayersArray(), space.getP2());
        } else if (space.getCountOfPlayers() == 3) {
            space.addPlayer(space.getPlayersArray(), space.getP1());space.addPlayer(space.getPlayersArray(), space.getP2());space.addPlayer(space.getPlayersArray(), space.getP3());
        } else if (space.getCountOfPlayers() == 4) {
            space.addPlayer(space.getPlayersArray(), space.getP1());space.addPlayer(space.getPlayersArray(), space.getP2());space.addPlayer(space.getPlayersArray(), space.getP3());space.addPlayer(space.getPlayersArray(), space.getP4());
        } else if (space.getCountOfPlayers() == 5) {
            space.addPlayer(space.getPlayersArray(), space.getP1());space.addPlayer(space.getPlayersArray(), space.getP2());space.addPlayer(space.getPlayersArray(), space.getP3());space.addPlayer(space.getPlayersArray(), space.getP4());space.addPlayer(space.getPlayersArray(), space.getP5());
        }
        rocketImageViews = new ImageView[space.getCountOfPlayers() * 9];
        rocketImageViews[0] = rocketImageView1;rocketImageViews[1] = rocketImageView2;rocketImageViews[2] = rocketImageView3;rocketImageViews[3] = rocketImageView4;rocketImageViews[4] = rocketImageView5;rocketImageViews[5] = rocketImageView6;rocketImageViews[6] = rocketImageView7;rocketImageViews[7] = rocketImageView8;rocketImageViews[8] = rocketImageView9;rocketImageViews[9] = rocketImageView10;rocketImageViews[10] = rocketImageView11;rocketImageViews[11] = rocketImageView12;rocketImageViews[12] = rocketImageView13;rocketImageViews[13] = rocketImageView14;rocketImageViews[14] = rocketImageView15;rocketImageViews[15] = rocketImageView16;rocketImageViews[16] = rocketImageView17;rocketImageViews[17] = rocketImageView18;
        if (space.getCountOfPlayers() == 3) {
            rocketImageViews[18] = rocketImageView19;rocketImageViews[19] = rocketImageView20;rocketImageViews[20] = rocketImageView21;rocketImageViews[21] = rocketImageView22;rocketImageViews[22] = rocketImageView23;rocketImageViews[23] = rocketImageView24;rocketImageViews[24] = rocketImageView25;rocketImageViews[25] = rocketImageView26;rocketImageViews[26] = rocketImageView27;
        } else if (space.getCountOfPlayers() == 4) {
            rocketImageViews[18] = rocketImageView19;rocketImageViews[19] = rocketImageView20;rocketImageViews[20] = rocketImageView21;rocketImageViews[21] = rocketImageView22;rocketImageViews[22] = rocketImageView23;rocketImageViews[23] = rocketImageView24;rocketImageViews[24] = rocketImageView25;rocketImageViews[25] = rocketImageView26;rocketImageViews[26] = rocketImageView27;rocketImageViews[27] = rocketImageView28;rocketImageViews[28] = rocketImageView29;rocketImageViews[29] = rocketImageView30;rocketImageViews[30] = rocketImageView31;rocketImageViews[31] = rocketImageView32;rocketImageViews[32] = rocketImageView33;rocketImageViews[33] = rocketImageView34;rocketImageViews[34] = rocketImageView35;rocketImageViews[35] = rocketImageView36;
        } else if (space.getCountOfPlayers() == 5){
            rocketImageViews[18] = rocketImageView19;rocketImageViews[19] = rocketImageView20;rocketImageViews[20] = rocketImageView21;rocketImageViews[21] = rocketImageView22;rocketImageViews[22] = rocketImageView23;rocketImageViews[23] = rocketImageView24;rocketImageViews[24] = rocketImageView25;rocketImageViews[25] = rocketImageView26;rocketImageViews[26] = rocketImageView27;rocketImageViews[27] = rocketImageView28;rocketImageViews[28] = rocketImageView29;rocketImageViews[29] = rocketImageView30;rocketImageViews[30] = rocketImageView31;rocketImageViews[31] = rocketImageView32;rocketImageViews[32] = rocketImageView33;rocketImageViews[33] = rocketImageView34;rocketImageViews[34] = rocketImageView35;rocketImageViews[35] = rocketImageView36;rocketImageViews[36] = rocketImageView37;rocketImageViews[37] = rocketImageView38;rocketImageViews[38] = rocketImageView39;rocketImageViews[39] = rocketImageView40;rocketImageViews[40] = rocketImageView41;rocketImageViews[41] = rocketImageView42;rocketImageViews[42] = rocketImageView43;rocketImageViews[43] = rocketImageView44;rocketImageViews[44] = rocketImageView45;
        }
     rocketImageViews2 = new ImageView[space.getCountOfPlayers() * 3];
     rocketImageViews2[0] = rocketMoveImageView1;rocketImageViews2[1] = rocketMoveImageView2;rocketImageViews2[2] = rocketMoveImageView3;rocketImageViews2[3] = rocketMoveImageView4;rocketImageViews2[4] = rocketMoveImageView5;rocketImageViews2[5] = rocketMoveImageView6;
        if (space.getCountOfPlayers() == 3) {
         rocketImageViews2[6] = rocketMoveImageView7;rocketImageViews2[7] = rocketMoveImageView8;rocketImageViews2[8] = rocketMoveImageView9;
        } else if (space.getCountOfPlayers() == 4) {
         rocketImageViews2[6] = rocketMoveImageView7;rocketImageViews2[7] = rocketMoveImageView8;rocketImageViews2[8] = rocketMoveImageView9;rocketImageViews2[9] = rocketMoveImageView10;rocketImageViews2[10] = rocketMoveImageView11;rocketImageViews2[11] = rocketMoveImageView12;
        } else if (space.getCountOfPlayers() == 5) {
         rocketImageViews2[6] = rocketMoveImageView7;rocketImageViews2[7] = rocketMoveImageView8;rocketImageViews2[8] = rocketMoveImageView9;rocketImageViews2[9] = rocketMoveImageView10;rocketImageViews2[10] = rocketMoveImageView11;rocketImageViews2[11] = rocketMoveImageView12;rocketImageViews2[12] = rocketMoveImageView13;rocketImageViews2[13] = rocketMoveImageView14;rocketImageViews2[14] = rocketMoveImageView15;
        }
    }
    public void coloredText1(String clr){
        if(clr == "red") {player1.setStyle("-fx-text-fill: red");}
        else if (clr == "blue"){player1.setStyle("-fx-text-fill: blue");}
        else if (clr == "green"){player1.setStyle("-fx-text-fill: #1eff00");}
        else if (clr == "gray"){player1.setStyle("-fx-text-fill: #6e6e6e");}
        else if (clr == "white"){player1.setStyle("-fx-text-fill: white");}
    }
    public void coloredText2(String clr){
        if(clr == "red") {player2.setStyle("-fx-text-fill: red");}
        else if (clr == "blue"){player2.setStyle("-fx-text-fill: blue");}
        else if (clr == "green"){player2.setStyle("-fx-text-fill: #1eff00");}
        else if (clr == "gray"){player2.setStyle("-fx-text-fill: #6e6e6e");}
        else if (clr == "white"){player2.setStyle("-fx-text-fill: white");}
    }
    public void coloredText3(String clr){
        if(clr == "red") {player3.setStyle("-fx-text-fill: red");}
        else if (clr == "blue"){player3.setStyle("-fx-text-fill: blue");}
        else if (clr == "green"){player3.setStyle("-fx-text-fill: #1eff00");}
        else if (clr == "gray"){player3.setStyle("-fx-text-fill: #6e6e6e");}
        else if (clr == "white"){player3.setStyle("-fx-text-fill: white");}
    }
    public void coloredText4(String clr){
        if(clr == "red") {player4.setStyle("-fx-text-fill: red");}
        else if (clr == "blue"){player4.setStyle("-fx-text-fill: blue");}
        else if (clr == "green") {player4.setStyle("-fx-text-fill: #1eff00");}
        else if (clr == "gray"){player4.setStyle("-fx-text-fill: #6e6e6e");}
        else if (clr == "white"){player4.setStyle("-fx-text-fill: white");}
    }
    public void coloredText5(String clr){
        if(clr == "red") {player5.setStyle("-fx-text-fill: red");}
        else if (clr == "blue"){player5.setStyle("-fx-text-fill: blue");}
        else if (clr == "green"){player5.setStyle("-fx-text-fill: #1eff00");}
        else if (clr == "gray"){player5.setStyle("-fx-text-fill: #6e6e6e");}
        else if (clr == "white"){player5.setStyle("-fx-text-fill: white");}
    }
    public void coloredTextInfo(String clr){
        if(clr == "red") {infoLabel.setStyle("-fx-text-fill: red");}
        else if (clr == "blue"){infoLabel.setStyle("-fx-text-fill: blue");}
        else if (clr == "green"){infoLabel.setStyle("-fx-text-fill: #1eff00");}
        else if (clr == "gray"){infoLabel.setStyle("-fx-text-fill: #6e6e6e");}
        else if (clr == "white"){infoLabel.setStyle("-fx-text-fill: white");}
    }
    public void coloredTextPlayerNow(String clr){
        if(clr == "red") {playerNow.setStyle("-fx-text-fill: red");}
        else if (clr == "blue"){playerNow.setStyle("-fx-text-fill: blue");}
        else if (clr == "green"){playerNow.setStyle("-fx-text-fill: #1eff00");}
        else if (clr == "gray"){playerNow.setStyle("-fx-text-fill: #6e6e6e");}
        else if (clr == "white"){playerNow.setStyle("-fx-text-fill: white");}
    }
    public void hidePlayerLabel3(){
        player3.setVisible(false);
        infoPlayer3Button.setVisible(false);
        player3TokenButton.setVisible(false);
    }
    public void hidePlayerLabel5(){
        player5.setVisible(false);
        infoPlayer5Button.setVisible(false);
        player5TokenButton.setVisible(false);
    }
    @FXML
    public void showPlayer1info() {
        infoPlayer1Button.setVisible(false);
        infoPlayer1Button2.setVisible(true);
        playerToken1.setVisible(true);
        player1BR.setVisible(true);
        player1MR.setVisible(true);
        player1SR.setVisible(true);
        player1BigRockets.setVisible(true);
        player1MediumRockets.setVisible(true);
        player1SmallRockets.setVisible(true);
        player1TokenButton.setVisible(false);
    }
    @FXML
    public void showPlayer2info() {
        infoPlayer2Button.setVisible(false);
        infoPlayer2Button2.setVisible(true);
        playerToken2.setVisible(true);
        player2BR.setVisible(true);
        player2MR.setVisible(true);
        player2SR.setVisible(true);
        player2BigRockets.setVisible(true);
        player2MediumRockets.setVisible(true);
        player2SmallRockets.setVisible(true);
        player2TokenButton.setVisible(false);
    }
    @FXML
    public void showPlayer3info() {
        infoPlayer3Button.setVisible(false);
        infoPlayer3Button2.setVisible(true);
        playerToken3.setVisible(true);
        player3BR.setVisible(true);
        player3MR.setVisible(true);
        player3SR.setVisible(true);
        player3BigRockets.setVisible(true);
        player3MediumRockets.setVisible(true);
        player3SmallRockets.setVisible(true);
        player3TokenButton.setVisible(false);
    }
    @FXML
    public void showPlayer4info() {
        infoPlayer4Button.setVisible(false);
        infoPlayer4Button2.setVisible(true);
        playerToken4.setVisible(true);
        player4BR.setVisible(true);
        player4MR.setVisible(true);
        player4SR.setVisible(true);
        player4BigRockets.setVisible(true);
        player4MediumRockets.setVisible(true);
        player4SmallRockets.setVisible(true);
        player4TokenButton.setVisible(false);
    }
    @FXML
    public void showPlayer5info() {
        infoPlayer5Button.setVisible(false);
        infoPlayer5Button2.setVisible(true);
        playerToken5.setVisible(true);
        player5BR.setVisible(true);
        player5MR.setVisible(true);
        player5SR.setVisible(true);
        player5BigRockets.setVisible(true);
        player5MediumRockets.setVisible(true);
        player5SmallRockets.setVisible(true);
        player5TokenButton.setVisible(false);
    }

    @FXML
    public void hidePlayer1info() {
        infoPlayer1Button.setVisible(true);
        infoPlayer1Button2.setVisible(false);
        playerToken1.setVisible(false);
        player1BR.setVisible(false);
        player1MR.setVisible(false);
        player1SR.setVisible(false);
        player1BigRockets.setVisible(false);
        player1MediumRockets.setVisible(false);
        player1SmallRockets.setVisible(false);
        if (rocketIndex == space.getCountOfPlayers()*3) {
            player1TokenButton.setVisible(true);
        }
    }
    @FXML
    public void hidePlayer2info() {
        infoPlayer2Button.setVisible(true);
        infoPlayer2Button2.setVisible(false);
        playerToken2.setVisible(false);
        player2BR.setVisible(false);
        player2MR.setVisible(false);
        player2SR.setVisible(false);
        player2BigRockets.setVisible(false);
        player2MediumRockets.setVisible(false);
        player2SmallRockets.setVisible(false);
        if (rocketIndex == space.getCountOfPlayers()*3) {
            player2TokenButton.setVisible(true);
        }
    }
    @FXML
    public void hidePlayer3info() {
        infoPlayer3Button.setVisible(true);
        infoPlayer3Button2.setVisible(false);
        playerToken3.setVisible(false);
        player3BR.setVisible(false);
        player3MR.setVisible(false);
        player3SR.setVisible(false);
        player3BigRockets.setVisible(false);
        player3MediumRockets.setVisible(false);
        player3SmallRockets.setVisible(false);
        if (rocketIndex == space.getCountOfPlayers()*3) {
            player3TokenButton.setVisible(true);
        }
    }
    @FXML
    public void hidePlayer4info() {
        infoPlayer4Button.setVisible(true);
        infoPlayer4Button2.setVisible(false);
        playerToken4.setVisible(false);
        player4BR.setVisible(false);
        player4MR.setVisible(false);
        player4SR.setVisible(false);
        player4BigRockets.setVisible(false);
        player4MediumRockets.setVisible(false);
        player4SmallRockets.setVisible(false);
        if (rocketIndex == space.getCountOfPlayers()*3) {
            player4TokenButton.setVisible(true);
        }
    }
    @FXML
    public void hidePlayer5info() {
        infoPlayer5Button.setVisible(true);
        infoPlayer5Button2.setVisible(false);
        playerToken5.setVisible(false);
        player5BR.setVisible(false);
        player5MR.setVisible(false);
        player5SR.setVisible(false);
        player5BigRockets.setVisible(false);
        player5MediumRockets.setVisible(false);
        player5SmallRockets.setVisible(false);
        if (rocketIndex == space.getCountOfPlayers()*3) {
            player5TokenButton.setVisible(true);
        }
    }
    @FXML
    public void planetMenu(ActionEvent e){
        infoLabel.setVisible(false);
        planetMenuAnchorPane.setVisible(true);
        rocketSizeAnchorPane.setVisible(false);
        mainEvent = e;
                    if(mainEvent.getSource() == planet1){
                planet1.setDisable(true);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers() == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            } else if(mainEvent.getSource() == planet2){
                planet1.setDisable(false);planet2.setDisable(true);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            }else if(mainEvent.getSource() == planet3){
                planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(true);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            } else if(mainEvent.getSource() == planet4){
                planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(true);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            }else if(mainEvent.getSource() == planet5){
                planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(true);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            } else if(mainEvent.getSource() == planet6){
                planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(true);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            }else if(mainEvent.getSource() == planet7){
                planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(true);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            } else if(mainEvent.getSource() == planet8){
                planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(true);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            }else if(mainEvent.getSource() == planet9){planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(true);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            } else if(mainEvent.getSource() == planet10){planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(true);planet11.setDisable(false);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            }else if(mainEvent.getSource() == planet11){planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(true);planet12.setDisable(false);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            } else if(mainEvent.getSource() == planet12){planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(true);
                if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                    planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                }
            }  else if(space.getCountOfPlayers()  == 4 || space.getCountOfPlayers()  == 5) {
                if(mainEvent.getSource() == planet13) {
                    planet1.setDisable(false); planet2.setDisable(false); planet3.setDisable(false); planet4.setDisable(false);planet5.setDisable(false); planet6.setDisable(false); planet7.setDisable(false); planet8.setDisable(false);planet9.setDisable(false); planet10.setDisable(false); planet11.setDisable(false); planet12.setDisable(false);planet13.setDisable(true); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                } else if(mainEvent.getSource() == planet14) {
                    planet1.setDisable(false); planet2.setDisable(false); planet3.setDisable(false); planet4.setDisable(false);planet5.setDisable(false); planet6.setDisable(false); planet7.setDisable(false); planet8.setDisable(false);planet9.setDisable(false); planet10.setDisable(false); planet11.setDisable(false); planet12.setDisable(false);planet13.setDisable(false); planet14.setDisable(true); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                } else if(mainEvent.getSource() == planet15) {
                    planet1.setDisable(false); planet2.setDisable(false); planet3.setDisable(false); planet4.setDisable(false);planet5.setDisable(false); planet6.setDisable(false); planet7.setDisable(false); planet8.setDisable(false);planet9.setDisable(false); planet10.setDisable(false); planet11.setDisable(false); planet12.setDisable(false);planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(true); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(false);
                } else if(mainEvent.getSource() == planet16) {
                    planet1.setDisable(false); planet2.setDisable(false); planet3.setDisable(false); planet4.setDisable(false);planet5.setDisable(false); planet6.setDisable(false); planet7.setDisable(false); planet8.setDisable(false);planet9.setDisable(false); planet10.setDisable(false); planet11.setDisable(false); planet12.setDisable(false);planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(true);planet17.setDisable(false); planet18.setDisable(false);
                } else if(mainEvent.getSource() == planet17) {
                    planet1.setDisable(false); planet2.setDisable(false); planet3.setDisable(false); planet4.setDisable(false);planet5.setDisable(false); planet6.setDisable(false); planet7.setDisable(false); planet8.setDisable(false);planet9.setDisable(false); planet10.setDisable(false); planet11.setDisable(false); planet12.setDisable(false);planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(true); planet18.setDisable(false);
                } else if(mainEvent.getSource() == planet18) {
                    planet1.setDisable(false); planet2.setDisable(false); planet3.setDisable(false); planet4.setDisable(false);planet5.setDisable(false); planet6.setDisable(false); planet7.setDisable(false); planet8.setDisable(false);planet9.setDisable(false); planet10.setDisable(false); planet11.setDisable(false); planet12.setDisable(false);planet13.setDisable(false); planet14.setDisable(false); planet15.setDisable(false); planet16.setDisable(false);planet17.setDisable(false); planet18.setDisable(true);
                }
        }
    }

    @FXML
    public void placeRocket() {
        planetMenuAnchorPane.setVisible(false);
        rocketSizeAnchorPane.setVisible(true);
    }
    @FXML
    public void chooseRocketSize(ActionEvent e){
        rocketSizeAnchorPane.setVisible(false);
        if (e.getSource() == bigButton){
            placeRocketMethod("big");
        }
        else if (e.getSource() == mediumButton){
            placeRocketMethod("medium");
        }
        else if (e.getSource() == smallButton){
            placeRocketMethod("small");
        }
    }

    public void placeRocketMethod(String size) {
        if (mainEvent.getSource() == planet1) {
            planet1.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {
                playerIndex = 0;
            }
            for (int i = 0; i < space.getPln1().getRockets().length; i++) {
                if (space.getPln1().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln1(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setText("You placed rocket!");
            infoLabel.setStyle("-fx-font-size: 30");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln1().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet2) {
            planet2.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln2().getRockets().length; i++) {
                if (space.getPln2().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln2(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln2().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet3) {
            planet3.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln3().getRockets().length; i++) {
                if (space.getPln3().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln3(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln3().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet4) {
            planet4.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln4().getRockets().length; i++) {
                if (space.getPln4().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln4(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln4().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet5) {
            planet5.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln5().getRockets().length; i++) {
                if (space.getPln5().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln5(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln5().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet6) {
            planet6.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln6().getRockets().length; i++) {
                if (space.getPln6().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln6(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln6().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet7) {
            planet7.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln7().getRockets().length; i++) {
                if (space.getPln7().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln7(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln7().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet8) {
            planet8.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln8().getRockets().length; i++) {
                if (space.getPln8().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln8(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln8().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet9) {
            planet9.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln9().getRockets().length; i++) {
                if (space.getPln9().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln9(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln9().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet10) {
            planet10.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln10().getRockets().length; i++) {
                if (space.getPln10().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln10(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln10().setSizeCounterPlus(size);
        } else if (mainEvent.getSource() == planet11) {
            planet11.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln11().getRockets().length; i++) {
                if (space.getPln11().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln11(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln11().setSizeCounterPlus(size);
            if (tokenUsed){ playerIndex = playerIndexHelper; tokenUsed = false;}
        } else if (mainEvent.getSource() == planet12) {
            planet12.setDisable(false);
            if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
            for (int i = 0; i < space.getPln12().getRockets().length; i++) {
                if (space.getPln12().getRockets()[i].getSize() == size) {
                    infoLabel.setText("Cannot place on this planet rocket of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;
                }
            }
            if (rocketSizeControl(size)) {
                infoLabel.setText("You placed maximal amount rockets of this size!");
                infoLabel.setStyle("-fx-font-size: 22");
                infoLabel.setVisible(true);
                    return;}
            space.placeRocket(space.getPln12(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
            infoLabel.setStyle("-fx-font-size: 30");
            infoLabel.setText("You placed rocket!");
            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
            infoLabel.setVisible(true);
            if(playerIndex+1 == space.getCountOfPlayers()) {
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
            }
            else {
                coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                if (playerIndex+1 == 1){
                    playerNow.setText("PLAYER2");
                }
                else if (playerIndex+1 == 2){
                    playerNow.setText("PLAYER3");
                }
                else if (playerIndex+1 == 3){
                    playerNow.setText("PLAYER4");
                }
                else if (playerIndex+1 == 4){
                    playerNow.setText("PLAYER5");
                }
            }
            rocketIndex++; playerIndex++; space.getPln12().setSizeCounterPlus(size);
        } else if (space.getCountOfPlayers() == 4 || space.getCountOfPlayers() == 5) {
            if (mainEvent.getSource() == planet13) {
                planet13.setDisable(false);
                if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
                for (int i = 0; i < space.getPln13().getRockets().length; i++) {
                    if (space.getPln13().getRockets()[i].getSize() == size) {
                        infoLabel.setText("Cannot place on this planet rocket of this size!");
                        infoLabel.setStyle("-fx-font-size: 22");
                        infoLabel.setVisible(true);
                        return;
                    }
                }
                if (rocketSizeControl(size)) {
                    infoLabel.setText("You placed maximal amount rockets of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;}
                space.placeRocket(space.getPln13(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
                infoLabel.setStyle("-fx-font-size: 30");
                infoLabel.setText("You placed rocket!");
                coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
                infoLabel.setVisible(true);
                if(playerIndex+1 == space.getCountOfPlayers()) {
                    coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                    playerNow.setText("PLAYER1");
                }
                else {
                    coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                    if (playerIndex+1 == 1){
                        playerNow.setText("PLAYER2");
                    }
                    else if (playerIndex+1 == 2){
                        playerNow.setText("PLAYER3");
                    }
                    else if (playerIndex+1 == 3){
                        playerNow.setText("PLAYER4");
                    }
                    else if (playerIndex+1 == 4){
                        playerNow.setText("PLAYER5");
                    }
                }
                rocketIndex++; playerIndex++; space.getPln13().setSizeCounterPlus(size);
            } else if (mainEvent.getSource() == planet14) {
                planet14.setDisable(false);
                if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
                for (int i = 0; i < space.getPln14().getRockets().length; i++) {
                    if (space.getPln14().getRockets()[i].getSize() == size) {
                        infoLabel.setText("Cannot place on this planet rocket of this size!");
                        infoLabel.setStyle("-fx-font-size: 22");
                        infoLabel.setVisible(true);
                        return;
                    }
                }
                if (rocketSizeControl(size)) {
                    infoLabel.setText("You placed maximal amount rockets of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;}
                space.placeRocket(space.getPln14(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
                infoLabel.setStyle("-fx-font-size: 30");
                infoLabel.setText("You placed rocket!");
                coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
                infoLabel.setVisible(true);
                if(playerIndex+1 == space.getCountOfPlayers()) {
                    coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                    playerNow.setText("PLAYER1");
                }
                else {
                    coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                    if (playerIndex+1 == 1){
                        playerNow.setText("PLAYER2");
                    }
                    else if (playerIndex+1 == 2){
                        playerNow.setText("PLAYER3");
                    }
                    else if (playerIndex+1 == 3){
                        playerNow.setText("PLAYER4");
                    }
                    else if (playerIndex+1 == 4){
                        playerNow.setText("PLAYER5");
                    }
                }
                rocketIndex++; playerIndex++; space.getPln14().setSizeCounterPlus(size);
            } else if (mainEvent.getSource() == planet15) {
                planet15.setDisable(false);
                if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
                for (int i = 0; i < space.getPln15().getRockets().length; i++) {
                    if (space.getPln15().getRockets()[i].getSize() == size) {
                        infoLabel.setText("Cannot place on this planet rocket of this size!");
                        infoLabel.setStyle("-fx-font-size: 22");
                        infoLabel.setVisible(true);
                        return;
                    }
                }
                if (rocketSizeControl(size)) {
                    infoLabel.setText("You placed maximal amount rockets of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;}
                space.placeRocket(space.getPln15(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
                infoLabel.setStyle("-fx-font-size: 30");
                infoLabel.setText("You placed rocket!");
                coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
                infoLabel.setVisible(true);
                if(playerIndex+1 == space.getCountOfPlayers()) {
                    coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                    playerNow.setText("PLAYER1");
                }
                else {
                    coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                    if (playerIndex+1 == 1){
                        playerNow.setText("PLAYER2");
                    }
                    else if (playerIndex+1 == 2){
                        playerNow.setText("PLAYER3");
                    }
                    else if (playerIndex+1 == 3){
                        playerNow.setText("PLAYER4");
                    }
                    else if (playerIndex+1 == 4){
                        playerNow.setText("PLAYER5");
                    }
                }
                rocketIndex++; playerIndex++; space.getPln15().setSizeCounterPlus(size);
            } else if (mainEvent.getSource() == planet16) {
                planet16.setDisable(false);
                if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
                for (int i = 0; i < space.getPln16().getRockets().length; i++) {
                    if (space.getPln16().getRockets()[i].getSize() == size) {
                        infoLabel.setText("Cannot place on this planet rocket of this size!");
                        infoLabel.setStyle("-fx-font-size: 22");
                        infoLabel.setVisible(true);
                        return;
                    }
                }
                if (rocketSizeControl(size)) {
                    infoLabel.setText("You placed maximal amount rockets of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;}
                space.placeRocket(space.getPln16(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
                infoLabel.setStyle("-fx-font-size: 30");
                infoLabel.setText("You placed rocket!");
                coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
                infoLabel.setVisible(true);
                if(playerIndex+1 == space.getCountOfPlayers()) {
                    coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                    playerNow.setText("PLAYER1");
                }
                else {
                    coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                    if (playerIndex+1 == 1){
                        playerNow.setText("PLAYER2");
                    }
                    else if (playerIndex+1 == 2){
                        playerNow.setText("PLAYER3");
                    }
                    else if (playerIndex+1 == 3){
                        playerNow.setText("PLAYER4");
                    }
                    else if (playerIndex+1 == 4){
                        playerNow.setText("PLAYER5");
                    }
                }
                rocketIndex++; playerIndex++; space.getPln16().setSizeCounterPlus(size);
            } else if (mainEvent.getSource() == planet17) {
                planet17.setDisable(false);
                if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
                for (int i = 0; i < space.getPln17().getRockets().length; i++) {
                    if (space.getPln17().getRockets()[i].getSize() == size) {
                        infoLabel.setText("Cannot place on this planet rocket of this size!");
                        infoLabel.setStyle("-fx-font-size: 22");
                        infoLabel.setVisible(true);
                        return;
                    }
                }
                if (rocketSizeControl(size)) {
                    infoLabel.setText("You placed maximal amount rockets of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;}
                space.placeRocket(space.getPln17(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
                infoLabel.setStyle("-fx-font-size: 30");
                infoLabel.setText("You placed rocket!");
                coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
                infoLabel.setVisible(true);
                if(playerIndex+1 == space.getCountOfPlayers()) {
                    coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                    playerNow.setText("PLAYER1");
                }
                else {
                    coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                    if (playerIndex+1 == 1){
                        playerNow.setText("PLAYER2");
                    }
                    else if (playerIndex+1 == 2){
                        playerNow.setText("PLAYER3");
                    }
                    else if (playerIndex+1 == 3){
                        playerNow.setText("PLAYER4");
                    }
                    else if (playerIndex+1 == 4){
                        playerNow.setText("PLAYER5");
                    }
                }
                rocketIndex++; playerIndex++; space.getPln17().setSizeCounterPlus(size);
            } else if (mainEvent.getSource() == planet18) {
                planet18.setDisable(false);
                if (playerIndex == space.getCountOfPlayers()) {playerIndex = 0;}
                for (int i = 0; i < space.getPln18().getRockets().length; i++) {
                    if (space.getPln18().getRockets()[i].getSize() == size) {
                        infoLabel.setText("Cannot place on this planet rocket of this size!");
                        infoLabel.setStyle("-fx-font-size: 22");
                        infoLabel.setVisible(true);
                        return;
                    }
                }
                if (rocketSizeControl(size)) {
                    infoLabel.setText("You placed maximal amount rockets of this size!");
                    infoLabel.setStyle("-fx-font-size: 22");
                    infoLabel.setVisible(true);
                    return;}
                space.placeRocket(space.getPln18(), new Rocket(space.getPlayersArray()[playerIndex].getColor(), size));
                infoLabel.setText("You placed rocket!");
                infoLabel.setStyle("-fx-font-size: 30");
                coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
                infoLabel.setVisible(true);
                if(playerIndex+1 == space.getCountOfPlayers()) {
                    coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                    playerNow.setText("PLAYER1");
                }
                else {
                    coloredTextPlayerNow(space.getPlayersArray()[playerIndex+1].getColor());
                    if (playerIndex+1 == 1){
                        playerNow.setText("PLAYER2");
                    }
                    else if (playerIndex+1 == 2){
                        playerNow.setText("PLAYER3");
                    }
                    else if (playerIndex+1 == 3){
                        playerNow.setText("PLAYER4");
                    }
                    else if (playerIndex+1 == 4){
                        playerNow.setText("PLAYER5");
                    }
                }
                rocketIndex++; playerIndex++; space.getPln18().setSizeCounterPlus(size);
            }
        }
        if (rocketIndex == space.getCountOfPlayers()*3){
            buttonBarPlace.setVisible(false);
            buttonBarMove.setVisible(true);
            infoLabel.setText("All rockets placed, LET'S PLAY!");
            infoLabel.setVisible(true);
            rocketsToMoveComplete = new Rocket[0];
            playerIndex = 0;
            player1TokenButton.setVisible(true);
            infoPlayer1Button.setVisible(true);
            infoPlayer1Button2.setVisible(false);
            playerToken1.setVisible(false);
            player1BR.setVisible(false);
            player1MR.setVisible(false);
            player1SR.setVisible(false);
            player1BigRockets.setVisible(false);
            player1MediumRockets.setVisible(false);
            player1SmallRockets.setVisible(false);
            player2TokenButton.setVisible(true);
            infoPlayer2Button.setVisible(true);
            infoPlayer2Button2.setVisible(false);
            playerToken2.setVisible(false);
            player2BR.setVisible(false);
            player2MR.setVisible(false);
            player2SR.setVisible(false);
            player2BigRockets.setVisible(false);
            player2MediumRockets.setVisible(false);
            player2SmallRockets.setVisible(false);
            if (space.getCountOfPlayers() >= 3) {
                player3TokenButton.setVisible(true);
                infoPlayer3Button.setVisible(true);
                infoPlayer3Button2.setVisible(false);
                playerToken3.setVisible(false);
                player3BR.setVisible(false);
                player3MR.setVisible(false);
                player3SR.setVisible(false);
                player3BigRockets.setVisible(false);
                player3MediumRockets.setVisible(false);
                player3SmallRockets.setVisible(false);
                if (space.getCountOfPlayers() > 3) {
                    player4TokenButton.setVisible(true);
                    infoPlayer4Button.setVisible(true);
                    infoPlayer4Button2.setVisible(false);
                    playerToken4.setVisible(false);
                    player4BR.setVisible(false);
                    player4MR.setVisible(false);
                    player4SR.setVisible(false);
                    player4BigRockets.setVisible(false);
                    player4MediumRockets.setVisible(false);
                    player4SmallRockets.setVisible(false);
                    if (space.getCountOfPlayers() == 5) {
                        player5TokenButton.setVisible(true);
                        infoPlayer5Button.setVisible(true);
                        infoPlayer5Button2.setVisible(false);
                        playerToken5.setVisible(false);
                        player5BR.setVisible(false);
                        player5MR.setVisible(false);
                        player5SR.setVisible(false);
                        player5BigRockets.setVisible(false);
                        player5MediumRockets.setVisible(false);
                        player5SmallRockets.setVisible(false);
                    }
                }
            }
        }
    }
    @FXML
    public void showRockets() {
        planetMenuAnchorPane.setVisible(false);
        playerNow.setVisible(false);
        nowPlayingLabel.setVisible(false);
        rocketsOnPlanetAnchorPane.setVisible(true);
        showRocketBack.setVisible(true);
        if (mainEvent.getSource() == planet1) {
            planet1.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln1().getRockets().length != 0) {
                for (int i = 0; i < space.getPln1().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln1().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet2) {
            planet2.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln2().getRockets().length != 0) {
                for (int i = 0; i < space.getPln2().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln2().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet3) {
            planet3.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln3().getRockets().length != 0) {
                for (int i = 0; i < space.getPln3().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln3().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet4) {
            planet4.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln4().getRockets().length != 0) {
                for (int i = 0; i < space.getPln4().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln4().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet5) {
            planet5.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln5().getRockets().length != 0) {
                for (int i = 0; i < space.getPln5().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln5().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet6) {
            planet6.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln6().getRockets().length != 0) {
                for (int i = 0; i < space.getPln6().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln6().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet7) {
            planet7.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln7().getRockets().length != 0) {
                for (int i = 0; i < space.getPln7().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln7().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet8) {
            planet8.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln8().getRockets().length != 0) {
                for (int i = 0; i < space.getPln8().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln8().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet9) {
            planet9.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln9().getRockets().length != 0) {
                for (int i = 0; i < space.getPln9().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln9().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet10) {
            planet10.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln10().getRockets().length != 0) {
                for (int i = 0; i < space.getPln10().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln10().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet11) {
            planet11.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln11().getRockets().length != 0) {
                for (int i = 0; i < space.getPln11().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln11().getRockets()[i].getRocImg());
                }
            }
        } else if (mainEvent.getSource() == planet12) {
            planet12.setDisable(false);
            for (int i = 0; i < rocketImageViews.length; i++) {
                rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if(space.getPln12().getRockets().length != 0) {
                for (int i = 0; i < space.getPln12().getRockets().length; i++) {
                    rocketImageViews[i].setImage(space.getPln12().getRockets()[i].getRocImg());
                }
            }
        } else if (space.getCountOfPlayers() == 4 || space.getCountOfPlayers() == 5) {
            if (mainEvent.getSource() == planet13) {
                planet13.setDisable(false);
                for (int i = 0; i < rocketImageViews.length; i++) {
                    rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                }
                if(space.getPln13().getRockets().length != 0) {
                    for (int i = 0; i < space.getPln13().getRockets().length; i++) {
                        rocketImageViews[i].setImage(space.getPln13().getRockets()[i].getRocImg());
                    }
                }
            } else if (mainEvent.getSource() == planet14) {
                planet14.setDisable(false);
                for (int i = 0; i < rocketImageViews.length; i++) {
                    rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                }
                if(space.getPln14().getRockets().length != 0) {
                    for (int i = 0; i < space.getPln14().getRockets().length; i++) {
                        rocketImageViews[i].setImage(space.getPln14().getRockets()[i].getRocImg());
                    }
                }
            } else if (mainEvent.getSource() == planet15) {
                planet15.setDisable(false);
                for (int i = 0; i < rocketImageViews.length; i++) {
                    rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                }
                if(space.getPln15().getRockets().length != 0) {
                    for (int i = 0; i < space.getPln15().getRockets().length; i++) {
                        rocketImageViews[i].setImage(space.getPln15().getRockets()[i].getRocImg());
                    }
                }
            } else if (mainEvent.getSource() == planet16) {
                planet16.setDisable(false);
                for (int i = 0; i < rocketImageViews.length; i++) {
                    rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                }
                if(space.getPln16().getRockets().length != 0) {
                    for (int i = 0; i < space.getPln16().getRockets().length; i++) {
                        rocketImageViews[i].setImage(space.getPln16().getRockets()[i].getRocImg());
                    }
                }
            } else if (mainEvent.getSource() == planet17) {
                planet17.setDisable(false);
                for (int i = 0; i < rocketImageViews.length; i++) {
                    rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                }
                if(space.getPln17().getRockets().length != 0) {
                    for (int i = 0; i < space.getPln17().getRockets().length; i++) {
                        rocketImageViews[i].setImage(space.getPln17().getRockets()[i].getRocImg());
                    }
                }
            } else if (mainEvent.getSource() == planet18) {
                planet18.setDisable(false);
                for (int i = 0; i < rocketImageViews.length; i++) {
                    rocketImageViews[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                }
                if(space.getPln18().getRockets().length != 0) {
                    for (int i = 0; i < space.getPln18().getRockets().length; i++) {
                        rocketImageViews[i].setImage(space.getPln18().getRockets()[i].getRocImg());
                    }
                }
            }
        }
    }
    public boolean rocketSizeControl(String size) {
        String stringCounter;
        if (size == "big") {
            if (space.getPlayersArray()[playerIndex].getBigSizeCounter() == 1) {
                return true;
            } else {
                space.getPlayersArray()[playerIndex].setSizeCounterPlus(size);
                stringCounter = Integer.toString(space.getPlayersArray()[playerIndex].getBigSizeCounter());
                if (playerIndex == 0) {player1BR.setText(stringCounter);}
                else if (playerIndex == 1) {player2BR.setText(stringCounter);}
                else if (playerIndex == 2) {player3BR.setText(stringCounter);}
                else if (playerIndex == 3) {player4BR.setText(stringCounter);}
                else if (playerIndex == 4) {player5BR.setText(stringCounter);}
                return false;
            }
        } else if (size == "medium") {
            if (space.getPlayersArray()[playerIndex].getMediumSizeCounter() == 1) {
                return true;
            } else {
                space.getPlayersArray()[playerIndex].setSizeCounterPlus(size);
                stringCounter = Integer.toString(space.getPlayersArray()[playerIndex].getMediumSizeCounter());
                if (playerIndex == 0) {player1MR.setText(stringCounter);}
                else if (playerIndex == 1) {player2MR.setText(stringCounter);}
                else if (playerIndex == 2) {player3MR.setText(stringCounter);}
                else if (playerIndex == 3) {player4MR.setText(stringCounter);}
                else if (playerIndex == 4) {player5MR.setText(stringCounter);}
                return false;
            }
        } else if (size == "small") {
            if (space.getPlayersArray()[playerIndex].getSmallSizeCounter() == 1) {
                return true;
            } else {
                space.getPlayersArray()[playerIndex].setSizeCounterPlus(size);
                stringCounter = Integer.toString(space.getPlayersArray()[playerIndex].getSmallSizeCounter());
                if (playerIndex == 0) {player1SR.setText(stringCounter);}
                else if (playerIndex == 1) {player2SR.setText(stringCounter);}
                else if (playerIndex == 2) {player3SR.setText(stringCounter);}
                else if (playerIndex == 3) {player4SR.setText(stringCounter);}
                else if (playerIndex == 4) {player5SR.setText(stringCounter);}
                return false;
            }
        } else {
            return false;
        }
    }

    @FXML
    public void hideRockets(){
        rocketsOnPlanetAnchorPane.setVisible(false);
        playerNow.setVisible(true);
        nowPlayingLabel.setVisible(true);
    }
    @FXML
    public void hideRockets2(){
        rocketsOnPlanetAnchorPane2.setVisible(false);
        playerNow.setVisible(true);
        nowPlayingLabel.setVisible(true);
    }

    @FXML
    public void moveRockets(){
        planetMenuAnchorPane.setVisible(false);
        rocketsOnPlanetAnchorPane2.setVisible(true);
        playerNow.setVisible(false);
        nowPlayingLabel.setVisible(false);
        planetCanBeEnabled = false;
        int index = 0;
        rocketsToMove = new Rocket[0]; rocketsToMoveSorted = new Rocket[0];
        if (mainEvent.getSource() == planet1) {
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln1().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln1().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln1().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln1().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln1().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln1().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln1().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln1().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln1().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln1().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln1().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln1().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln1().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln1().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet2) {
            planet2.setDisable(false);
            planet1.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln2().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln2().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln2().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln2().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln2().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln2().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln2().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln2().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln2().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln2().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln2().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln2().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln2().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln2().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet3) {
            planet3.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln3().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln3().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln3().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln3().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln3().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln3().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln3().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln3().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln3().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln3().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln3().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln3().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln3().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln3().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet4) {
            planet4.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln4().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln4().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln4().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln4().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln4().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln4().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln4().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln4().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln4().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln4().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln4().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln4().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln4().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln4().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet5) {
            planet5.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln5().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln5().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln5().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln5().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln5().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln5().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln5().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln5().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln5().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln5().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln5().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln5().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln5().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln5().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet6) {
            planet6.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln6().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln6().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln6().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln6().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln6().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln6().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln6().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln6().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln6().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln6().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln6().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln6().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln6().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln6().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet7) {
            planet7.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln7().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln7().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln7().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln7().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln7().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln7().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln7().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln7().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln7().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln7().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln7().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln7().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln7().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln7().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet8) {
            planet8.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln8().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln8().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln8().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln8().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln8().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln8().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln8().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln8().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln8().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln8().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln8().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln8().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln8().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln8().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet9) {
            planet9.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln9().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln9().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln9().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln9().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln9().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln9().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln9().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln9().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln9().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln9().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln9().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln9().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln9().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln9().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet10) {
            planet10.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln10().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln10().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln10().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln10().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln10().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln10().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln10().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln10().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln10().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln10().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln10().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln10().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln10().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln10().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet11) {
            planet11.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet12.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln11().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln11().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln11().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln11().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln11().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln11().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln11().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln11().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln11().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln11().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln11().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln11().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln11().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln11().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (mainEvent.getSource() == planet12) {
            planet12.setDisable(false);
            planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);}
            for (int i = 0; i < rocketImageViews2.length; i++) {
                rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
            }
            if (space.getPln12().getRockets().length != 0) {
                someRocket = true;
                for (int i = 0; i < space.getPln12().getRockets().length; i++) {
                    if (confirmCounter == 0) {
                        if (space.getPln12().getBigSizeCounter() != 0) {
                            someBRocket = true;
                            if (space.getPln12().getRockets()[i].getSize() == "big") {
                                rocketImageViews2[index].setImage(space.getPln12().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln12().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    } else if (confirmCounter == 1) {
                        if (space.getPln12().getMediumSizeCounter() != 0) {
                            someMRocket = true;
                            if (space.getPln12().getRockets()[i].getSize() == "medium") {
                                rocketImageViews2[index].setImage(space.getPln12().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln12().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }else if (confirmCounter == 2) {
                        if (space.getPln12().getSmallSizeCounter() != 0) {
                            someSRocket = true;
                            if (space.getPln12().getRockets()[i].getSize() == "small") {
                                rocketImageViews2[index].setImage(space.getPln12().getRockets()[i].getRocImg());
                                addRocket(rocketsToMove, space.getPln12().getRockets()[i]);
                                index++;
                            }
                        } else {
                            confirmButton.setVisible(true);
                        }
                    }
                }
            } else {
                someRocket = false;
                confirmButton.setVisible(true);
            }
        } else if (space.getCountOfPlayers() == 4 || space.getCountOfPlayers() == 5) {
                if (mainEvent.getSource() == planet13) {
                    planet13.setDisable(false);
                    planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);
                    for (int i = 0; i < rocketImageViews2.length; i++) {
                        rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                    }
                    if (space.getPln13().getRockets().length != 0) {
                        someRocket = true;
                        for (int i = 0; i < space.getPln13().getRockets().length; i++) {
                            if (confirmCounter == 0) {
                                if (space.getPln13().getBigSizeCounter() != 0) {
                                    someBRocket = true;
                                    if (space.getPln13().getRockets()[i].getSize() == "big") {
                                        rocketImageViews2[index].setImage(space.getPln13().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln13().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            } else if (confirmCounter == 1) {
                                if (space.getPln13().getMediumSizeCounter() != 0) {
                                    someMRocket = true;
                                    if (space.getPln13().getRockets()[i].getSize() == "medium") {
                                        rocketImageViews2[index].setImage(space.getPln13().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln13().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }else if (confirmCounter == 2) {
                                if (space.getPln13().getSmallSizeCounter() != 0) {
                                    someSRocket = true;
                                    if (space.getPln13().getRockets()[i].getSize() == "small") {
                                        rocketImageViews2[index].setImage(space.getPln13().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln13().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }
                        }
                    } else {
                        someRocket = false;
                        confirmButton.setVisible(true);
                    }
                } else if (mainEvent.getSource() == planet14) {
                    planet14.setDisable(false);
                    planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);planet13.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);
                    for (int i = 0; i < rocketImageViews2.length; i++) {
                        rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                    }
                    if(space.getPln14().getRockets().length != 0) {
                        someRocket = true;
                        for (int i = 0; i < space.getPln14().getRockets().length; i++) {
                            if (confirmCounter == 0) {
                                if (space.getPln14().getBigSizeCounter() != 0) {
                                    someBRocket = true;
                                    if (space.getPln14().getRockets()[i].getSize() == "big") {
                                        rocketImageViews2[index].setImage(space.getPln14().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln14().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            } else if (confirmCounter == 1) {
                                if (space.getPln14().getMediumSizeCounter() != 0) {
                                    someMRocket = true;
                                    if (space.getPln14().getRockets()[i].getSize() == "medium") {
                                        rocketImageViews2[index].setImage(space.getPln14().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln14().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }else if (confirmCounter == 2) {
                                if (space.getPln14().getSmallSizeCounter() != 0) {
                                    someSRocket = true;
                                    if (space.getPln14().getRockets()[i].getSize() == "small") {
                                        rocketImageViews2[index].setImage(space.getPln14().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln14().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }
                        }
                    } else {
                        someRocket = false;
                        confirmButton.setVisible(true);
                    }
                } else if (mainEvent.getSource() == planet15) {
                    planet15.setDisable(false);
                    planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);planet13.setDisable(true);planet14.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);
                    for (int i = 0; i < rocketImageViews2.length; i++) {
                        rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                    }
                    if(space.getPln15().getRockets().length != 0) {
                        someRocket = true;
                        for (int i = 0; i < space.getPln15().getRockets().length; i++) {
                            if (confirmCounter == 0) {
                                if (space.getPln15().getBigSizeCounter() != 0) {
                                    someBRocket = true;
                                    if (space.getPln15().getRockets()[i].getSize() == "big") {
                                        rocketImageViews2[index].setImage(space.getPln15().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln15().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            } else if (confirmCounter == 1) {
                                if (space.getPln15().getMediumSizeCounter() != 0) {
                                    someMRocket = true;
                                    if (space.getPln15().getRockets()[i].getSize() == "medium") {
                                        rocketImageViews2[index].setImage(space.getPln15().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln15().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }else if (confirmCounter == 2) {
                                if (space.getPln15().getSmallSizeCounter() != 0) {
                                    someSRocket = true;
                                    if (space.getPln15().getRockets()[i].getSize() == "small") {
                                        rocketImageViews2[index].setImage(space.getPln15().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln15().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }
                        }
                    } else {
                        someRocket = false;
                        confirmButton.setVisible(true);
                    }
                } else if (mainEvent.getSource() == planet16) {
                    planet16.setDisable(false);
                    planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet17.setDisable(true);planet18.setDisable(true);
                    for (int i = 0; i < rocketImageViews2.length; i++) {
                        rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                    }
                    if(space.getPln16().getRockets().length != 0) {
                        someRocket = true;
                        for (int i = 0; i < space.getPln16().getRockets().length; i++) {
                            if (confirmCounter == 0) {
                                if (space.getPln16().getBigSizeCounter() != 0) {
                                    someBRocket = true;
                                    if (space.getPln16().getRockets()[i].getSize() == "big") {
                                        rocketImageViews2[index].setImage(space.getPln16().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln16().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            } else if (confirmCounter == 1) {
                                if (space.getPln16().getMediumSizeCounter() != 0) {
                                    someMRocket = true;
                                    if (space.getPln16().getRockets()[i].getSize() == "medium") {
                                        rocketImageViews2[index].setImage(space.getPln16().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln16().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }else if (confirmCounter == 2) {
                                if (space.getPln16().getSmallSizeCounter() != 0) {
                                    someSRocket = true;
                                    if (space.getPln16().getRockets()[i].getSize() == "small") {
                                        rocketImageViews2[index].setImage(space.getPln16().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln16().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }
                        }
                    } else {
                        someRocket = false;
                        confirmButton.setVisible(true);
                    }
                } else if (mainEvent.getSource() == planet17) {
                    planet17.setDisable(false);
                    planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet18.setDisable(true);
                    for (int i = 0; i < rocketImageViews2.length; i++) {
                        rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                    }
                    if(space.getPln17().getRockets().length != 0) {
                        someRocket = true;
                        for (int i = 0; i < space.getPln17().getRockets().length; i++) {
                            if (confirmCounter == 0) {
                                if (space.getPln17().getBigSizeCounter() != 0) {
                                    someBRocket = true;
                                    if (space.getPln17().getRockets()[i].getSize() == "big") {
                                        rocketImageViews2[index].setImage(space.getPln17().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln17().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            } else if (confirmCounter == 1) {
                                if (space.getPln17().getMediumSizeCounter() != 0) {
                                    someMRocket = true;
                                    if (space.getPln17().getRockets()[i].getSize() == "medium") {
                                        rocketImageViews2[index].setImage(space.getPln17().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln17().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }else if (confirmCounter == 2) {
                                if (space.getPln17().getSmallSizeCounter() != 0) {
                                    someSRocket = true;
                                    if (space.getPln17().getRockets()[i].getSize() == "small") {
                                        rocketImageViews2[index].setImage(space.getPln17().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln17().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }
                        }
                    } else {
                        someRocket = false;
                        confirmButton.setVisible(true);
                    }
                } else if (mainEvent.getSource() == planet18) {
                    planet18.setDisable(false);
                    planet1.setDisable(true);planet2.setDisable(true);planet3.setDisable(true);planet4.setDisable(true);planet5.setDisable(true);planet6.setDisable(true);planet7.setDisable(true);planet8.setDisable(true);planet9.setDisable(true);planet10.setDisable(true);planet11.setDisable(true);planet12.setDisable(true);planet13.setDisable(true);planet14.setDisable(true);planet15.setDisable(true);planet16.setDisable(true);planet17.setDisable(true);
                    for (int i = 0; i < rocketImageViews2.length; i++) {
                        rocketImageViews2[i].setImage(new Image(getClass().getResourceAsStream("pics/emptyImage.png")));
                    }
                    if(space.getPln18().getRockets().length != 0) {
                        someRocket = true;
                        for (int i = 0; i < space.getPln18().getRockets().length; i++) {
                            if (confirmCounter == 0) {
                                if (space.getPln18().getBigSizeCounter() != 0) {
                                    someBRocket = true;
                                    if (space.getPln18().getRockets()[i].getSize() == "big") {
                                        rocketImageViews2[index].setImage(space.getPln18().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln18().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            } else if (confirmCounter == 1) {
                                if (space.getPln18().getMediumSizeCounter() != 0) {
                                    someMRocket = true;
                                    if (space.getPln18().getRockets()[i].getSize() == "medium") {
                                        rocketImageViews2[index].setImage(space.getPln18().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln18().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }else if (confirmCounter == 2) {
                                if (space.getPln18().getSmallSizeCounter() != 0) {
                                    someSRocket = true;
                                    if (space.getPln18().getRockets()[i].getSize() == "small") {
                                        rocketImageViews2[index].setImage(space.getPln18().getRockets()[i].getRocImg());
                                        addRocket(rocketsToMove, space.getPln18().getRockets()[i]);
                                        index++;
                                    }
                                } else {
                                    confirmButton.setVisible(true);
                                }
                            }
                        }
                    } else {
                        someRocket = false;
                        confirmButton.setVisible(true);
                    }
                }
            }
        rocketMoveButton1.setDisable(false);rocketMoveButton2.setDisable(false);rocketMoveButton3.setDisable(false);rocketMoveButton4.setDisable(false);rocketMoveButton5.setDisable(false);rocketMoveButton6.setDisable(false);rocketMoveButton7.setDisable(false);rocketMoveButton8.setDisable(false);rocketMoveButton9.setDisable(false);rocketMoveButton10.setDisable(false);rocketMoveButton11.setDisable(false);rocketMoveButton12.setDisable(false);rocketMoveButton13.setDisable(false);rocketMoveButton14.setDisable(false);rocketMoveButton15.setDisable(false);
    }

    @FXML
    public void rocketMovingChoose(ActionEvent e) {
        if (e.getSource() == rocketMoveButton1){
            rocketMoveButton1.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[0]);
        }
        else if (e.getSource() == rocketMoveButton2){
            rocketMoveButton2.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[1]);
        }
        else if (e.getSource() == rocketMoveButton3){
            rocketMoveButton3.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[2]);
        }
        else if (e.getSource() == rocketMoveButton4){
            rocketMoveButton4.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[3]);
        }
        else if (e.getSource() == rocketMoveButton5){
            rocketMoveButton5.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[4]);
        }
        else if (e.getSource() == rocketMoveButton6){
            rocketMoveButton6.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[5]);
        }
        else if (e.getSource() == rocketMoveButton7){
            rocketMoveButton7.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[6]);
        }
        else if (e.getSource() == rocketMoveButton8){
            rocketMoveButton8.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[7]);
        }
        else if (e.getSource() == rocketMoveButton9){
            rocketMoveButton9.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[8]);
        }
        else if (e.getSource() == rocketMoveButton10){
            rocketMoveButton10.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[9]);
        }
        else if (e.getSource() == rocketMoveButton11){
            rocketMoveButton11.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[10]);
        }
        else if (e.getSource() == rocketMoveButton12){
            rocketMoveButton12.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[11]);
        }
        else if (e.getSource() == rocketMoveButton13){
            rocketMoveButton13.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[12]);
        }
        else if (e.getSource() == rocketMoveButton14){
            rocketMoveButton14.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[13]);
        }
        else if (e.getSource() == rocketMoveButton15){
            rocketMoveButton15.setDisable(true);
            addRocketSorted(rocketsToMoveSorted, rocketsToMove[14]);
        }
        if (rocketsToMoveSorted.length == rocketsToMove.length){
            confirmButton.setVisible(true);
        }
    }
    public Rocket[] addR(Rocket arr[], Rocket rkt)
    {
        int n = arr.length;
        Rocket rockets[] = new Rocket[n + 1];
        for (int i = 0; i < n; i++) {
            rockets[i] = arr[i];
        }
        rockets[n] = rkt;
        return rockets;
    }
    public void addRocket(Rocket arr[], Rocket rkt){
        rocketsToMove = addR(arr, rkt);
    }
    public void addRocketSorted(Rocket arr[], Rocket rkt){
        rocketsToMoveSorted = addR(arr, rkt);
    }
    public void addRocketComplete(Rocket arr[], Rocket rkt){
        rocketsToMoveComplete = addR(arr, rkt);
    }

    @FXML
    public void confirming() {
        String stringSizeCounter;
            if (mainEvent.getSource() == planet1) {
                if (confirmCounter == 0) {
                    space.getPln1().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln1().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln1().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet2) {
                if (confirmCounter == 0) {
                    space.getPln2().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln2().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln2().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet3) {
                if (confirmCounter == 0) {
                    space.getPln3().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln3().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln3().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet4) {
                if (confirmCounter == 0) {
                    space.getPln4().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln4().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln4().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet5) {
                if (confirmCounter == 0) {
                    space.getPln5().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln5().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln5().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet6) {
                if (confirmCounter == 0) {
                    space.getPln6().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln6().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln6().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet7) {
                if (confirmCounter == 0) {
                    space.getPln7().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln7().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln7().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet8) {
                if (confirmCounter == 0) {
                    space.getPln8().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln8().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln8().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet9) {
                if (confirmCounter == 0) {
                    space.getPln9().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln9().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln9().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet10) {
                if (confirmCounter == 0) {
                    space.getPln10().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln10().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln10().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet11) {
                if (confirmCounter == 0) {
                    space.getPln11().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln11().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln11().setSmallSizeCounterZero();
                }
            }
            if (mainEvent.getSource() == planet12) {
                if (confirmCounter == 0) {
                    space.getPln12().setBigSizeCounterZero();
                } else if (confirmCounter == 1) {
                    space.getPln12().setMediumSizeCounterZero();
                } else if (confirmCounter == 2) {
                    space.getPln12().setSmallSizeCounterZero();
                }
            }
            if (space.getCountOfPlayers() > 3) {
                if (mainEvent.getSource() == planet13) {
                    if (confirmCounter == 0) {
                        space.getPln13().setBigSizeCounterZero();
                    } else if (confirmCounter == 1) {
                        space.getPln13().setMediumSizeCounterZero();
                    } else if (confirmCounter == 2) {
                        space.getPln13().setSmallSizeCounterZero();
                    }
                }
                if (mainEvent.getSource() == planet14) {
                    if (confirmCounter == 0) {
                        space.getPln14().setBigSizeCounterZero();
                    } else if (confirmCounter == 1) {
                        space.getPln14().setMediumSizeCounterZero();
                    } else if (confirmCounter == 2) {
                        space.getPln14().setSmallSizeCounterZero();
                    }
                }
                if (mainEvent.getSource() == planet15) {
                    if (confirmCounter == 0) {
                        space.getPln15().setBigSizeCounterZero();
                    } else if (confirmCounter == 1) {
                        space.getPln15().setMediumSizeCounterZero();
                    } else if (confirmCounter == 2) {
                        space.getPln15().setSmallSizeCounterZero();
                    }
                }
                if (mainEvent.getSource() == planet16) {
                    if (confirmCounter == 0) {
                        space.getPln16().setBigSizeCounterZero();
                    } else if (confirmCounter == 1) {
                        space.getPln16().setMediumSizeCounterZero();
                    } else if (confirmCounter == 2) {
                        space.getPln16().setSmallSizeCounterZero();
                    }
                }
                if (mainEvent.getSource() == planet17) {
                    if (confirmCounter == 0) {
                        space.getPln17().setBigSizeCounterZero();
                    } else if (confirmCounter == 1) {
                        space.getPln17().setMediumSizeCounterZero();
                    } else if (confirmCounter == 2) {
                        space.getPln17().setSmallSizeCounterZero();
                    }
                }
                if (mainEvent.getSource() == planet18) {
                    if (confirmCounter == 0) {
                        space.getPln18().setBigSizeCounterZero();
                    } else if (confirmCounter == 1) {
                        space.getPln18().setMediumSizeCounterZero();
                    } else if (confirmCounter == 2) {
                        space.getPln18().setSmallSizeCounterZero();
                    }
                }
            }
        confirmCounter ++;
        confirmButton.setVisible(false);
        for (int i = 0; i < rocketsToMoveSorted.length; i++) {
            addRocketComplete(rocketsToMoveComplete, rocketsToMoveSorted[i]);
        }
        if(confirmCounter == 1){
            choosingLabel.setText("Choosing medium rockets");
        } else if (confirmCounter == 2){
            choosingLabel.setText("Choosing small rockets");
        }
        if (confirmCounter < 3) {
            moveRockets();
        } else {
            infoLabel.setText("All rockets moved!");
            infoLabel.setVisible(true);
            confirmCounter = 0;
            fullConfirming();
            rocketsOnPlanetAnchorPane2.setVisible(false);
            rocketsToMoveComplete = new Rocket[0];
            choosingLabel.setText("Choosing big rockets");
            playerNow.setVisible(true);
            nowPlayingLabel.setVisible(true);
            if (someRocket) {
                if (someBRocket == false && someMRocket == false && someSRocket == false) {
                    if (mainEvent.getSource() == planet1) {
                        for (int i = 0; i < space.getPln1().getRockets().length; i++) {
                            if (space.getPln1().getRockets()[i].getSize() == "big"){
                                space.getPln1().setSizeCounterPlus("big");
                            }
                            else if (space.getPln1().getRockets()[i].getSize() == "medium") {
                                space.getPln1().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln1().getRockets()[i].getSize() == "small") {
                                space.getPln1().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet2) {
                        for (int i = 0; i < space.getPln2().getRockets().length; i++) {
                            if (space.getPln2().getRockets()[i].getSize() == "big"){
                                space.getPln2().setSizeCounterPlus("big");
                            }
                            else if (space.getPln2().getRockets()[i].getSize() == "medium") {
                                space.getPln2().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln2().getRockets()[i].getSize() == "small") {
                                space.getPln2().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet3) {
                        for (int i = 0; i < space.getPln3().getRockets().length; i++) {
                            if (space.getPln3().getRockets()[i].getSize() == "big"){
                                space.getPln3().setSizeCounterPlus("big");
                            }
                            else if (space.getPln3().getRockets()[i].getSize() == "medium") {
                                space.getPln3().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln3().getRockets()[i].getSize() == "small") {
                                space.getPln3().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet4) {
                        for (int i = 0; i < space.getPln4().getRockets().length; i++) {
                            if (space.getPln4().getRockets()[i].getSize() == "big"){
                                space.getPln4().setSizeCounterPlus("big");
                            }
                            else if (space.getPln4().getRockets()[i].getSize() == "medium") {
                                space.getPln4().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln4().getRockets()[i].getSize() == "small") {
                                space.getPln4().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet5) {
                        for (int i = 0; i < space.getPln5().getRockets().length; i++) {
                            if (space.getPln5().getRockets()[i].getSize() == "big"){
                                space.getPln5().setSizeCounterPlus("big");
                            }
                            else if (space.getPln5().getRockets()[i].getSize() == "medium") {
                                space.getPln5().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln5().getRockets()[i].getSize() == "small") {
                                space.getPln5().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet6) {
                        for (int i = 0; i < space.getPln6().getRockets().length; i++) {
                            if (space.getPln6().getRockets()[i].getSize() == "big"){
                                space.getPln6().setSizeCounterPlus("big");
                            }
                            else if (space.getPln6().getRockets()[i].getSize() == "medium") {
                                space.getPln6().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln6().getRockets()[i].getSize() == "small") {
                                space.getPln6().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet7) {
                        for (int i = 0; i < space.getPln7().getRockets().length; i++) {
                            if (space.getPln7().getRockets()[i].getSize() == "big"){
                                space.getPln7().setSizeCounterPlus("big");
                            }
                            else if (space.getPln7().getRockets()[i].getSize() == "medium") {
                                space.getPln7().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln7().getRockets()[i].getSize() == "small") {
                                space.getPln7().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet8) {
                        for (int i = 0; i < space.getPln8().getRockets().length; i++) {
                            if (space.getPln8().getRockets()[i].getSize() == "big"){
                                space.getPln8().setSizeCounterPlus("big");
                            }
                            else if (space.getPln8().getRockets()[i].getSize() == "medium") {
                                space.getPln8().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln8().getRockets()[i].getSize() == "small") {
                                space.getPln8().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet9) {
                        for (int i = 0; i < space.getPln9().getRockets().length; i++) {
                            if (space.getPln9().getRockets()[i].getSize() == "big"){
                                space.getPln9().setSizeCounterPlus("big");
                            }
                            else if (space.getPln9().getRockets()[i].getSize() == "medium") {
                                space.getPln9().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln9().getRockets()[i].getSize() == "small") {
                                space.getPln9().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet10) {
                        for (int i = 0; i < space.getPln10().getRockets().length; i++) {
                            if (space.getPln10().getRockets()[i].getSize() == "big"){
                                space.getPln10().setSizeCounterPlus("big");
                            }
                            else if (space.getPln10().getRockets()[i].getSize() == "medium") {
                                space.getPln10().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln10().getRockets()[i].getSize() == "small") {
                                space.getPln10().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet11) {
                        for (int i = 0; i < space.getPln11().getRockets().length; i++) {
                            if (space.getPln11().getRockets()[i].getSize() == "big"){
                                space.getPln11().setSizeCounterPlus("big");
                            }
                            else if (space.getPln11().getRockets()[i].getSize() == "medium") {
                                space.getPln11().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln11().getRockets()[i].getSize() == "small") {
                                space.getPln11().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (mainEvent.getSource() == planet12) {
                        for (int i = 0; i < space.getPln12().getRockets().length; i++) {
                            if (space.getPln12().getRockets()[i].getSize() == "big"){
                                space.getPln12().setSizeCounterPlus("big");
                            }
                            else if (space.getPln12().getRockets()[i].getSize() == "medium") {
                                space.getPln12().setSizeCounterPlus("medium");
                            }
                            else if (space.getPln12().getRockets()[i].getSize() == "small") {
                                space.getPln12().setSizeCounterPlus("small");
                            }
                        }
                    }
                    if (space.getCountOfPlayers() > 3) {
                        if (mainEvent.getSource() == planet13) {
                            for (int i = 0; i < space.getPln13().getRockets().length; i++) {
                                if (space.getPln13().getRockets()[i].getSize() == "big"){
                                    space.getPln13().setSizeCounterPlus("big");
                                }
                                else if (space.getPln13().getRockets()[i].getSize() == "medium") {
                                    space.getPln13().setSizeCounterPlus("medium");
                                }
                                else if (space.getPln13().getRockets()[i].getSize() == "small") {
                                    space.getPln13().setSizeCounterPlus("small");
                                }
                            }
                        }
                        if (mainEvent.getSource() == planet14) {
                            for (int i = 0; i < space.getPln14().getRockets().length; i++) {
                                if (space.getPln14().getRockets()[i].getSize() == "big"){
                                    space.getPln14().setSizeCounterPlus("big");
                                }
                                else if (space.getPln14().getRockets()[i].getSize() == "medium") {
                                    space.getPln14().setSizeCounterPlus("medium");
                                }
                                else if (space.getPln14().getRockets()[i].getSize() == "small") {
                                    space.getPln14().setSizeCounterPlus("small");
                                }
                            }
                        }
                        if (mainEvent.getSource() == planet15) {
                            for (int i = 0; i < space.getPln15().getRockets().length; i++) {
                                if (space.getPln15().getRockets()[i].getSize() == "big"){
                                    space.getPln15().setSizeCounterPlus("big");
                                }
                                else if (space.getPln15().getRockets()[i].getSize() == "medium") {
                                    space.getPln15().setSizeCounterPlus("medium");
                                }
                                else if (space.getPln15().getRockets()[i].getSize() == "small") {
                                    space.getPln15().setSizeCounterPlus("small");
                                }
                            }
                        }
                        if (mainEvent.getSource() == planet16) {
                            for (int i = 0; i < space.getPln16().getRockets().length; i++) {
                                if (space.getPln16().getRockets()[i].getSize() == "big"){
                                    space.getPln16().setSizeCounterPlus("big");
                                }
                                else if (space.getPln16().getRockets()[i].getSize() == "medium") {
                                    space.getPln16().setSizeCounterPlus("medium");
                                }
                                else if (space.getPln16().getRockets()[i].getSize() == "small") {
                                    space.getPln16().setSizeCounterPlus("small");
                                }
                            }
                        }
                        if (mainEvent.getSource() == planet17) {
                            for (int i = 0; i < space.getPln17().getRockets().length; i++) {
                                if (space.getPln17().getRockets()[i].getSize() == "big"){
                                    space.getPln17().setSizeCounterPlus("big");
                                }
                                else if (space.getPln17().getRockets()[i].getSize() == "medium") {
                                    space.getPln17().setSizeCounterPlus("medium");
                                }
                                else if (space.getPln17().getRockets()[i].getSize() == "small") {
                                    space.getPln17().setSizeCounterPlus("small");
                                }
                            }
                        }
                        if (mainEvent.getSource() == planet18) {
                            for (int i = 0; i < space.getPln18().getRockets().length; i++) {
                                if (space.getPln18().getRockets()[i].getSize() == "big"){
                                    space.getPln18().setSizeCounterPlus("big");
                                }
                                else if (space.getPln18().getRockets()[i].getSize() == "medium") {
                                    space.getPln18().setSizeCounterPlus("medium");
                                }
                                else if (space.getPln18().getRockets()[i].getSize() == "small") {
                                    space.getPln18().setSizeCounterPlus("small");
                                }
                            }
                        }
                    }
                }
                if (rocketsMoved) {
                    if (tokenUsed) {
                        playerIndex = playerIndexHelper;
                        tokenUsed = false;
                        if (playerIndex == space.getCountOfPlayers()) {
                            playerIndex = 0;
                        }
                        coloredTextPlayerNow(space.getPlayersArray()[playerIndex].getColor());
                        coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
                        if (playerIndex == 0) {
                            playerNow.setText("PLAYER1");
                        }
                        else if (playerIndex == 1) {
                            playerNow.setText("PLAYER2");
                        } else if (playerIndex == 2) {
                            playerNow.setText("PLAYER3");
                        } else if (playerIndex == 3) {
                            playerNow.setText("PLAYER4");
                        } else if (playerIndex == 4) {
                            playerNow.setText("PLAYER5");
                        }
                        planetCanBeEnabled = true;
                    }
                    else {
                        if (playerIndex + 1 == space.getCountOfPlayers()) {
                            playerIndex = 0;
                            coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                            coloredTextInfo(space.getPlayersArray()[space.getPlayersArray().length - 1].getColor());
                            playerNow.setText("PLAYER1");
                        } else {
                            coloredTextPlayerNow(space.getPlayersArray()[playerIndex + 1].getColor());
                            coloredTextInfo(space.getPlayersArray()[playerIndex].getColor());
                            if (playerIndex + 1 == 1) {
                                playerNow.setText("PLAYER2");
                            } else if (playerIndex + 1 == 2) {
                                playerNow.setText("PLAYER3");
                            } else if (playerIndex + 1 == 3) {
                                playerNow.setText("PLAYER4");
                            } else if (playerIndex + 1 == 4) {
                                playerNow.setText("PLAYER5");
                            }
                            planetCanBeEnabled = true;
                            playerIndex++;
                        }
                    }
                    player1TokenButton.setDisable(false);player2TokenButton.setDisable(false);player3TokenButton.setDisable(false);
                    if (space.getCountOfPlayers() > 3){player4TokenButton.setDisable(true);player5TokenButton.setDisable(true);}
                }
            }
            planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
            if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
        }
    }
    @FXML
    public void tokenUse(ActionEvent e){int playerTokens;
        String playerTokensString;
        planetMenuAnchorPane.setVisible(false);
        planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);
        planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);
        planet11.setDisable(false);planet12.setDisable(false);
        if (space.getCountOfPlayers() > 3){
            planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);
            planet17.setDisable(false);planet18.setDisable(false);
        }
        infoLabel.setStyle("-fx-text-fill: white");
        if (e.getSource() == player1TokenButton){
            System.out.println(space.getPlayersArray()[0].getTokens());
            if (space.getPlayersArray()[0].getTokens() > 0) {
                player1TokenButton.setDisable(true);player2TokenButton.setDisable(true);player3TokenButton.setDisable(true);
                if (space.getCountOfPlayers() > 3){player4TokenButton.setDisable(true);player5TokenButton.setDisable(true);}infoLabel.setVisible(false);
                playerIndexHelper = playerIndex;
                playerIndex = 0;
                space.getPlayersArray()[0].setTokensMinus();
                coloredTextPlayerNow(space.getPlayersArray()[0].getColor());
                playerNow.setText("PLAYER1");
                playerTokens = space.getPlayersArray()[0].getTokens();
                playerTokensString = Integer.toString(playerTokens);
                playerToken1.setText("Tokens: " + playerTokensString);
                tokenUsed = true;
            } else {infoLabel.setText("You have not enough tokens"); infoLabel.setVisible(true);}
        }
        else if (e.getSource() == player2TokenButton){
            if (space.getPlayersArray()[1].getTokens() > 0) {
                player1TokenButton.setDisable(true);player2TokenButton.setDisable(true);player3TokenButton.setDisable(true);
                if (space.getCountOfPlayers() > 3){player4TokenButton.setDisable(true);player5TokenButton.setDisable(true);}infoLabel.setVisible(false);
                playerIndexHelper = playerIndex;
                playerIndex = 1;
                space.getPlayersArray()[1].setTokensMinus();
                coloredTextPlayerNow(space.getPlayersArray()[1].getColor());
                playerNow.setText("PLAYER2");
                playerTokens = space.getPlayersArray()[1].getTokens();
                playerTokensString = Integer.toString(playerTokens);
                playerToken2.setText("Tokens: " + playerTokensString);
                tokenUsed = true;
            } else {infoLabel.setText("You have not enough tokens"); infoLabel.setVisible(true);}
        }
        else if (e.getSource() == player3TokenButton) {
            if (space.getPlayersArray()[2].getTokens() > 0) {
                player1TokenButton.setDisable(true);player2TokenButton.setDisable(true);player3TokenButton.setDisable(true);
                if (space.getCountOfPlayers() > 3){player4TokenButton.setDisable(true);player5TokenButton.setDisable(true);}
                infoLabel.setVisible(false);
                playerIndexHelper = playerIndex;
                playerIndex = 2;
                space.getPlayersArray()[2].setTokensMinus();
                coloredTextPlayerNow(space.getPlayersArray()[2].getColor());
                playerNow.setText("PLAYER3");
                playerTokens = space.getPlayersArray()[2].getTokens();
                playerTokensString = Integer.toString(playerTokens);
                playerToken3.setText("Tokens: " + playerTokensString);
                tokenUsed = true;
            }  else {infoLabel.setText("You have not enough tokens"); infoLabel.setVisible(true);}
        }
        else if (e.getSource() == player4TokenButton) {
            if (space.getPlayersArray()[3].getTokens() > 0) {
                player1TokenButton.setDisable(true);player2TokenButton.setDisable(true);player3TokenButton.setDisable(true);
                if (space.getCountOfPlayers() > 3){player4TokenButton.setDisable(true);player5TokenButton.setDisable(true);}infoLabel.setVisible(false);
                space.getPlayersArray()[3].setTokensMinus();
                playerIndexHelper = playerIndex;
                playerIndex = 3;
                coloredTextPlayerNow(space.getPlayersArray()[3].getColor());
                playerNow.setText("PLAYER4");
                playerTokens = space.getPlayersArray()[3].getTokens();
                playerTokensString = Integer.toString(playerTokens);
                playerToken4.setText("Tokens: " + playerTokensString);
                tokenUsed = true;
            }  else {infoLabel.setText("You have not enough tokens"); infoLabel.setVisible(true);}
        }
        else if (e.getSource() == player5TokenButton) {
            if (space.getPlayersArray()[4].getTokens() > 0) {
                player1TokenButton.setDisable(true);player2TokenButton.setDisable(true);player3TokenButton.setDisable(true);
                if (space.getCountOfPlayers() > 3){player4TokenButton.setDisable(true);player5TokenButton.setDisable(true);}infoLabel.setVisible(false);
                space.getPlayersArray()[4].setTokensMinus();
                playerIndexHelper = playerIndex;
                playerIndex = 4;
                coloredTextPlayerNow(space.getPlayersArray()[4].getColor());
                playerNow.setText("PLAYER5");
                playerTokens = space.getPlayersArray()[4].getTokens();
                playerTokensString = Integer.toString(playerTokens);
                playerToken5.setText("Tokens: " + playerTokensString);
                tokenUsed = true;
            }
        } else {infoLabel.setText("You have not enough tokens"); infoLabel.setVisible(true);}
    }
    public void bigRocketTextRewrite(int i){
        space.getPlayersArray()[i].setBigSizeCounterMinus();
        String stringSizeCounter = Integer.toString(space.getPlayersArray()[i].getBigSizeCounter());
        if (space.getPlayersArray()[i].getColor() == space.getP1().getColor()){player1BR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP2().getColor()){player2BR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP3().getColor()){player3BR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP4().getColor()){player4BR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP5().getColor()){player5BR.setText(stringSizeCounter);}
        if (space.getPlayersArray()[i].getAllRocketsCount() == 0){
            space.getPlayersArray()[i].setTokens0();
            ende();
        }
    }
    public void mediumRocketTextRewrite(int i){
        space.getPlayersArray()[i].setMediumSizeCounterMinus();
        String stringSizeCounter = Integer.toString(space.getPlayersArray()[i].getMediumSizeCounter());
        if (space.getPlayersArray()[i].getColor() == space.getP1().getColor()){player1MR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP2().getColor()){player2MR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP3().getColor()){player3MR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP4().getColor()){player4MR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP5().getColor()){player5MR.setText(stringSizeCounter);}
        if (space.getPlayersArray()[i].getAllRocketsCount() == 0){
            space.getPlayersArray()[i].setTokens0();
            ende();
        }
    }
    public void smallRocketTextRewrite(int i){
        space.getPlayersArray()[i].setSmallSizeCounterMinus();
        String stringSizeCounter = Integer.toString(space.getPlayersArray()[i].getSmallSizeCounter());
        if (space.getPlayersArray()[i].getColor() == space.getP1().getColor()){player1SR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP2().getColor()){player2SR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP3().getColor()){player3SR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP4().getColor()){player4SR.setText(stringSizeCounter);}
        else if (space.getPlayersArray()[i].getColor() == space.getP5().getColor()){player5SR.setText(stringSizeCounter);}
        if (space.getPlayersArray()[i].getAllRocketsCount() == 0){
            space.getPlayersArray()[i].setTokens0();
            ende();
        }
    }
    public void ende(){
        int pl1ScoreCount, pl2ScoreCount, pl3ScoreCount, pl4ScoreCount, pl5ScoreCount = 0;
        String pl1Tokens, pl2Tokens, pl3Tokens, pl4Tokens, pl5Tokens, pl1BR, pl2BR, pl3BR, pl4BR, pl5BR, pl1MR, pl2MR, pl3MR, pl4MR, pl5MR,
        pl1SR, pl2SR, pl3SR, pl4SR, pl5SR, pl1Score, pl2Score, pl3Score, pl4Score, pl5Score;
        pl1ScoreCount = (space.getPlayersArray()[0].getBigSizeCounter()*4 + space.getPlayersArray()[0].getMediumSizeCounter()*2 +
                         space.getPlayersArray()[0].getSmallSizeCounter()*1 + space.getPlayersArray()[0].getTokens()*3);
        pl2ScoreCount = (space.getPlayersArray()[1].getBigSizeCounter()*4 + space.getPlayersArray()[1].getMediumSizeCounter()*2 +
                         space.getPlayersArray()[1].getSmallSizeCounter()*1 + space.getPlayersArray()[1].getTokens()*3);
        pl1Score = Integer.toString(pl1ScoreCount);
        pl1Tokens = Integer.toString(space.getPlayersArray()[0].getTokens());
        pl1BR = Integer.toString(space.getPlayersArray()[0].getBigSizeCounter());
        pl1MR = Integer.toString(space.getPlayersArray()[0].getMediumSizeCounter());
        pl1SR = Integer.toString(space.getPlayersArray()[0].getSmallSizeCounter());
        player1TokenEndShow.setText(pl1Tokens);
        player1BigRocketsEndShow.setText(pl1BR);
        player1MediumRocketsEndShow.setText(pl1MR);
        player1SmallRocketsEndShow.setText(pl1SR);
        player1ScoreShow.setText(pl1Score);
        pl2Score = Integer.toString(pl2ScoreCount);
        pl2Tokens = Integer.toString(space.getPlayersArray()[1].getTokens());
        pl2BR = Integer.toString(space.getPlayersArray()[1].getBigSizeCounter());
        pl2MR = Integer.toString(space.getPlayersArray()[1].getMediumSizeCounter());
        pl2SR = Integer.toString(space.getPlayersArray()[1].getSmallSizeCounter());
        player2TokenEndShow.setText(pl2Tokens);
        player2BigRocketsEndShow.setText(pl2BR);
        player2MediumRocketsEndShow.setText(pl2MR);
        player2SmallRocketsEndShow.setText(pl2SR);
        player2ScoreShow.setText(pl2Score);
        if (space.getPlayersArray()[0].getColor() == "red") {player1End.setStyle("--fx-text-fill: red");}
        else if (space.getPlayersArray()[0].getColor() == "blue") {player1End.setStyle("-fx-text-fill: blue");}
        else if (space.getPlayersArray()[0].getColor() == "green") {player1End.setStyle("-fx-text-fill: #1eff00");}
        else if (space.getPlayersArray()[0].getColor() == "gray") {player1End.setStyle("-fx-text-fill: #6e6e6e");}
        else if (space.getPlayersArray()[0].getColor() == "white") {player1End.setStyle("-fx-text-fill: white");}
        if (space.getPlayersArray()[1].getColor() == "red") {player2End.setStyle("-fx-text-fill: red");}
        else if (space.getPlayersArray()[1].getColor() == "blue") {player2End.setStyle("-fx-text-fill: blue");}
        else if (space.getPlayersArray()[1].getColor() == "green") {player2End.setStyle("-fx-text-fill: #1eff00");}
        else if (space.getPlayersArray()[1].getColor() == "gray") {player2End.setStyle("-fx-text-fill: #6e6e6e");}
        else if (space.getPlayersArray()[1].getColor() == "white") {player2End.setStyle("-fx-text-fill: white");}
        if(space.getCountOfPlayers() >= 3){
            if (space.getPlayersArray()[2].getColor() == "red") {player3End.setStyle("-fx-text-fill: red");}
            else if (space.getPlayersArray()[2].getColor() == "blue") {player3End.setStyle("-fx-text-fill: blue");}
            else if (space.getPlayersArray()[2].getColor() == "green") {player3End.setStyle("-fx-text-fill: #1eff00");}
            else if (space.getPlayersArray()[2].getColor() == "gray") {player3End.setStyle("-fx-text-fill: #6e6e6e");}
            else if (space.getPlayersArray()[2].getColor() == "white") {player3End.setStyle("-fx-text-fill: white");}
            pl3ScoreCount = (space.getPlayersArray()[2].getBigSizeCounter()*4 + space.getPlayersArray()[2].getMediumSizeCounter()*2 +
                             space.getPlayersArray()[2].getSmallSizeCounter()*1 + space.getPlayersArray()[2].getTokens()*3);
            pl3Score = Integer.toString(pl3ScoreCount);
            pl3Tokens = Integer.toString(space.getPlayersArray()[2].getTokens());
            pl3BR = Integer.toString(space.getPlayersArray()[2].getBigSizeCounter());
            pl3MR = Integer.toString(space.getPlayersArray()[2].getMediumSizeCounter());
            pl3SR = Integer.toString(space.getPlayersArray()[2].getSmallSizeCounter());
            player3TokenEndShow.setText(pl3Tokens);
            player3BigRocketsEndShow.setText(pl3BR);
            player3MediumRocketsEndShow.setText(pl3MR);
            player3SmallRocketsEndShow.setText(pl3SR);
            player3ScoreShow.setText(pl3Score);
            if (space.getCountOfPlayers() > 3){
                if (space.getPlayersArray()[3].getColor() == "red") {player4End.setStyle("-fx-text-fill: red");}
                else if (space.getPlayersArray()[3].getColor() == "blue") {player4End.setStyle("-fx-text-fill: blue");}
                else if (space.getPlayersArray()[3].getColor() == "green") {player4End.setStyle("-fx-text-fill: #1eff00");}
                else if (space.getPlayersArray()[3].getColor() == "gray") {player4End.setStyle("-fx-text-fill: #6e6e6e");}
                else if (space.getPlayersArray()[3].getColor() == "white") {player4End.setStyle("-fx-text-fill: white");}
                pl4ScoreCount = (space.getPlayersArray()[3].getBigSizeCounter()*4 + space.getPlayersArray()[3].getMediumSizeCounter()*2 +
                                 space.getPlayersArray()[3].getSmallSizeCounter()*1 + space.getPlayersArray()[3].getTokens()*3);
                pl4Score = Integer.toString(pl4ScoreCount);
                pl4Tokens = Integer.toString(space.getPlayersArray()[3].getTokens());
                pl4BR = Integer.toString(space.getPlayersArray()[3].getBigSizeCounter());
                pl4MR = Integer.toString(space.getPlayersArray()[3].getMediumSizeCounter());
                pl4SR = Integer.toString(space.getPlayersArray()[3].getSmallSizeCounter());
                player4TokenEndShow.setText(pl4Tokens);
                player4BigRocketsEndShow.setText(pl4BR);
                player4MediumRocketsEndShow.setText(pl4MR);
                player4SmallRocketsEndShow.setText(pl4SR);
                player4ScoreShow.setText(pl4Score);
                if (space.getCountOfPlayers() == 5){
                    if (space.getPlayersArray()[4].getColor() == "red") {player5End.setStyle("-fx-text-fill: red");}
                    else if (space.getPlayersArray()[4].getColor() == "blue") {player5End.setStyle("-fx-text-fill: blue");}
                    else if (space.getPlayersArray()[4].getColor() == "green") {player5End.setStyle("-fx-text-fill: #1eff00");}
                    else if (space.getPlayersArray()[4].getColor() == "gray") {player5End.setStyle("-fx-text-fill: #6e6e6e");}
                    else if (space.getPlayersArray()[4].getColor() == "white") {player5End.setStyle("-fx-text-fill: white");}
                    pl5ScoreCount = (space.getPlayersArray()[4].getBigSizeCounter()*4 + space.getPlayersArray()[4].getMediumSizeCounter()*2 +
                                     space.getPlayersArray()[4].getSmallSizeCounter()*1 + space.getPlayersArray()[4].getTokens()*3);
                    pl5Score = Integer.toString(pl5ScoreCount);
                    pl5Tokens = Integer.toString(space.getPlayersArray()[4].getTokens());
                    pl5BR = Integer.toString(space.getPlayersArray()[4].getBigSizeCounter());
                    pl5MR = Integer.toString(space.getPlayersArray()[4].getMediumSizeCounter());
                    pl5SR = Integer.toString(space.getPlayersArray()[4].getSmallSizeCounter());
                    player5TokenEndShow.setText(pl5Tokens);
                    player5BigRocketsEndShow.setText(pl5BR);
                    player5MediumRocketsEndShow.setText(pl5MR);
                    player5SmallRocketsEndShow.setText(pl5SR);
                    player5ScoreShow.setText(pl5Score);
                }
            }
        }
        if (space.getCountOfPlayers() == 2){
            player3End.setVisible(false);player4End.setVisible(false);player5End.setVisible(false);
            player3TokenEnd.setVisible(false); player4TokenEnd.setVisible(false); player5TokenEnd.setVisible(false);
            player3TokenEndShow.setVisible(false); player4TokenEndShow.setVisible(false); player5TokenEndShow.setVisible(false);
            player3BigRocketsEnd.setVisible(false); player4BigRocketsEnd.setVisible(false); player5BigRocketsEnd.setVisible(false);
            player3BigRocketsEndShow.setVisible(false); player4BigRocketsEndShow.setVisible(false); player5BigRocketsEndShow.setVisible(false);
            player3MediumRocketsEnd.setVisible(false); player4MediumRocketsEnd.setVisible(false);player5MediumRocketsEnd.setVisible(false);
            player3MediumRocketsEndShow.setVisible(false); player4MediumRocketsEndShow.setVisible(false);player5MediumRocketsEndShow.setVisible(false);
            player3SmallRocketsEnd.setVisible(false); player4SmallRocketsEnd.setVisible(false);player5SmallRocketsEnd.setVisible(false);
            player3SmallRocketsEndShow.setVisible(false); player4SmallRocketsEndShow.setVisible(false);player5SmallRocketsEndShow.setVisible(false);
            player3ScoreEnd.setVisible(false); player4ScoreEnd.setVisible(false); player5ScoreEnd.setVisible(false);
            player3ScoreShow.setVisible(false); player4ScoreShow.setVisible(false); player5ScoreShow.setVisible(false);
        } else if (space.getCountOfPlayers() == 3){
            player4End.setVisible(false);player5End.setVisible(false);player4TokenEnd.setVisible(false); player5TokenEnd.setVisible(false);
            player4TokenEndShow.setVisible(false); player5TokenEndShow.setVisible(false);player4BigRocketsEnd.setVisible(false);
            player5BigRocketsEnd.setVisible(false); player4BigRocketsEndShow.setVisible(false); player5BigRocketsEndShow.setVisible(false);
            player4MediumRocketsEnd.setVisible(false);player5MediumRocketsEnd.setVisible(false);
            player4MediumRocketsEndShow.setVisible(false);player5MediumRocketsEndShow.setVisible(false);
            player4SmallRocketsEnd.setVisible(false);player5SmallRocketsEnd.setVisible(false);
            player4SmallRocketsEndShow.setVisible(false);player5SmallRocketsEndShow.setVisible(false);
            player4ScoreEnd.setVisible(false); player5ScoreEnd.setVisible(false);
            player4ScoreShow.setVisible(false); player5ScoreShow.setVisible(false);
        } else if (space.getCountOfPlayers() == 4){
            player5End.setVisible(false);player5End.setVisible(false);player5TokenEnd.setVisible(false);player5TokenEndShow.setVisible(false);
            player5BigRocketsEnd.setVisible(false);player5BigRocketsEndShow.setVisible(false);
            player5MediumRocketsEnd.setVisible(false);player5MediumRocketsEndShow.setVisible(false); player5ScoreEnd.setVisible(false);
            player5SmallRocketsEnd.setVisible(false);player5SmallRocketsEndShow.setVisible(false); player5ScoreShow.setVisible(false);
        }
        endingScreen.setVisible(true);
    }
    public void fullConfirming(){
        if (rocketsToMoveComplete.length == 1) {
            if (mainEvent.getSource() == planet1) {
                if (space.getPln2().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln2(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}
                space.getPln1().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet2) {
                if (space.getPln3().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln3(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}
                space.getPln2().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet3) {
                if (space.getPln4().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.getPln3().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet4) {
                if (space.getPln5().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.getPln4().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet5) {
                if (space.getPln6().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                space.getPln5().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet6) {
                if (rocketsToMoveComplete[0].getColor() == "red") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "green") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "white") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.getPln6().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet7) {
                if (space.getPln8().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln8(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln8().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln8().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln8().setSizeCounterPlus("small");}
                space.getPln7().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet8) {
                if (space.getPln9().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln9(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln9().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln9().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln9().setSizeCounterPlus("small");}
                space.getPln8().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet9) {
                if (space.getPln10().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.getPln9().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet10) {
                if (space.getPln11().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.getPln10().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet11) {
                if (space.getPln12().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                space.getPln11().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet12) {
                if (rocketsToMoveComplete[0].getColor() == "red") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "green") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "white") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.getPln12().newRockets();
                rocketsMoved = true;
            } if (space.getCountOfPlayers() > 3){
                if (mainEvent.getSource() == planet13) {
                    if (space.getPln14().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln14(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln14().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln14().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln14().setSizeCounterPlus("small");}
                    space.getPln13().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet14) {
                    if (space.getPln15().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln15(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln15().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln15().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln15().setSizeCounterPlus("small");}
                    space.getPln14().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet15) {
                    if (space.getPln16().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.getPln15().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet16) {
                    if (space.getPln17().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.getPln16().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet17) {
                    if (space.getPln18().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    space.getPln17().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet18) {
                    if (rocketsToMoveComplete[0].getColor() == "red") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "green") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "white") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.getPln18().newRockets();
                    rocketsMoved = true;
                }
            }
        }
        if (rocketsToMoveComplete.length == 2) {
            if (mainEvent.getSource() == planet1) {
                if (space.getPln2().getRockets().length == 4 || space.getPln3().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln2(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln3(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}
                space.getPln1().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet2) {
                if (space.getPln3().getRockets().length == 4 || space.getPln4().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln3(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.getPln2().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet3) {
                if (space.getPln4().getRockets().length == 4 || space.getPln5().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.getPln3().newRockets();
            }if (mainEvent.getSource() == planet4) {
                if (space.getPln5().getRockets().length == 4 || space.getPln6().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                space.getPln4().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet5) {
                if (space.getPln6().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[1].getColor() == "red") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "green") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "white") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.getPln5().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet6) {
                if (space.getPln7().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                if (rocketsToMoveComplete[0].getColor() == "red") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "green") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "white") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.moveRocket(space.getPln7(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln7().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln7().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln7().setSizeCounterPlus("small");}
                space.getPln6().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet7) {
                if (space.getPln8().getRockets().length == 4 || space.getPln9().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln8(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln8().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln8().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln8().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln9(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln9().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln9().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln9().setSizeCounterPlus("small");}
                space.getPln7().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet8) {
                if (space.getPln9().getRockets().length == 4 || space.getPln10().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln9(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln9().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln9().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln9().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.getPln8().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet9) {
                if (space.getPln10().getRockets().length == 4 || space.getPln11().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.getPln9().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet10) {
                if (space.getPln11().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                space.getPln10().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet11) {
                if (space.getPln12().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[1].getColor() == "red") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "green") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "white") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.getPln11().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet12) {
                if (space.getCountOfPlayers() > 3){
                    if (space.getPln13().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                else if (space.getCountOfPlayers() <= 3){
                    if (space.getPln1().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                if (rocketsToMoveComplete[0].getColor() == "red") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "green") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "white") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                if (space.getCountOfPlayers() > 3){
                    space.moveRocket(space.getPln13(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln13().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln13().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln13().setSizeCounterPlus("small");}}
                else if (space.getCountOfPlayers() <= 3){
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}}
                space.getPln12().newRockets();
                rocketsMoved = true;
            } if (space.getCountOfPlayers() > 3){
                if (mainEvent.getSource() == planet13) {
                    if (space.getPln14().getRockets().length == 4 || space.getPln15().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln14(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln14().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln14().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln14().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln15(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln15().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln15().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln15().setSizeCounterPlus("small");}
                    space.getPln13().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet14) {
                    if (space.getPln15().getRockets().length == 4 || space.getPln14().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln15(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln15().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln15().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln15().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.getPln14().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet15) {
                    if (space.getPln16().getRockets().length == 4 || space.getPln17().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.getPln15().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet16) {
                    if (space.getPln17().getRockets().length == 4 || space.getPln18().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    space.getPln16().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet17) {
                    if (space.getPln18().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    if (rocketsToMoveComplete[1].getColor() == "red") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "green") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "white") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.getPln17().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet18) {
                    if (space.getPln1().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    if (rocketsToMoveComplete[0].getColor() == "red") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "green") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "white") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.getPln18().newRockets();
                    rocketsMoved = true;
                }
            }
        }
        if (rocketsToMoveComplete.length == 3) {
            if (mainEvent.getSource() == planet1) {
                if (space.getPln2().getRockets().length == 4 || space.getPln3().getRockets().length == 4 || space.getPln4().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln2(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln3(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.getPln1().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet2) {
                if (space.getPln3().getRockets().length == 4 || space.getPln4().getRockets().length == 4 || space.getPln5().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln3(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.getPln2().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet3) {
                if (space.getPln4().getRockets().length == 4 || space.getPln5().getRockets().length == 4 || space.getPln6().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                space.getPln3().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet4) {
                if (space.getPln5().getRockets().length == 4 || space.getPln6().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[2].getColor() == "red") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "blue") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "green") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "gray") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "white") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.getPln4().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet5) {
                if (space.getPln6().getRockets().length == 4 || space.getPln7().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[1].getColor() == "red") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "green") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "white") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.moveRocket(space.getPln7(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln7().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln7().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln7().setSizeCounterPlus("small");}
                space.getPln5().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet6) {
                if (space.getPln7().getRockets().length == 4 || space.getPln8().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                if (rocketsToMoveComplete[0].getColor() == "red") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "green") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "white") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.moveRocket(space.getPln7(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln7().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln7().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln7().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln8(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln8().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln8().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln8().setSizeCounterPlus("small");}
                space.getPln6().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet7) {
                if (space.getPln8().getRockets().length == 4 || space.getPln9().getRockets().length == 4 || space.getPln10().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln8(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln8().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln8().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln8().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln9(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln9().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln9().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln9().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.getPln7().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet8) {
                if (space.getPln9().getRockets().length == 4 || space.getPln10().getRockets().length == 4 || space.getPln11().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln9(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln9().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln9().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln9().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.getPln8().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet9) {
                if (space.getPln10().getRockets().length == 4 || space.getPln11().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                space.getPln9().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet10) {
                if (space.getPln11().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[2].getColor() == "red") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "blue") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "green") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "gray") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "white") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.getPln10().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet11) {
                if (space.getCountOfPlayers() > 3){
                    if (space.getPln13().getRockets().length == 4 || space.getPln11().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                else if (space.getCountOfPlayers() <= 3){
                    if (space.getPln1().getRockets().length == 4 ||  space.getPln11().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);
                        planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[1].getColor() == "red") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "green") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "white") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                if (space.getCountOfPlayers() > 3){
                    space.moveRocket(space.getPln13(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln13().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln13().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln13().setSizeCounterPlus("small");}}
                else if (space.getCountOfPlayers() <= 3){
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}}
                space.getPln11().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet12) {
                if (space.getCountOfPlayers() > 3){
                    if (space.getPln13().getRockets().length == 4 || space.getPln14().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                else if (space.getCountOfPlayers() <= 3){
                    if (space.getPln1().getRockets().length == 4 || space.getPln2().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                if (rocketsToMoveComplete[0].getColor() == "red") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "green") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "white") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                if (space.getCountOfPlayers() > 3){
                    space.moveRocket(space.getPln13(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln13().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln13().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln13().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln14(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln14().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln14().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln14().setSizeCounterPlus("small");}}
                else if (space.getCountOfPlayers() <= 3){
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln2(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}}
                space.getPln12().newRockets();
                rocketsMoved = true;
            } if (space.getCountOfPlayers() > 3){
                if (mainEvent.getSource() == planet13) {
                    if (space.getPln14().getRockets().length == 4 || space.getPln15().getRockets().length == 4 || space.getPln16().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln14(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln14().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln14().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln14().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln15(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln15().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln15().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln15().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.getPln13().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet14) {
                    if (space.getPln15().getRockets().length == 4 || space.getPln16().getRockets().length == 4 || space.getPln17().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln15(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln15().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln15().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln15().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.getPln14().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet15) {
                    if (space.getPln16().getRockets().length == 4 || space.getPln17().getRockets().length == 4 || space.getPln18().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    space.getPln15().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet16) {
                    if (space.getPln17().getRockets().length == 4 || space.getPln18().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    if (rocketsToMoveComplete[2].getColor() == "red") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[2].getColor() == "blue") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[2].getColor() == "green") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[2].getColor() == "gray") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[2].getColor() == "white") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.getPln16().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet17) {
                    if (space.getPln18().getRockets().length == 4 || space.getPln1().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    if (rocketsToMoveComplete[1].getColor() == "red") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "green") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "white") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.getPln17().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet18) {
                    if (space.getPln1().getRockets().length == 4 || space.getPln2().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    if (rocketsToMoveComplete[0].getColor() == "red") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "green") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "white") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln2(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}
                    space.getPln18().newRockets();
                    rocketsMoved = true;
                }
            }
        }
        if (rocketsToMoveComplete.length == 4) {
            if (mainEvent.getSource() == planet1) {
                if (space.getPln2().getRockets().length == 4 || space.getPln3().getRockets().length == 4 || space.getPln4().getRockets().length == 4 || space.getPln5().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln2(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln3(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[3]);
                if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.getPln1().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet2) {
                if (space.getPln3().getRockets().length == 4 || space.getPln4().getRockets().length == 4 || space.getPln5().getRockets().length == 4 || space.getPln6().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln3(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[3]);
                if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                space.getPln2().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet3) {
                if (space.getPln4().getRockets().length == 4 || space.getPln5().getRockets().length == 4 || space.getPln6().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln4(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln4().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln4().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln4().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[3].getColor() == "red") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[3].getColor() == "blue") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[3].getColor() == "green") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[3].getColor() == "gray") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[3].getColor() == "white") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.getPln3().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet4) {
                if (space.getPln5().getRockets().length == 4 || space.getPln6().getRockets().length == 4 || space.getPln7().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln5(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln5().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln5().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln5().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[2].getColor() == "red") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "blue") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "green") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "gray") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "white") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.moveRocket(space.getPln7(), rocketsToMoveComplete[3]);
                if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln7().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln7().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln7().setSizeCounterPlus("small");}
                space.getPln4().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet5) {
                if (space.getPln6().getRockets().length == 4 || space.getPln7().getRockets().length == 4 || space.getPln8().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln6(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln6().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln6().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln6().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[1].getColor() == "red") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "green") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "white") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.moveRocket(space.getPln7(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln7().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln7().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln7().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln8(), rocketsToMoveComplete[3]);
                if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln8().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln8().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln8().setSizeCounterPlus("small");}
                space.getPln5().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet6) {
                if (space.getPln7().getRockets().length == 4 || space.getPln8().getRockets().length == 4 || space.getPln9().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                if (rocketsToMoveComplete[0].getColor() == "red") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "green") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "white") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.moveRocket(space.getPln7(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln7().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln7().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln7().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln8(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln8().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln8().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln8().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln9(), rocketsToMoveComplete[3]);
                if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln9().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln9().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln9().setSizeCounterPlus("small");}
                space.getPln6().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet7) {
                if (space.getPln8().getRockets().length == 4 || space.getPln9().getRockets().length == 4 || space.getPln10().getRockets().length == 4 || space.getPln11().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln8(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln8().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln8().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln8().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln9(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln9().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln9().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln9().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[3]);
                if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.getPln7().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet8) {
                if (space.getPln9().getRockets().length == 4 || space.getPln10().getRockets().length == 4 || space.getPln11().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln9(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln9().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln9().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln9().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[3]);
                if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                space.getPln8().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet9) {
                if (space.getPln10().getRockets().length == 4 || space.getPln11().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                    infoLabel.setStyle("-fx-font-size: 20");
                    infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                    rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                    infoLabel.setVisible(true);
                    planetCanBeEnabled = true;
                    return;
                }
                space.moveRocket(space.getPln10(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln10().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln10().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln10().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[2]);
                if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[3].getColor() == "red") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[3].getColor() == "blue") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[3].getColor() == "green") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[3].getColor() == "gray") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[3].getColor() == "white") {
                    if (rocketsToMoveComplete[3].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[3].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                space.getPln9().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet10) {
                if (space.getCountOfPlayers() > 3) {
                    if (space.getPln13().getRockets().length == 4 || space.getPln11().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                } else if (space.getCountOfPlayers() <= 3){
                    if (space.getPln1().getRockets().length == 4 || space.getPln2().getRockets().length == 4 || space.getPln11().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                space.moveRocket(space.getPln11(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln11().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln11().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln11().setSizeCounterPlus("small");}
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[1]);
                if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[2].getColor() == "red") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "blue") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "green") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "gray") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[2].getColor() == "white") {
                    if (rocketsToMoveComplete[2].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[2].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                if (space.getCountOfPlayers() > 3){
                    space.moveRocket(space.getPln13(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln13().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln13().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln13().setSizeCounterPlus("small");}}
                else if (space.getCountOfPlayers() <= 3){
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}}
                space.getPln10().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet11) {
                if (space.getCountOfPlayers() > 3) {
                    if (space.getPln13().getRockets().length == 4 || space.getPln14().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                } else if (space.getCountOfPlayers() <= 3){
                    if (space.getPln1().getRockets().length == 4 || space.getPln2().getRockets().length == 4 || space.getPln3().getRockets().length == 4 || space.getPln12().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                space.moveRocket(space.getPln12(), rocketsToMoveComplete[0]);
                if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln12().setSizeCounterPlus("big");}
                else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln12().setSizeCounterPlus("medium");}
                else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln12().setSizeCounterPlus("small");}
                if (rocketsToMoveComplete[1].getColor() == "red") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "green") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[1].getColor() == "white") {
                    if (rocketsToMoveComplete[1].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[1].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                if (space.getCountOfPlayers() > 3){
                    space.moveRocket(space.getPln13(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln13().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln13().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln13().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln14(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln14().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln14().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln14().setSizeCounterPlus("small");}}
                else if (space.getCountOfPlayers() <= 3){
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln2(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}}
                space.getPln11().newRockets();
                rocketsMoved = true;
            }if (mainEvent.getSource() == planet12) {
                if (space.getCountOfPlayers() > 3) {
                    if (space.getPln13().getRockets().length == 4 || space.getPln14().getRockets().length == 4 || space.getPln15().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                } else if (space.getCountOfPlayers() <= 3){
                    if (space.getPln1().getRockets().length == 4 || space.getPln2().getRockets().length == 4 || space.getPln3().getRockets().length == 4) {
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                }
                if (rocketsToMoveComplete[0].getColor() == "red") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "green") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                        }
                    }
                } else if (rocketsToMoveComplete[0].getColor() == "white") {
                    if (rocketsToMoveComplete[0].getSize() == "big") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                        }
                    } else if (rocketsToMoveComplete[0].getSize() == "small") {
                        for (int i = 0; i < space.getPlayersArray().length; i++) {
                            if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                        }
                    }
                }
                if (space.getCountOfPlayers() > 3){
                    space.moveRocket(space.getPln13(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln13().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln13().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln13().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln14(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln14().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln14().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln14().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln15(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln15().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln15().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln15().setSizeCounterPlus("small");}}
                else if (space.getCountOfPlayers() <= 3){
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln2(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln3(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}}
                space.getPln12().newRockets();
                rocketsMoved = true;
            } if (space.getCountOfPlayers() > 3){
                if (mainEvent.getSource() == planet13) {
                    if (space.getPln14().getRockets().length == 4 || space.getPln15().getRockets().length == 4 || space.getPln16().getRockets().length == 4 || space.getPln17().getRockets().length == 4){
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln14(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln14().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln14().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln14().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln15(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln15().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln15().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln15().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.getPln13().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet14) {
                    if (space.getPln15().getRockets().length == 4 || space.getPln16().getRockets().length == 4 || space.getPln17().getRockets().length == 4 || space.getPln18().getRockets().length == 4){
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln15(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln15().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln15().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln15().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    space.getPln14().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet15) {
                    if (space.getPln16().getRockets().length == 4 || space.getPln17().getRockets().length == 4 || space.getPln18().getRockets().length == 4){
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln16(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln16().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln16().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln16().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    if (rocketsToMoveComplete[3].getColor() == "red") {
                        if (rocketsToMoveComplete[3].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[3].getColor() == "blue") {
                        if (rocketsToMoveComplete[3].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[3].getColor() == "green") {
                        if (rocketsToMoveComplete[3].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[3].getColor() == "gray") {
                        if (rocketsToMoveComplete[3].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[3].getColor() == "white") {
                        if (rocketsToMoveComplete[3].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[3].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.getPln15().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet16) {
                    if (space.getPln17().getRockets().length == 4 || space.getPln18().getRockets().length == 4 || space.getPln1().getRockets().length == 4){
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln17(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln17().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln17().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln17().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    if (rocketsToMoveComplete[2].getColor() == "red") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[2].getColor() == "blue") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[2].getColor() == "green") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[2].getColor() == "gray") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[2].getColor() == "white") {
                        if (rocketsToMoveComplete[2].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[2].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.getPln16().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet17) {
                    if (space.getPln18().getRockets().length == 4 || space.getPln1().getRockets().length == 4 || space.getPln2().getRockets().length == 4){
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);    planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    space.moveRocket(space.getPln18(), rocketsToMoveComplete[0]);
                    if (rocketsToMoveComplete[0].getSize() == "big"){space.getPln18().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[0].getSize() == "medium"){space.getPln18().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[0].getSize() == "small"){space.getPln18().setSizeCounterPlus("small");}
                    if (rocketsToMoveComplete[1].getColor() == "red") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "blue") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "green") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "gray") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[1].getColor() == "white") {
                        if (rocketsToMoveComplete[1].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[1].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln2(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}
                    space.getPln17().newRockets();
                    rocketsMoved = true;
                }if (mainEvent.getSource() == planet18) {
                    if (space.getPln1().getRockets().length == 4 || space.getPln2().getRockets().length == 4 || space.getPln3().getRockets().length == 4){
                        infoLabel.setStyle("-fx-font-size: 20");
                        infoLabel.setText("Full amount of rockets on one planet where you want to move rockets!");
                        rocketsMoved = false;someBRocket = false;someMRocket = false;someSRocket = false;
                        infoLabel.setVisible(true);
                        planet1.setDisable(false);planet2.setDisable(false);planet3.setDisable(false);planet4.setDisable(false);planet5.setDisable(false);planet6.setDisable(false);planet7.setDisable(false);planet8.setDisable(false);planet9.setDisable(false);planet10.setDisable(false);planet11.setDisable(false);planet12.setDisable(false);
                        if (space.getPlayersArray().length > 3) {planet13.setDisable(false);planet14.setDisable(false);planet15.setDisable(false);planet16.setDisable(false);planet17.setDisable(false);planet18.setDisable(false);}
                        return;
                    }
                    if (rocketsToMoveComplete[0].getColor() == "red") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "red") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "blue") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "blue") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "green") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "green") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "gray") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "gray") {smallRocketTextRewrite(i);}
                            }
                        }
                    } else if (rocketsToMoveComplete[0].getColor() == "white") {
                        if (rocketsToMoveComplete[0].getSize() == "big") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {bigRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "medium") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {mediumRocketTextRewrite(i);}
                            }
                        } else if (rocketsToMoveComplete[0].getSize() == "small") {
                            for (int i = 0; i < space.getPlayersArray().length; i++) {
                                if (space.getPlayersArray()[i].getColor() == "white") {smallRocketTextRewrite(i);}
                            }
                        }
                    }
                    space.moveRocket(space.getPln1(), rocketsToMoveComplete[1]);
                    if (rocketsToMoveComplete[1].getSize() == "big"){space.getPln1().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[1].getSize() == "medium"){space.getPln1().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[1].getSize() == "small"){space.getPln1().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln2(), rocketsToMoveComplete[2]);
                    if (rocketsToMoveComplete[2].getSize() == "big"){space.getPln2().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[2].getSize() == "medium"){space.getPln2().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[2].getSize() == "small"){space.getPln2().setSizeCounterPlus("small");}
                    space.moveRocket(space.getPln3(), rocketsToMoveComplete[3]);
                    if (rocketsToMoveComplete[3].getSize() == "big"){space.getPln3().setSizeCounterPlus("big");}
                    else if (rocketsToMoveComplete[3].getSize() == "medium"){space.getPln3().setSizeCounterPlus("medium");}
                    else if (rocketsToMoveComplete[3].getSize() == "small"){space.getPln3().setSizeCounterPlus("small");}
                    space.getPln18().newRockets();
                    rocketsMoved = true;
                }
            }
        }
    }
}