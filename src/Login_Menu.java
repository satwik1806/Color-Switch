import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

public class Login_Menu {

    @FXML
    private Group obs1;
    @FXML
    private Group obs2;

    Rotate rotate1 = new Rotate();
    Rotate rotate2 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            rotate1.setPivotX(0);
            rotate1.setPivotY(0);
            rotate1.setAxis(new Point3D(0,0,1));
            rotate2.setPivotX(163);
            rotate2.setPivotY(140);
            rotate2.setAxis(new Point3D(0,0,1));
            obs1.getTransforms().addAll(rotate1);
            obs2.getTransforms().addAll(rotate2);
            rotate1.setAngle(1);
            rotate2.setAngle(1);
        }
    };

    public Login_Menu(){
        timer.start();
    }

}
