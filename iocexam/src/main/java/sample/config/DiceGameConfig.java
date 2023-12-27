package sample.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import sample.Dice;
import sample.Game;
import sample.Player;

import java.util.List;

@PropertySource({"classpath:game.properties"})
public class DiceGameConfig {
    @Bean
    public Dice dice(@Value("${face}") int face){
//        return new Dice(6);
        Dice dice = new Dice();
        dice.setFace(face);
        return dice;
    }

    @Bean
    public Player kang(Dice dice){
//        return new Player("강경미",dice);
        Player player = new Player();
        player.setDice(dice);
        player.setName("강경미");
        return player;
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
//        return new Game(players);
        Game game = new Game();
        game.setPlayers(players);
        return game;
    }
}
