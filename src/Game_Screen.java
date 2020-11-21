import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;


public class Game_Screen {
    @FXML
    private Group left;
    @FXML
    private Group right;
    @FXML
    private Group sq1;
    @FXML
    private Group sq2;
    @FXML
    private Circle ball;
    @FXML
    private Group colorswitch;
    @FXML
    public Button pause;
    @FXML
    public AnchorPane pane;
    @FXML
    public SVGPath star;

    Rotate rotateleft = new Rotate();
    Rotate rotateright = new Rotate();
    Rotate rotatesquare1 = new Rotate();
    Rotate rotatesquare2 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            //left
            rotateleft.setPivotX(163);
            rotateleft.setPivotY(140);
            rotateleft.setAxis(new Point3D(0,0,1));
            left.getTransforms().addAll(rotateleft);
            rotateleft.setAngle(1);

            //2
            rotateright.setPivotX(163);
            rotateright.setPivotY(140);
            rotateright.setAxis(new Point3D(0,0,1));
            right.getTransforms().addAll(rotateright);
            rotateright.setAngle(-1.5);

            //3
            rotatesquare1.setPivotX(130.75);
            rotatesquare1.setPivotY(130.5);
            rotatesquare1.setAxis(new Point3D(0,0,1));
            sq1.getTransforms().addAll(rotatesquare1);
            rotatesquare1.setAngle(1.5);

            //4
            rotatesquare2.setPivotX(130.75);
            rotatesquare2.setPivotY(130.5);
            rotatesquare2.setAxis(new Point3D(0,0,1));
            sq2.getTransforms().addAll(rotatesquare2);
            rotatesquare2.setAngle(-1);

            fall();
            starsize();
        }
    };

    private boolean less=false;

    void starsize()
    {

        double X=star.getScaleX();
        if(X>=0.7)
            less=true;
        if(X<=0.6)
            less=false;
        if(less)
        {
            star.setScaleX(X-0.005);
            star.setScaleY(X-0.005);
        }
        else
        {
            star.setScaleX(X+0.005);
            star.setScaleY(X+0.005);
        }
    }

    public void pauseclick(ActionEvent e) throws IOException {
        Stage s = (Stage) pause.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Game_Screen.fxml"));
        s.setScene(new Scene(root,480,700));
        s.show();
    }

    public void jump(MouseEvent e){
//        ball.setTranslateY(1);
        ball.setTranslateY(ball.getTranslateY()-60);
    }

    public void fall(){
        ball.setTranslateY(ball.getTranslateY()+1);
    }

    public Game_Screen(){
        timer.start();
    }


}
