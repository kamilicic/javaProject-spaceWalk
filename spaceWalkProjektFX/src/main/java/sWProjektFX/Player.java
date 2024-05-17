package sWProjektFX;

public class Player{
    private String color;
    private int tokens;
    private int bigSizeCounter, mediumSizeCounter, smallSizeCounter;
    public void setColor(String color) {
        this.color = color;
        tokens = 3;
        bigSizeCounter = mediumSizeCounter = smallSizeCounter = 0;
    }
    public String getColor() {
        return color;
    }
    public int getBigSizeCounter() {
        return bigSizeCounter;
    }
    public int getMediumSizeCounter() {
        return mediumSizeCounter;
    }
    public int getSmallSizeCounter() {
        return smallSizeCounter;
    }
    public void setBigSizeCounterMinus() {
        this.bigSizeCounter--;
    }
    public void setMediumSizeCounterMinus() {
        this.mediumSizeCounter--;
    }
    public void setSmallSizeCounterMinus() {
        this.smallSizeCounter--;
    }
    public void setSizeCounterPlus(String size) {
        if (size == "big") {
            this.bigSizeCounter++;
        }
        else if (size == "medium") {
            this.mediumSizeCounter++;
        }
        else if (size == "small") {
            this.smallSizeCounter++;
        }
    }
    public int getAllRocketsCount(){
        return bigSizeCounter + mediumSizeCounter + smallSizeCounter;
    }
    public int getTokens(){
        return tokens;
    }
    public void setTokensMinus(){
        this.tokens --;
    }
    public void setTokens0(){
        this.tokens = 0;
    }
}
