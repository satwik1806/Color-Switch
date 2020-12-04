import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;

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


    private ArrayList<Obstacle> onscreenobstacles = new ArrayList<>();
    private ArrayList<Collider> onscreencolliders=new ArrayList<>();

    private Star startest=new Star(55,-60);


    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if(check()) {
                rotate();
                fall();
                startest.starsize();
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
        for(Obstacle o: onscreenobstacles)
            o.rotate();
    }


    public void pauseclick(ActionEvent e) throws IOException {Frame.navigation.load("Pause.fxml"); }

    private double toadd = 0.02;
    private double add = 2;
    private boolean flag = true;
    private boolean jumphappened=false;
    private int jumpcount=0;
    public void jumpwanted(MouseEvent e){
        jumphappened=true;
    }

    private void jump()
    {
        flag = false;
        add = 1;
        ball.setTranslateY(ball.getTranslateY()-5);
        jumpcount+=1;
        if(ball.getTranslateY()<=-300)
        {
            for (Collider c:onscreencolliders)
                c.node().setLayoutY(c.node().getLayoutY()+2.5);
        }
    }

    public void fall(){
        if(!flag) {ball.setTranslateY(ball.getTranslateY()+add+toadd);add+=toadd;}
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        onscreenobstacles.add(new Obstacle_circle());
        onscreenobstacles.add(new Obstacle_2Windmill());
        for (Obstacle o:onscreenobstacles)
            onscreencolliders.add(o);

        onscreencolliders.add(startest);
        onscreencolliders.add(new ColorSwitch());

        for (Collider c:onscreencolliders)
            pane.getChildren().add(c.node());

        timer.start();
        ball.setFill(Paint.valueOf(colors[new Random().nextInt(4)]));
    }

    private String[] colors={"FAE100","900DFF","FF0181","32DBF0"};


    private void checkcollide()
    {
        for(Obstacle o: onscreenobstacles)
        {
            if(o.checkcollide(ball))
                break;
        }
    }



}
