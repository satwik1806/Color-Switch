import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.scene.transform.Rotate;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;


public class Game_Screen implements Initializable {
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


    private ArrayList<Obstacle> onscreen;


    Rotate rotateleft = new Rotate();
    Rotate rotateright = new Rotate();
    Rotate rotatesquare1 = new Rotate();
    Rotate rotatesquare2 = new Rotate();

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if(check()) {
                rotate();
                fall();
                starsize();
                if (jumphappened) {
                    jump();
                    jumphappened = !(jumpcount > 10);
                    if (!jumphappened)
                        jumpcount = 0;
                }
            }
        }
    };

    private boolean less=false;

    boolean check()
    {
        if(s==null)
        {
            s=pane.getScene();
            if(s!=null)
                root=s.getRoot();
            return true;
        }
        return s.getRoot().equals(root);
    }

    private Scene s;
    private Parent root;



    void rotate()
    {

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
    }


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

        Frame.navigation.load("Pause.fxml");

//        Stage s = (Stage) pause.getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("Pause.fxml"));
//        s.setScene(new Scene(root,480,700));
//        s.show();
    }

    private double toadd = 0.01;
    private double add = 1;
    private boolean flag = true;
    private boolean jumphappened=false;
    private int jumpcount=0;
    public void jumpwanted(MouseEvent e){
//        ball.setTranslateY(1);
        jumphappened=true;
    }

    private void jump()
    {
        flag = false;
        add = 1;
        ball.setTranslateY(ball.getTranslateY()-5);
        jumpcount+=1;
    }

    public void fall(){
        if(!flag) {ball.setTranslateY(ball.getTranslateY()+add+toadd);add+=toadd;}
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        timer.start();
        ball.setFill(Paint.valueOf(colors[new Random().nextInt(4)]));
    }

    private String[] colors={"FAE100","900DFF","FF0181","32DBF0"};


    private void checkcollide()
    {
        for(Obstacle o:onscreen)
        {
            if(o.checkcollide(ball))
                break;
        }
    }



}
