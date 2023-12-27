package sample;

import java.util.List;

public class Game {
    private List<Player> players;

    //DI

//    public Game(List<Player> players) {
//        this.players = players;
//    }


    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void play(){
        for(Player player : players){
            player.play();
        }
    }
}
