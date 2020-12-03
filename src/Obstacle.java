import javafx.scene.Group;
import javafx.scene.shape.Circle;

public abstract class Obstacle {

    protected Group g;

    public abstract boolean checkcollide(Circle c);

    public abstract void rotate();

    public Group getGroup(){return g;}


}

