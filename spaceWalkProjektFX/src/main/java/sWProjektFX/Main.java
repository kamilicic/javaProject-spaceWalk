package sWProjektFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage){
        try {
            Parent root = FXMLLoader.load(Main.class.getResource("sceneMenu.fxml"));
            Scene scene = new Scene(root, 1400, 700);
            String css = Main.class.getResource("spaceWalkStyle.css").toExternalForm();
            scene.getStylesheets().add(css);

            Image icon = new Image(Main.class.getResourceAsStream("pics/spaceWalkLogo.jpg"));
            stage.getIcons().add(icon);
            stage.setTitle("Space Walk");

            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}