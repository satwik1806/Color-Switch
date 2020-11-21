import javafx.animation.Animation;
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

public class Player_Menu {
    @FXML
    private Group obs1;
    @FXML
    private Group obs2;
    @FXML
    private Group obs11;
    @FXML
    private Group obs22;
    @FXML
    private Group obs3;
    @FXML
    private Group obs4;
    @FXML
    private Button newgame;
    @FXML
    private Button backtologin;
    @FXML
    private Button loadgame;

    Rotate rotate1 = new Rotate();
    Rotate rotate2 = new Rotate();
    Rotate rotate11 = new Rotate();
    Rotate rotate22 = new Rotate();
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

            //11
            rotate11.setPivotX(0);
            rotate11.setPivotY(0);
            rotate11.setAxis(new Point3D(0,0,1));
            obs11.getTransforms().addAll(rotate11);
            rotate11.setAngle(1.5);

            //22
            rotate22.setPivotX(0);
            rotate22.setPivotY(0);
            rotate22.setAxis(new Point3D(0,0,1));
            obs22.getTransforms().addAll(rotate22);
            rotate22.setAngle(1.5);

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

    public void New_Game(ActionEvent e) throws IOException {
        Stage s = (Stage) newgame.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Game_Screen.fxml"));
        s.setScene(new Scene(root,480,700));
        s.show();
    }

    public void backlogin() throws IOException {
        Stage s = (Stage) backtologin.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Login_Menu.fxml"));
        s.setScene(new Scene(root,480,700));
        s.show();
    }
}
