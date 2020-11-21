import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

import java.io.IOException;

public class Login_Menu {

    @FXML
    private Group obs1;
    @FXML
    private Group obs2;
    @FXML
    private Button newplayer;

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
            rotate1.setAngle(2);
            rotate2.setAngle(2);
        }
    };

    public Login_Menu(){
        timer.start();
    }

    public void exit(ActionEvent e){System.exit(0);}

    public void New_Player(ActionEvent e) throws IOException {
        Stage s = (Stage) newplayer.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Player_Menu.fxml"));
        s.setScene(new Scene(root,480,700));
        s.show();
    }

}
