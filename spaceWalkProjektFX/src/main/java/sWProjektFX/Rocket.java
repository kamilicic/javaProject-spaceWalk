package sWProjektFX;

import javafx.scene.image.Image;

public class Rocket {
    private final String color;
    private String size;
    private Image rocImg;

    public Rocket(String color, String size) {
        this.color = color;
        this.size = size;
        setRocImg();
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    public void setRocImg() {
        if (size == "big") {
            if (color == "red") {rocImg = new Image(getClass().getResourceAsStream("pics/bigRocketRed.png"));}
            else if (color == "blue") {rocImg = new Image(getClass().getResourceAsStream("pics/bigRocketBlue.png"));}
            else if (color == "green") {rocImg = new Image(getClass().getResourceAsStream("pics/bigRocketGreen.png"));}
            else if (color == "gray") {rocImg = new Image(getClass().getResourceAsStream("pics/bigRocketGray.png"));}
            else if (color == "white") {rocImg = new Image(getClass().getResourceAsStream("pics/bigRocketWhite.png"));}
        }
        else if (size == "medium") {
            if (color == "red") {rocImg = new Image(getClass().getResourceAsStream("pics/mediumRocketRed.png"));}
            else if (color == "blue") {rocImg = new Image(getClass().getResourceAsStream("pics/mediumRocketBlue.png"));}
            else if (color == "green") {rocImg = new Image(getClass().getResourceAsStream("pics/mediumRocketGreen.png"));}
            else if (color == "gray") {rocImg = new Image(getClass().getResourceAsStream("pics/mediumRocketGray.png"));}
            else if (color == "white") {rocImg = new Image(getClass().getResourceAsStream("pics/mediumRocketWhite.png"));}
        }
        else if (size == "small") {
            if (color == "red") {rocImg = new Image(getClass().getResourceAsStream("pics/smallRocketRed.png"));}
            else if (color == "blue") {rocImg = new Image(getClass().getResourceAsStream("pics/smallRocketBlue.png"));}
            else if (color == "green") {rocImg = new Image(getClass().getResourceAsStream("pics/smallRocketGreen.png"));}
            else if (color == "gray") {rocImg = new Image(getClass().getResourceAsStream("pics/smallRocketGray.png"));}
            else if (color == "white") {rocImg = new Image(getClass().getResourceAsStream("pics/smallRocketWhite.png"));}
        }
    }

    public void rocketDescription() {
        System.out.println(size + " " + color + " rocket");
    }

    public Image getRocImg() {return rocImg;}
}
