import javafx.scene.paint.Paint;
import javafx.scene.shape.SVGPath;

public class Shape_quartcircle extends Shapes {

    private SVGPath quat;
    private int rotate;
    public Shape_quartcircle(float layoutx, float layouty, int rotate, String color) {
        this.layoutx = layoutx;
        this.layouty = layouty;
        this.rotate = rotate;
        this.color = color;

    }

    @Override
    public void display() {
        quat.setContent("M 150 300 Q 150 50 400 50 L 400 100 Q 200 100 200 300 L 150 300");
        quat.setFill(Paint.valueOf(color));
        quat.setLayoutX(layoutx);
        quat.setLayoutY(layouty);
        quat.setRotate(rotate);
    }


}
