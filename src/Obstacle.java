import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

public abstract class Obstacle {

    protected Group group;

    protected String[] colors={"FAE100","900DFF","FF0181","32DBF0"};


    public abstract boolean checkcollide(Circle c);

    public abstract void rotate();

    public Group getGroup(){return group;}

    public abstract void display();

}

