import java.io.Serializable;
import java.util.ArrayList;

public class Game_State implements Serializable {
//    private ArrayList<coliider_state> collidernumber = new ArrayList<>();
    private ArrayList<Collider_state> allcolliders = new ArrayList<>();
    private int score;
    private double ball_y;
    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getBall_y() {
        return ball_y;
    }

    public void setBall_y(double ball_y) {
        this.ball_y = ball_y;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


    public ArrayList<Collider_state> getAllcolliders() {
        return allcolliders;
    }

    public void setAllcolliders(ArrayList<Collider_state> allcolliders) {
        this.allcolliders = allcolliders;
    }

    public void addcollider(Collider_state col) {
        allcolliders.add(col);
    }
}
