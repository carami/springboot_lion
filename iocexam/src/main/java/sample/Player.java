package sample;

public class Player {
    private String name;
    private Dice dice;

    //DI  (의존성 주입..)  --  1. 필드기반주입, 2. 생성자기반 주입, 3 설정자기반 주입

    public Player(Dice dice){
        this.dice = dice;
    }

    public void setDice(Dice dice){
        this.dice = dice;
    }

    public void play(){
        System.out.println(name+"은 주사위를 던져서"+ dice.getNumber()+"가 나왔습니다.");
    }
}