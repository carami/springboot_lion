package sample;

import java.util.List;

public class Game {
    private List<Player> players;

    //DI

    public void play(){
        for(Player player : players){
            player.play();
        }
    }
}
