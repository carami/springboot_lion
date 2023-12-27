package sample.config;

import org.springframework.context.annotation.Bean;
import sample.Dice;

public class DiceGameConfig {
    @Bean
    public Dice dice(){
//        return new Dice(6);
        Dice dice = new Dice();
        dice.setFace(6);
        return dice;
    }
}
