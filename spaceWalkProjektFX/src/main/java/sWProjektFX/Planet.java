package sWProjektFX;

public class Planet{
    private Rocket[] rockets;
    private int bigSizeCounter, mediumSizeCounter, smallSizeCounter;

    public Planet(){
        this.rockets = new Rocket[0];
        bigSizeCounter = mediumSizeCounter = smallSizeCounter = 0;
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
    public void newRockets(){
        rockets = new Rocket[0];
        bigSizeCounter = mediumSizeCounter = smallSizeCounter = 0;
    }
    public void addRocket(Rocket arr[], Rocket rkt){
        rockets = addR(arr, rkt);
    }

    public Rocket[] getRockets() {
        return rockets;
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
    public void setSizeCounterMinus(String size) {
        if (size == "big") {
            this.bigSizeCounter--;
        }
        else if (size == "medium") {
            this.mediumSizeCounter--;
        }
        else if (size == "small") {
            this.smallSizeCounter--;
        }
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

    public void setBigSizeCounterZero(){
        this.bigSizeCounter = 0;
    }
    public void setMediumSizeCounterZero(){
        this.mediumSizeCounter = 0;
    }
    public void setSmallSizeCounterZero(){
        this.smallSizeCounter = 0;
    }
}
