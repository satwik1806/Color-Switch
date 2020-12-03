import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

public class Obstacle_Windmill extends Obstacle{

    private Group group;
    private Shape_rect rect1;
    private Shape_rect rect2;
    private Shape_rect rect3;
    private Shape_rect rect4;


    @Override
    public void display() {
        rect1 = new Shape_rect(50,150,"ff0181",144,140,164,38);
        rect2 = new Shape_rect(150,50,"#32dbf0",0,121,164,38);
        rect3 = new Shape_rect(50,150,"#900dff",145,-24,164,38);
        rect4 = new Shape_rect(150,50,"#fae100",162,121,38,164);

        group.getChildren().addAll(rect1.getRect(),rect2.getRect(),rect3.getRect(),rect4.getRect());

        //gourp properties
        group.setLayoutX(30);
        group.setLayoutY(322);
        group.setScaleX(0.35);
        group.setScaleY(0.35);

    }

    @Override
    public boolean checkcollide(Circle c) {
        return false;
    }

    @Override
    public void rotate() {
        Rotate rotate = new Rotate();
        rotate.setPivotX(163);
        rotate.setPivotY(140);
        rotate.setAngle(2);
        group.getTransforms().add(rotate);
    }
}
