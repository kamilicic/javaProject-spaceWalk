package sWProjektFX;

public class PlanetXPlayer {
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
    public void setSizeCounterPlus(String size, int sizeCounter1, int sizeCounter2, int sizeCounter3) {
        if (size == "big") {
            sizeCounter1++;
        }
        else if (size == "medium") {
            sizeCounter2++;
        }
        else if (size == "small") {
            sizeCounter3++;
        }
    }
}
