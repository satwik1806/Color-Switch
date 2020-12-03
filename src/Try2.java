import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.transform.Rotate;

import javax.swing.*;

public class Try2 {
    @FXML
    Group circle;

    Rotate rotate = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
         rotate.setPivotX(400);
         rotate.setPivotY(300);
         rotate.setAngle(2);
         circle.getTransforms().add(rotate);

        }
    };

    public Try2(){
        timer.start();
    }
}
