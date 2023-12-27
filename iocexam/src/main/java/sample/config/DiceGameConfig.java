package sample.config;

import org.springframework.context.annotation.Bean;
import sample.Dice;
import sample.Game;
import sample.Player;

import java.util.List;

public class DiceGameConfig {
    @Bean
    public Dice dice(){
//        return new Dice(6);
        Dice dice = new Dice();
        dice.setFace(6);
        return dice;
    }

    @Bean
    public Player kang(Dice dice){
        return new Player("강경미",dice);
    }

    @Bean
    public Player kim(Dice dice){
        return new Player("김길동",dice);
    }

    @Bean
    public Player hong(Dice dice){
        return new Player("홍둘리",dice);
    }

    @Bean
    public Player lee(Dice dice){
        return new Player("이또치",dice);
    }

    @Bean
    public Game game(List<Player> players){
        return new Game(players);
    }
}
