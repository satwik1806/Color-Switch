import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

import java.util.ArrayList;

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
    public boolean collide(Ball c) {
        for(Shape_quartcircle s:allshapes)
        {
            if(s.collide(c) && !s.getQuat().getFill().equals(c.getBallColor()))
                return true;

        }
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

    private ArrayList<Shape_quartcircle> allshapes = new ArrayList<>();

    @Override
    public void display() {
        q1=new Shape_quartcircle(0,0,0,colors[0]);
        q2=new Shape_quartcircle(250,250,180,colors[1]);
        q3=new Shape_quartcircle(0,250,-90,colors[2]);
        q4=new Shape_quartcircle(250,0,90,colors[3]);

        allshapes.add(q1);
        allshapes.add(q2);
        allshapes.add(q3);
        allshapes.add(q4);

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

        allshapes.add(q5);
        allshapes.add(q6);
        allshapes.add(q7);
        allshapes.add(q8);

        grp2.getChildren().addAll(q5.getQuat(),q6.getQuat(),q7.getQuat(),q8.getQuat());
        //group properties
        grp2.setLayoutX(-150);
        grp2.setLayoutY(-170);
        grp2.setScaleX(0.45);
        grp2.setScaleY(0.45);
        grp1.setRotate(5);
//        grp2.setRotate(10);

        group.getChildren().addAll(grp1,grp2);
        group.setScaleY(0.85);
        group.setScaleX(0.85);
    }

    public Obstacle_ConcentricCircle(){
        display();
    }
}
