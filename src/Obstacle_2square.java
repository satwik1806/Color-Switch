import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

public class Obstacle_2square extends Obstacle {

    private Shape_rect rect1;
    private Shape_rect rect2;
    private Shape_rect rect3;
    private Shape_rect rect4;

    private Shape_rect rect5;
    private Shape_rect rect6;
    private Shape_rect rect7;
    private Shape_rect rect8;

    private Group grp1; //bigger square
    private Group grp2; //small square

    @Override
    public void display() {
        rect1 = new Shape_rect(50,100,"#fae100",0,0,261,26);
        rect2 = new Shape_rect(50,100,"#900dff",118,-116,261,26);
        rect3 = new Shape_rect(50,100,"#32dbf0",235,0,261,26);
        rect4 = new Shape_rect(50,100,"#ff0181",118,117,261,26);

        grp1.getChildren().addAll(rect1.getRect(),rect2.getRect(),rect3.getRect(),rect4.getRect());

        //group1 properties
        grp1.setLayoutX(119);
        grp1.setScaleX(0.6);
        grp1.setScaleY(0.6);

        rect5 = new Shape_rect(50,100,"#fae100",0,0,261,26);
        rect6 = new Shape_rect(50,100,"#900dff",118,-116,261,26);
        rect7 = new Shape_rect(50,100,"#32dbf0",235,0,261,26);
        rect8 = new Shape_rect(50,100,"#ff0181",118,117,261,26);

        grp2.getChildren().addAll(rect5.getRect(),rect6.getRect(),rect7.getRect(),rect8.getRect());

        //group2 properties
        grp2.setLayoutX(119);
        grp2.setRotate(45);
        grp2.setScaleX(0.4);
        grp2.setScaleY(0.4);

        group.getChildren().addAll(grp1,grp2);

        //group properties
        group.setLayoutX(119);

    }
    private Rotate rotatesquare1 = new Rotate();
    private Rotate rotatesquare2 = new Rotate();

    @Override
    public void rotate() {
        //rotate big square
        rotatesquare1.setPivotX(130.75);
        rotatesquare1.setPivotY(130.5);
        rotatesquare1.setAxis(new Point3D(0,0,1));
        grp1.getTransforms().addAll(rotatesquare1);
        rotatesquare1.setAngle(1.5);

        //rotate small square
        rotatesquare2.setPivotX(130.75);
        rotatesquare2.setPivotY(130.5);
        rotatesquare2.setAxis(new Point3D(0,0,1));
        grp2.getTransforms().addAll(rotatesquare2);
        rotatesquare2.setAngle(-1);
    }

    @Override
    public boolean checkcollide(Circle c) {
        return false;
    }
}
