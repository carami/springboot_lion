package sample;

public class Dice {
    private int face;

    public Dice(){
        System.out.println("Dice() 생성자 호출");
    }

    public void setFace(int face) {
        this.face = face;
    }

    public int getNumber(){
        return (int)(Math.random() * face) + 1 ;
    }
}
