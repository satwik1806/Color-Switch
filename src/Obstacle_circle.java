import javafx.scene.shape.Circle;
import javafx.scene.transform.Rotate;

public class Obstacle_circle extends Obstacle {


    private Shape_quartcircle q1;
    private Shape_quartcircle q2;
    private Shape_quartcircle q3;
    private Shape_quartcircle q4;


    private Rotate rotate_obj = new Rotate();


    @Override
    public boolean checkcollide(Circle c) {
        return false;
    }

    @Override
    public void rotate() {
        rotate_obj.setPivotX(400);
        rotate_obj.setPivotY(300);
        rotate_obj.setAngle(2);
        group.getTransforms().add(rotate_obj);
    }

    @Override
    public void display() {
        q1=new Shape_quartcircle(0,0,0,colors[0]);
        q1=new Shape_quartcircle(250,250,90,colors[1]);
        q1=new Shape_quartcircle(0,250,-90,colors[2]);
        q1=new Shape_quartcircle(250,0,90,colors[3]);

        //group properties
        group.setLayoutX(30);
        group.setLayoutY(322);
        group.setScaleX(0.35);
        group.setScaleY(0.35);
    }

    public Obstacle_circle() {
        display();
    }
}
