import javafx.scene.Group;
import javafx.scene.shape.Circle;

public abstract class Obstacle {

    protected Group group;

    public abstract boolean checkcollide(Circle c);

    public abstract void rotate();

    public abstract void display();

    public Group getGroup(){return group;}

}

