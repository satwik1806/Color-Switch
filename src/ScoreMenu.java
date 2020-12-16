import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;

import java.io.IOException;
import java.io.Serializable;

public class ScoreMenu implements Serializable {
    @FXML
    private Group obs11;
    @FXML
    private Group obs22;
    @FXML
    private Button reload;
    @FXML
    private Button returnmain;
    @FXML
    private SVGPath star1;
    @FXML
    private SVGPath star2;
    @FXML
    private SVGPath star3;

    Rotate rotate11 = new Rotate();
    Rotate rotate22 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
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

            animatereload();animatestars();

        }
    };

    public void reloadgame(ActionEvent e){

        Frame.navigation.GoBack();
        Frame.navigation.GoBack();
        Frame.navigation.GoBack();
        Frame.navigation.load("Game_Screen.fxml");
    }

    public void returntomain(ActionEvent e) {
//        Frame.navigation.load("Player_Menu.fxml");
        Frame.navigation.GoBack();
        Frame.navigation.GoBack();
        Frame.navigation.GoBack();

    }

    private boolean less1 = false;
    public void animatereload(){
        double X=reload.getScaleX();
        if(X>=0.6)
            less1=true;
        if(X<=0.5)
            less1=false;
        if(less1)
        {
            reload.setScaleX(X-0.002);
            reload.setScaleY(X-0.002);
        }
        else
        {
            reload.setScaleX(X+0.002);
            reload.setScaleY(X+0.002);
        }
    }

    private boolean less = false;
    public void animatestars(){
        double X=reload.getScaleX()*4;
        if(X>=3)
            less=true;
        if(X<=2)
            less=false;
        if(less)
        {
            star1.setScaleX(X-0.002);
            star1.setScaleY(X-0.002);
            star2.setScaleX(X-0.002);
            star2.setScaleY(X-0.002);
            star3.setScaleX(X-0.002);
            star3.setScaleY(X-0.002);
        }
        else
        {
            star1.setScaleX(X+0.002);
            star1.setScaleY(X+0.002);
            star2.setScaleX(X+0.002);
            star2.setScaleY(X+0.002);
            star3.setScaleX(X+0.002);
            star3.setScaleY(X+0.002);
        }
    }

    public ScoreMenu(){ timer.start();}
}
