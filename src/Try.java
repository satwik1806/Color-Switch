import javafx.animation.AnimationTimer;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.util.Duration;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class Try {

    @FXML
    private Group grp1;
    @FXML
    Button but = new Button();

    Rotate rotate  = new Rotate();
    int var = 0;

//    @FXML
//    public void clickk(ActionEvent E){
//        rotate.setPivotX(300);
//        rotate.setPivotY(100);
//        grp1.getTransforms().addAll(rotate);
//        rotate.setAngle(var);
//        var+=45;
//    }

    public void trying() throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("Try.fxml"));

    }

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            rotate.setPivotX(162);
            rotate.setPivotY(140);
//        rotate.setPivotZ(1);
            rotate.setAxis(new Point3D(0, 0, 1));
            grp1.getTransforms().addAll(rotate);
            rotate.setAngle(var + 1);

        }
    };
    public void clickk(javafx.event.ActionEvent actionEvent) {
            timer.start();
    }

}
