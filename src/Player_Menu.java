import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

public class Player_Menu {
    @FXML
    private Group obs1;
    @FXML
    private Group obs2;
    @FXML
    private Group obs3;
    @FXML
    private Group obs4;

    Rotate rotate1 = new Rotate();
    Rotate rotate2 = new Rotate();
    Rotate rotate3 = new Rotate();
    Rotate rotate4 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            //1
            rotate1.setPivotX(0);
            rotate1.setPivotY(0);
            rotate1.setAxis(new Point3D(0,0,1));
            obs1.getTransforms().addAll(rotate1);
            rotate1.setAngle(1);

            //2
            rotate2.setPivotX(0);
            rotate2.setPivotY(0);
            rotate2.setAxis(new Point3D(0,0,1));
            obs2.getTransforms().addAll(rotate2);
            rotate2.setAngle(-1.5);

            //3
            rotate3.setPivotX(0);
            rotate3.setPivotY(0);
            rotate3.setAxis(new Point3D(0,0,1));
            obs3.getTransforms().addAll(rotate3);
            rotate3.setAngle(2);

            //4
            rotate4.setPivotX(71);
            rotate4.setPivotY(168);
            rotate4.setAxis(new Point3D(0,0,1));
            obs4.getTransforms().addAll(rotate4);
            rotate4.setAngle(2);
        }
    };

    public Player_Menu(){
        timer.start();
    }
}
