import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.StrokeType;

public class ColorSwitch implements Collider{

    private Arc a1=new Arc();
    private Arc a2=new Arc();
    private Arc a3=new Arc();
    private Arc a4=new Arc();

    private Group g=new Group();

    public ColorSwitch()
    {
        display();
    }


    @Override
    public void display() {
        a1.setFill(Paint.valueOf(colors[0]));
        a2.setFill(Paint.valueOf(colors[1]));
        a3.setFill(Paint.valueOf(colors[2]));
        a4.setFill(Paint.valueOf(colors[3]));
        a1.setLength(90);
        a2.setLength(90);
        a3.setLength(90);
        a4.setLength(90);
        a1.setRadiusX(100);
        a1.setRadiusY(100);
        a2.setRadiusX(100);
        a2.setRadiusY(100);
        a3.setRadiusX(100);
        a3.setRadiusY(100);
        a4.setRadiusX(100);
        a4.setRadiusY(100);
        a1.setStartAngle(0);
        a2.setStartAngle(90);
        a3.setStartAngle(180);
        a4.setStartAngle(270);
        a1.setType(ArcType.ROUND);
        a2.setType(ArcType.ROUND);
        a3.setType(ArcType.ROUND);
        a4.setType(ArcType.ROUND);
        a1.setStroke(Paint.valueOf("BLACK"));
        a3.setStroke(Paint.valueOf("BLACK"));
        a2.setStroke(Paint.valueOf("BLACK"));
        a4.setStroke(Paint.valueOf("BLACK"));
        a1.setStrokeType(StrokeType.INSIDE);
        a2.setStrokeType(StrokeType.INSIDE);
        a3.setStrokeType(StrokeType.INSIDE);
        a4.setStrokeType(StrokeType.INSIDE);
        g.getChildren().addAll(a1,a2,a3,a4);
        g.setLayoutX(250);
        g.setLayoutY(317);
        g.setScaleX(0.15);
        g.setScaleY(0.15);
    }

    @Override
    public Node node() {
        return g;
    }

    @Override
    public boolean collide(Ball b) {
        return false;
    }
}
