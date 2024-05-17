package sWProjektFX;

public class Space {
    private Player p1, p2, p3, p4, p5;
    private Player[] playersArray;
    private int countOfPlayers;
    private Planet pln1, pln2, pln3, pln4, pln5, pln6, pln7, pln8, pln9, pln10, pln11, pln12, pln13, pln14, pln15,
            pln16, pln17, pln18;

    public Space(Player pl1, Player pl2, Player pl3, Player pl4, Player pl5, int countOfPlayers) {
        this.countOfPlayers = countOfPlayers;
        this.playersArray = new Player[0];
        p1 = pl1; p2 = pl2; p3 = pl3; p4 = pl4; p5 = pl5;
        pln1 = new Planet(); pln2 = new Planet(); pln3 = new Planet(); pln4 = new Planet();pln5 = new Planet(); pln6 = new Planet(); pln7 = new Planet(); pln8 = new Planet();pln9 = new Planet(); pln10 = new Planet(); pln11 = new Planet(); pln12 = new Planet();
        if (this.countOfPlayers == 4 || this.countOfPlayers == 5){
            pln13 = new Planet(); pln14 = new Planet(); pln15 = new Planet(); pln16 = new Planet();pln17 = new Planet(); pln18 = new Planet();
        }
    }

    public Player[] addP(Player arr[], Player plr)
    {
        int n = arr.length;
        Player players[] = new Player[n + 1];
        for (int i = 0; i < n; i++) {
            players[i] = arr[i];
        }
        players[n] = plr;
        return players;
    }
    public void addPlayer(Player arr[], Player plr){
        playersArray = addP(arr, plr);
    }

    public Player[] getPlayersArray() {
        return playersArray;
    }

    public int getCountOfPlayers() {
        return countOfPlayers;
    }

    public Player getP1() {
        return p1;
    }

    public Player getP2() {
        return p2;
    }

    public Player getP3() {
        return p3;
    }

    public Player getP4() {
        return p4;
    }

    public Player getP5() {
        return p5;
    }

    public Planet getPln1() {
        return pln1;
    }

    public Planet getPln2() {
        return pln2;
    }

    public Planet getPln3() {
        return pln3;
    }

    public Planet getPln4() {
        return pln4;
    }

    public Planet getPln5() {
        return pln5;
    }

    public Planet getPln6() {
        return pln6;
    }

    public Planet getPln7() {
        return pln7;
    }

    public Planet getPln8() {
        return pln8;
    }

    public Planet getPln9() {
        return pln9;
    }

    public Planet getPln10() {
        return pln10;
    }

    public Planet getPln11() {
        return pln11;
    }

    public Planet getPln12() {
        return pln12;
    }

    public Planet getPln13() {
        return pln13;
    }

    public Planet getPln14() {
        return pln14;
    }

    public Planet getPln15() {
        return pln15;
    }

    public Planet getPln16() {
        return pln16;
    }

    public Planet getPln17() {
        return pln17;
    }

    public Planet getPln18() {
        return pln18;
    }
    public void placeRocket(Planet pln, Rocket rck){
        pln.addRocket(pln.getRockets(), rck);
    }
    public void moveRocket(Planet pln, Rocket rck){
        pln.addRocket(pln.getRockets(), rck);
    }
}
