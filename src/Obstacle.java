import javafx.scene.Group;
import javafx.scene.shape.Circle;

public abstract class Obstacle {

    protected String[] colors={"FAE100","900DFF","FF0181","32DBF0"};
    protected Group group = new Group();

    public abstract boolean checkcollide(Circle c);

    public abstract void rotate();

    public abstract void display();

    public Group getGroup(){return group;}

}

