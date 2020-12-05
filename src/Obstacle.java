import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.shape.Circle;

public abstract class Obstacle implements Collider {

    protected String[] colors={"FAE100","900DFF","FF0181","32DBF0"};
    protected Group group = new Group();

    public abstract boolean collide(Ball c);

    public abstract void rotate();


    @Override
    public Node node() {
        return group;
    }
}

