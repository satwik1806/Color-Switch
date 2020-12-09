import javafx.scene.paint.Paint;

public abstract class Shapes implements Collider {
    protected float layoutx;
    protected float layouty;
    protected String color;

    public abstract void display();

    public abstract Paint getcolor();
}
