import javafx.scene.Node;

public interface Collider {
    void display();
    Node node();
    boolean collide(Ball b);
    String[] colors={"FAE100","900DFF","FF0181","32DBF0"};
}
