import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

public class Obstacle_ConcentricCircle extends Obstacle {

    private Shape_quartcircle q1;
    private Shape_quartcircle q2;
    private Shape_quartcircle q3;
    private Shape_quartcircle q4;

    private Rotate rotate1 = new Rotate();

    private Shape_quartcircle q5;
    private Shape_quartcircle q6;
    private Shape_quartcircle q7;
    private Shape_quartcircle q8;

    private Rotate rotate2 = new Rotate();

    private Group grp1 = new Group();
    private Group grp2 = new Group();

    @Override
    public boolean checkcollide(Circle c) {
        return false;
    }

    @Override
    public void rotate() {
        rotate1.setPivotX(400);
        rotate1.setPivotY(300);
        rotate1.setAngle(1);
        grp1.getTransforms().add(rotate1);

        rotate2.setPivotX(400);
        rotate2.setPivotY(300);
        rotate2.setAngle(-1.5);
        grp2.getTransforms().add(rotate2);
    }

    @Override
    public void display() {
        q1=new Shape_quartcircle(0,0,0,colors[0]);
        q2=new Shape_quartcircle(250,250,180,colors[1]);
        q3=new Shape_quartcircle(0,250,-90,colors[2]);
        q4=new Shape_quartcircle(250,0,90,colors[3]);

        grp1.getChildren().addAll(q1.getQuat(),q2.getQuat(),q3.getQuat(),q4.getQuat());

        //group properties
        grp1.setLayoutX(-150);
        grp1.setLayoutY(-170);
        grp1.setScaleX(0.3);
        grp1.setScaleY(0.3);

        q5=new Shape_quartcircle(0,0,0,colors[0]);
        q6=new Shape_quartcircle(250,250,180,colors[1]);
        q7=new Shape_quartcircle(0,250,-90,colors[2]);
        q8=new Shape_quartcircle(250,0,90,colors[3]);

        grp2.getChildren().addAll(q5.getQuat(),q6.getQuat(),q7.getQuat(),q8.getQuat());
        //group properties
        grp2.setLayoutX(-150);
        grp2.setLayoutY(-170);
        grp2.setScaleX(0.45);
        grp2.setScaleY(0.45);

        group.getChildren().addAll(grp1,grp2);
    }

    public Obstacle_ConcentricCircle(){
        display();
    }
}
